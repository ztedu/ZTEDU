package cn.everlook.myweb.aop;

/**
 * 系统日志切点类
 *
 * @author Administrator
 * @createDate 2019/5/21
 */

import cn.everlook.myweb.annotation.log.SystemControllerLog;
import cn.everlook.myweb.commons.util.utils.DateUtils;
import cn.everlook.myweb.commons.util.utils.UuidUtils;
import cn.everlook.myweb.persistence.entity.assort.log.CommSysLog;
import cn.everlook.myweb.persistence.entity.assort.rbac.user.CommSysUser;
import cn.everlook.myweb.persistence.entity.dto.rbac.user.ActiverUser;
import cn.everlook.myweb.service.system.Log.system_log.ILogService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NamedThreadLocal;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@Aspect
@Component
public class SystemLogAspect {
  private static final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);
  
  private static final ThreadLocal<Date> beginTimeThreadLocal = new NamedThreadLocal<Date>("ThreadLocal beginTime");
  private static final ThreadLocal<CommSysLog> logThreadLocal = new NamedThreadLocal<CommSysLog>("ThreadLocal log");
  
  private static final ThreadLocal<CommSysUser> currentUser = new NamedThreadLocal<>("ThreadLocal user");
  
  @Autowired(required = false)
  private HttpServletRequest request;
  
  @Autowired
  private ThreadPoolTaskExecutor threadPoolTaskExecutor;
  
  @Autowired
  private ILogService logService;
  
  /**
   * Service层切点
   */
/*	@Pointcut("@annotation(com.myron.ims.annotation.SystemServiceLog)")
	public void serviceAspect(){}*/
  
  /**
   * Controller层切点 注解拦截
   */
  @Pointcut("@annotation(cn.everlook.myweb.annotation.log.SystemControllerLog)")
  public void controllerAspect() {
  }
  
  /**
   * 方法规则拦截
   */
  @Pointcut("execution(* cn.everlook.myweb.web.controller.*.*(..))")
  public void controllerPointerCut() {
  }
  
  /**
   * 前置通知 用于拦截Controller层记录用户的操作的开始时间
   *
   * @param joinPoint 切点
   * @throws InterruptedException
   */
  @Before("controllerAspect()")
  public void doBefore(JoinPoint joinPoint) throws InterruptedException {
    Date beginTime = new Date();
    beginTimeThreadLocal.set(beginTime);
    //debug模式下 显式打印开始时间用于调试
    if (logger.isDebugEnabled()) {
      logger.debug("开始计时: {}  URI: {}", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
          .format(beginTime), request.getRequestURI());
    }
    
    //读取session中的用户
    Subject subject = SecurityUtils.getSubject();
    //1、查询当前用户的所有菜单 type=menu
    ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
    if (activerUser != null) {
      CommSysUser user = activerUser.getCurrentUser();
      currentUser.set(user);
    }
  }
  
  /**
   * 后置通知 用于拦截Controller层记录用户的操作
   *
   * @param joinPoint 切点
   */
  @SuppressWarnings("unchecked")
  @After("controllerAspect()")
  public void doAfter(JoinPoint joinPoint) {
    CommSysUser user = currentUser.get();
    //登入login操作 前置通知时用户未校验 所以session中不存在用户信息
    if (user == null) {
      //读取session中的用户
      Subject subject = SecurityUtils.getSubject();
      ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
      if (activerUser == null) {
        return;
      }
      user = activerUser.getCurrentUser();
      if (user == null) {
        return;
      }
    }
    Object[] args = joinPoint.getArgs();
    System.out.println(args);
    
    String title = "";
    String type = "info";              //日志类型(info:入库,error:错误)
    String remoteAddr = request.getRemoteAddr();//请求的IP
    String requestUri = request.getRequestURI();//请求的Uri
    String method = request.getMethod();      //请求的方法类型(post/get)
    Map<String, String[]> params = request.getParameterMap(); //请求提交的参数
    try {
      title = getControllerMethodDescription2(joinPoint);
    } catch (Exception e) {
      e.printStackTrace();
    }
    // debu模式下打印JVM信息。
    long beginTime = beginTimeThreadLocal.get().getTime();//得到线程绑定的局部变量（开始时间）
    long endTime = System.currentTimeMillis();  //2、结束时间
    if (logger.isDebugEnabled()) {
      logger.debug("计时结束：{}  URI: {}  耗时： {}   最大内存: {}m  已分配内存: {}m  已分配内存中的剩余空间: {}m  最大可用内存: {}m",
          new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(endTime),
          request.getRequestURI(),
          DateUtils.formatDateTime(endTime - beginTime),
          Runtime.getRuntime().maxMemory() / 1024 / 1024,
          Runtime.getRuntime().totalMemory() / 1024 / 1024,
          Runtime.getRuntime().freeMemory() / 1024 / 1024,
          (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + Runtime.getRuntime().freeMemory()) / 1024 / 1024);
    }
    
    CommSysLog log = new CommSysLog();
    log.setLogId(UuidUtils.creatUUID());
    log.setTitle(title);
    log.setType(type);
    log.setRemoteAddr(remoteAddr);
    log.setRequestUri(requestUri);
    log.setMethod(method);
    log.setMapToParams(params);
    log.setUserId(Integer.toString(user.getId()));
    log.setUserName(user.getName());
    Date operateDate = beginTimeThreadLocal.get();
    log.setOperateDate(operateDate);
    log.setTimeout(DateUtils.formatDateTime(endTime - beginTime));
    
    //1.直接执行保存操作
    //this.logService.createSystemLog(log);
    
    //2.优化:异步保存日志
    //new SaveLogThread(log, logService).start();
    
    //3.再优化:通过线程池来执行日志保存
    threadPoolTaskExecutor.execute(new SaveLogThread(log, logService));
    logThreadLocal.set(log);
    
    
  }
  
  /**
   * 异常通知
   *
   * @param joinPoint
   * @param e
   */
  @AfterThrowing(pointcut = "controllerAspect()", throwing = "e")
  public void AfterThrowing(JoinPoint joinPoint, Throwable e) {
    CommSysLog log = logThreadLocal.get();
    if (log != null) {
      log.setType("error");
      log.setException(e.toString());
      new UpdateLogThread(log, logService).start();
    }
  }
  
  /**
   * 获取注解中对方法的描述信息 用于Controller层注解
   *
   * @param joinPoint 切点
   * @return 方法描述
   */
  public static String getControllerMethodDescription2(JoinPoint joinPoint) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    Method method = signature.getMethod();
    SystemControllerLog controllerLog = method.getAnnotation(SystemControllerLog.class);
    String dis = controllerLog.description();
    return dis;
  }
  
  /**
   * 保存日志线程
   *
   * @author lin.r.x
   */
  private static class SaveLogThread implements Runnable {
    private CommSysLog log;
    private ILogService logService;
    
    public SaveLogThread(CommSysLog log, ILogService logService) {
      this.log = log;
      this.logService = logService;
    }
    
    @Override
    public void run() {
      logService.createLog(log);
    }
  }
  
  /**
   * 日志更新线程
   *
   * @author lin.r.x
   */
  private static class UpdateLogThread extends Thread {
    private CommSysLog log;
    private ILogService logService;
    
    public UpdateLogThread(CommSysLog log, ILogService logService) {
      super(UpdateLogThread.class.getSimpleName());
      this.log = log;
      this.logService = logService;
    }
    
    @Override
    public void run() {
      this.logService.updateLog(log);
    }
  }
}

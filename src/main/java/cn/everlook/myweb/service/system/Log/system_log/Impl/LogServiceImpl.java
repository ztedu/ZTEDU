package cn.everlook.myweb.service.system.Log.system_log.Impl;

import cn.everlook.myweb.persistence.dao.system.log.CommSysLogMapper;
import cn.everlook.myweb.persistence.entity.assort.log.CommSysLog;
import cn.everlook.myweb.service.system.Log.system_log.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 此处填写说明
 *
 * @author Administrator
 * @createDate 2019/5/21
 */
@Service("iLogService")
public class LogServiceImpl implements ILogService {
  @Autowired
  private CommSysLogMapper commSysLogMapper;
  
  @Override
  public int createLog(CommSysLog log) {
    return commSysLogMapper.insert(log);
  }
  
  @Override
  public int updateLog(CommSysLog log) {
    return commSysLogMapper.updateByPrimaryKey(log);
  }
}

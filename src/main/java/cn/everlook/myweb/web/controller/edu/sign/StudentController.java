package cn.everlook.myweb.web.controller.edu.sign;

import cn.everlook.myweb.annotation.log.SystemControllerLog;
import cn.everlook.myweb.commons.common.JsonData;
import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.persistence.entity.vo.system.edu.sign.StudentVo;
import cn.everlook.myweb.service.edu.registration.student.Impl.ZtStudentsServiceImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 学员管理
 *
 * @author liyqt
 * @createDate 2019/3/12
 */
@Controller
@RequestMapping("/student")
public class StudentController {
  
  @Autowired
  private ZtStudentsServiceImpl ztStudentsService;
  
  /**
   * 跳转到学员界面
   */
  @SystemControllerLog(description = "学员页面")
  @RequestMapping("/toStudentInfo.do")
  @RequiresPermissions("student:page")
  public String toStudentInfo() {
    return "edu/sign/studentManager";
  }
  
  
  /**
   * 加载学员列表
   */
  @SystemControllerLog(description = "加载学员")
  @RequestMapping("/loadAllStudents.do")
  @RequiresPermissions("student:list")
  @ResponseBody
  public DataGridView loadAllDepts(StudentVo studentVo) {
    DataGridView view = this.ztStudentsService.queryAllStudents(studentVo);
    return view;
  }
  
  /**
   * 跳转到添加学员的页面
   */
  @RequestMapping("/toAddStudent.do")
  public String toAddStudent() {
    return "edu/sign/studentAdd";
  }
  
  
  /**
   * 添加学员
   */
  @RequestMapping("/addStudentInfo.do")
  @ResponseBody
  public JsonData addStudentInfo(StudentVo studentVo) {
    this.ztStudentsService.addStudentInfo(studentVo);
//    int maxId = commSysDeptService.getMaxIdWithDept(deptVo);
//    deptVo.setId(maxId);
    return JsonData.success(studentVo);
  }
}

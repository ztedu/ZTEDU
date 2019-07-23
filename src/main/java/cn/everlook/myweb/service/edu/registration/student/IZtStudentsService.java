package cn.everlook.myweb.service.edu.registration.student;

import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.persistence.entity.vo.system.edu.sign.StudentVo;

public interface IZtStudentsService {
  /**
   * 查询所有的学员返回DataGridView
   */
  DataGridView queryAllStudents(StudentVo studentVo);
  
  
  /**
   * 添加学员
   */
  void addStudentInfo(StudentVo studentVo);
}

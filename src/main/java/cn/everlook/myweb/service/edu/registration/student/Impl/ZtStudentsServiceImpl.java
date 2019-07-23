package cn.everlook.myweb.service.edu.registration.student.Impl;

import cn.everlook.myweb.commons.util.BeanValidator.BeanValidator;
import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.persistence.dao.edu.registration.student.ZtStudentMapper;
import cn.everlook.myweb.persistence.dao.system.rbac.dept.CommSysDeptMapper;
import cn.everlook.myweb.persistence.entity.assort.edu.registration.ZtStudent;
import cn.everlook.myweb.persistence.entity.assort.rbac.dept.CommSysDept;
import cn.everlook.myweb.persistence.entity.vo.system.edu.sign.StudentVo;
import cn.everlook.myweb.service.edu.registration.student.IZtStudentsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学员管理服务层
 *
 * @author liyqt
 * @createDate 2019/6/11
 */
@Service
public class ZtStudentsServiceImpl implements IZtStudentsService {
  
  @Autowired
  private ZtStudentMapper ztStudentMapper;
  
  @Override
  public DataGridView queryAllStudents(StudentVo studentVo) {
    Page<ZtStudent> page = PageHelper.startPage(studentVo.getPage(), studentVo.getLimit());
    List<ZtStudent> data = this.ztStudentMapper.queryAllStudents(studentVo);
    DataGridView view = new DataGridView(page.getTotal(), data);
    return view;
  }
  
  @Override
  public void addStudentInfo(StudentVo studentVo) {
    BeanValidator.check(studentVo);
    this.ztStudentMapper.insert(studentVo);
  }
}

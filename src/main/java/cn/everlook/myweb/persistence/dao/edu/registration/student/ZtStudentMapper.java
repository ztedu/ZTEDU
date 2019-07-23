package cn.everlook.myweb.persistence.dao.edu.registration.student;

import cn.everlook.myweb.persistence.entity.assort.edu.registration.ZtStudent;
import cn.everlook.myweb.persistence.entity.assort.edu.registration.ZtStudentExample;

import java.util.List;

import cn.everlook.myweb.persistence.entity.vo.system.edu.sign.StudentVo;
import org.apache.ibatis.annotations.Param;

public interface ZtStudentMapper {
  int countByExample(ZtStudentExample example);
  
  int deleteByExample(ZtStudentExample example);
  
  int deleteByPrimaryKey(Long ztStudentId);
  
  int insert(ZtStudent record);
  
  int insertSelective(ZtStudent record);
  
  List<ZtStudent> selectByExample(ZtStudentExample example);
  
  ZtStudent selectByPrimaryKey(Long ztStudentId);
  
  int updateByExampleSelective(@Param("record") ZtStudent record, @Param("example") ZtStudentExample example);
  
  int updateByExample(@Param("record") ZtStudent record, @Param("example") ZtStudentExample example);
  
  int updateByPrimaryKeySelective(ZtStudent record);
  
  int updateByPrimaryKey(ZtStudent record);
  
  //学员全查询
  List<ZtStudent> queryAllStudents(StudentVo studentVo);
}
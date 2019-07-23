package cn.everlook.myweb.persistence.dao.system.log;

import cn.everlook.myweb.persistence.entity.assort.log.CommSysLog;
import cn.everlook.myweb.persistence.entity.assort.log.CommSysLogExample;

import java.util.List;

import cn.everlook.myweb.persistence.entity.vo.system.log.LogVo;
import org.apache.ibatis.annotations.Param;

public interface CommSysLogMapper {
  int countByExample(CommSysLogExample example);
  
  int deleteByExample(CommSysLogExample example);
  
  int deleteByPrimaryKey(String logId);
  
  int insert(CommSysLog record);
  
  int insertSelective(CommSysLog record);
  
  List<CommSysLog> selectByExample(CommSysLogExample example);
  
  CommSysLog selectByPrimaryKey(String logId);
  
  int updateByExampleSelective(@Param("record") CommSysLog record, @Param("example") CommSysLogExample example);
  
  int updateByExample(@Param("record") CommSysLog record, @Param("example") CommSysLogExample example);
  
  int updateByPrimaryKeySelective(CommSysLog record);
  
  int updateByPrimaryKey(CommSysLog record);
  
  //日志全查询
  List<CommSysLog> queryAllLogs(LogVo logVo);
  
//  清空日志
  int clearLogs();
}
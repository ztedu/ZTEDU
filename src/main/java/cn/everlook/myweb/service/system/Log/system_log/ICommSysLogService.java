package cn.everlook.myweb.service.system.Log.system_log;

import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.persistence.entity.assort.log.CommSysLog;
import cn.everlook.myweb.persistence.entity.vo.system.log.LogVo;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ICommSysLogService {
  /**
   * 查询所有的日志返回DataGridView
   */
  DataGridView queryAllLogs(LogVo logVo);
  
  /**
   * 删除日志信息
   */
  void deleteLogs(String id);
  
  /**
   * 清空日志
   */
  void clearLogs();
  
  /**
   * 导出日志
   */
  List<CommSysLog> exportLogs();
  
  /**
   * 根据ID获取CommLog
   */
  CommSysLog selectByPrimaryKey(LogVo logVo);
}

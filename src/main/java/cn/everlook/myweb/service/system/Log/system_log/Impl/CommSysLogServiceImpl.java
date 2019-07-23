package cn.everlook.myweb.service.system.Log.system_log.Impl;

import cn.everlook.myweb.commons.util.dataGridView.layuiTable.DataGridView;
import cn.everlook.myweb.commons.util.easyexcel.DataUtil;
import cn.everlook.myweb.persistence.dao.system.log.CommSysLogMapper;
import cn.everlook.myweb.persistence.entity.assort.log.CommSysLog;
import cn.everlook.myweb.persistence.entity.assort.log.CommSysLogExample;
import cn.everlook.myweb.persistence.entity.vo.system.log.LogVo;
import cn.everlook.myweb.service.system.Log.system_log.ICommSysLogService;
import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 操作日志服务层
 *
 * @author Administrator
 * @createDate 2019/5/22
 */
@Service
public class CommSysLogServiceImpl implements ICommSysLogService {
  
  @Autowired
  private CommSysLogMapper commSysLogMapper;
  
  @Override
  public DataGridView queryAllLogs(LogVo logVo) {
    Page<CommSysLog> page = PageHelper.startPage(logVo.getPage(), logVo.getLimit());
    List<CommSysLog> data = this.commSysLogMapper.queryAllLogs(logVo);
    DataGridView view = new DataGridView(page.getTotal(), data);
    return view;
  }
  
  
  @Override
  public void deleteLogs(String id) {
    this.commSysLogMapper.deleteByPrimaryKey(id);
  }
  
  @Override
  public void clearLogs() {
    this.commSysLogMapper.clearLogs();
  }
  
  @Override
  public List<CommSysLog> exportLogs() {
    return commSysLogMapper.queryAllLogs(new LogVo());
  }
  
  @Override
  public CommSysLog selectByPrimaryKey(LogVo logVo) {
    return commSysLogMapper.selectByPrimaryKey(logVo.getLogId());
  }
}

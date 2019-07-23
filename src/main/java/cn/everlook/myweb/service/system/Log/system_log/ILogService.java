package cn.everlook.myweb.service.system.Log.system_log;

import cn.everlook.myweb.persistence.entity.assort.log.CommSysLog;

public interface ILogService {
    //增删改
  int createLog(CommSysLog log);
  
  int updateLog(CommSysLog log);
  
}

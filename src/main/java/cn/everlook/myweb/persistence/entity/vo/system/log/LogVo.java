package cn.everlook.myweb.persistence.entity.vo.system.log;

import cn.everlook.myweb.persistence.entity.assort.log.CommSysLog;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * LogVo
 *
 * @author Administrator
 * @createDate 2019/5/22
 */
@Setter
@Getter
public class LogVo extends CommSysLog implements Serializable {
  //做批量删除使用的ids
  private String[] ids;
  private Integer page;
  private Integer limit;

  private String  beginDate;
  private String  endDate;
}
package cn.everlook.myweb.persistence.entity.assort.rbac.role;

import java.io.Serializable;

public class CommSysRole implements Serializable {
  private Integer id;
  
  private String name;
  
  private String remark;
  
  private Integer available;
  
  private Integer orderNum;
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }
  
  public String getRemark() {
    return remark;
  }
  
  public void setRemark(String remark) {
    this.remark = remark == null ? null : remark.trim();
  }
  
  public Integer getAvailable() {
    return available;
  }
  
  public void setAvailable(Integer available) {
    this.available = available;
  }
  
  public Integer getOrderNum() {
    return orderNum;
  }
  
  public void setOrderNum(Integer orderNum) {
    this.orderNum = orderNum;
  }
}
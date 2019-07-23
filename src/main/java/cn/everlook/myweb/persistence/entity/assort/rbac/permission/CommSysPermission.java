package cn.everlook.myweb.persistence.entity.assort.rbac.permission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommSysPermission implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private Integer id;
  
  private Integer pid;
  
  private String type;
  
  private Integer parent;
  
  private String percode;
  
  @NotBlank(message = "菜单名称不可以为空")
  @Length(max = 100, min = 2, message = "菜单名称长度需要在2-100个字之间")
  private String name;
  
  private String icon;
  
  private String href;
  
  private String target;
  
  private Integer spread;
  
  @NotNull(message = "排序码不可以为空")
  @Min(value = 1, message = "排序码为大于0的整数")
  private Integer orderNum;
  
  private Integer available;
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public Integer getPid() {
    return pid;
  }
  
  public void setPid(Integer pid) {
    this.pid = pid;
  }
  
  public String getType() {
    return type;
  }
  
  public void setType(String type) {
    this.type = type == null ? null : type.trim();
  }
  
  public Integer getParent() {
    return parent;
  }
  
  public void setParent(Integer parent) {
    this.parent = parent;
  }
  
  public String getPercode() {
    return percode;
  }
  
  public void setPercode(String percode) {
    this.percode = percode == null ? null : percode.trim();
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name == null ? null : name.trim();
  }
  
  public String getIcon() {
    return icon;
  }
  
  public void setIcon(String icon) {
    this.icon = icon == null ? null : icon.trim();
  }
  
  public String getHref() {
    return href;
  }
  
  public void setHref(String href) {
    this.href = href == null ? null : href.trim();
  }
  
  public String getTarget() {
    return target;
  }
  
  public void setTarget(String target) {
    this.target = target == null ? null : target.trim();
  }
  
  public Integer getSpread() {
    return spread;
  }
  
  public void setSpread(Integer spread) {
    this.spread = spread;
  }
  
  public Integer getOrderNum() {
    return orderNum;
  }
  
  public void setOrderNum(Integer orderNum) {
    this.orderNum = orderNum;
  }
  
  public Integer getAvailable() {
    return available;
  }
  
  public void setAvailable(Integer available) {
    this.available = available;
  }
}
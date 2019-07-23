package cn.everlook.myweb.persistence.entity.assort.rbac.dept;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommSysDept implements Serializable {
  private static final long serialVersionUID = 1L;
  
  private List<CommSysDept> deptList;
  
  private Integer id;
  
  private Integer pid;
  
  @NotBlank(message = "部门名称不可以为空")
  @Length(max = 100, min = 2, message = "部门名称长度需要在2-100个字之间")
  private String name;
  
  private Integer spread;
  
  private Integer parent;
  
  private String remark;
  
  private String loc;
  
  private Integer available;
  
  @NotNull(message = "排序码不可以为空")
  @Min(value = 1, message = "排序码为大于0的整数")
  private Integer orderNum;

}
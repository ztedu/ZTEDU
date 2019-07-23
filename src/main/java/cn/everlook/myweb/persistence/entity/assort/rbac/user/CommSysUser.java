package cn.everlook.myweb.persistence.entity.assort.rbac.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommSysUser implements Serializable {
  private Integer id;
  
  @NotBlank(message = "用户名不可以为空")
  @Length(max = 100, min = 2, message = "用户名长度需要在2-100个字之间")
  private String name;
  
  private String loginName;
  
  private String address;
  
  private Integer sex;
  
  private String remark;
  
  private String pwd;
  
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date hireDate;
  
  private Integer mgr;
  
  private Integer deptId;
  
  private Integer available;
  
  private Integer orderNum;
  
  private Integer attachmentId;
  
  private String userNo;
  
  private Integer isSystem;
  
  private String phone;
  
  private String tel;
  
  private Integer position;
  
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthDate;
  
  private String leaderName;
  
  private String deptName;
  
  private Integer userMgrDeptId;
  
}
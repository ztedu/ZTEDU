package cn.everlook.myweb.commons.util.treeNode;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Ztree节点
 *
 * @author liyqt
 * @createDate 2019/3/16
 */
@Setter
@Getter
@NoArgsConstructor
public class ZTreeNode {
  private Integer id;
  //  改别名
  @JsonProperty("pId")
  private Integer pid;
  private String name;
  private Boolean isParent;
  private Boolean open;
  private Boolean checked;
  
  private List<ZTreeNode> children = new ArrayList<>();
  
  //  单选树的构造
  public ZTreeNode(Integer id, Integer pid, String name, Boolean isParent, Boolean open) {
    this.id = id;
    this.pid = pid;
    this.name = name;
    this.isParent = isParent;
    this.open = open;
  }
  
  
  //  多选树的构造
  public ZTreeNode(Integer id, Integer pid, String name, Boolean isParent, Boolean open, Boolean checked) {
    this.id = id;
    this.pid = pid;
    this.name = name;
    this.isParent = isParent;
    this.open = open;
    this.checked = checked;
  }
}

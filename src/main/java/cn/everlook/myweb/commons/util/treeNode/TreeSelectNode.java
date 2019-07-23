package cn.everlook.myweb.commons.util.treeNode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * treeselect组件Node
 *
 * @author liyqt
 * @createDate 2019/3/26
 */
@Getter
@Setter
@ToString
public class TreeSelectNode {
  private Integer id;
  private Integer pid;
  private String name;
  private boolean open;
  private boolean checked;
  private List<TreeSelectNode> children = new ArrayList<>();
  
  
  public TreeSelectNode(Integer id, String name, boolean open, boolean checked, Integer pid) {
    this.id = id;
    this.name = name;
    this.open = open;
    this.checked = checked;
    this.pid = pid;
  }
}

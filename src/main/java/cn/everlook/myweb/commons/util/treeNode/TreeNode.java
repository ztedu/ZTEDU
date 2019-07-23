package cn.everlook.myweb.commons.util.treeNode;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * 左侧菜单树类
 *
 * @author Administrator
 * @createDate 2019/3/9
 */
@Getter
@Setter
@ToString
public class TreeNode {
  private Integer id;
  private Integer pid;
  private String title;
  private String url;
  private String icon;
  private boolean spread;
  private List<TreeNode> list = new ArrayList<>();
  
  public TreeNode(Integer id, Integer pid, String title, String url, String icon, boolean spread) {
    this.id = id;
    this.pid = pid;
    this.title = title;
    this.url = url;
    this.icon = icon;
    this.spread = spread;
  }
}

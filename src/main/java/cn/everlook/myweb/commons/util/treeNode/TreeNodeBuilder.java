package cn.everlook.myweb.commons.util.treeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成前端要求的数据对象
 *
 * @author Administrator
 * @createDate 2019/3/9
 */
public class TreeNodeBuilder {
  
  /**
   * @param treeNodes 从数据库里查询出来并封装到List<TreeNode>里面的对象
   * @param topId 最顶层的数据
   * @return
   */
  public static List<TreeNode> build(List<TreeNode> treeNodes, Integer topId) {
    List<TreeNode> nodes = new ArrayList<>();
    for (TreeNode treeNode : treeNodes) {
      if (treeNode.getPid() == topId) {
        nodes.add(treeNode);
      }
      for (TreeNode node : treeNodes) {
        if (node.getPid() == treeNode.getId()){
          treeNode.getList().add(node);
        }
      }
    }
    return nodes;
  }
}

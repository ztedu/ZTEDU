package cn.everlook.myweb.commons.util.treeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 此处填写说明
 *
 * @author liyqt
 * @createDate 2019/7/5
 */
public class ZTreeNodeBuilder {
  
  /**
   * @param treeNodes 从数据库里查询出来并封装到List<TreeNode>里面的对象
   * @param topId 最顶层的数据
   * @return
   */
  public static List<ZTreeNode> build(List<ZTreeNode> treeNodes, Integer topId) {
    List<ZTreeNode> nodes = new ArrayList<>();
    for (ZTreeNode treeNode : treeNodes) {
      if (treeNode.getPid() == topId) {
        nodes.add(treeNode);
      }
      for (ZTreeNode node : treeNodes) {
        if (node.getPid() == treeNode.getId()){
          if (!node.getIsParent()){
            treeNode.setIsParent(true);
          }
          treeNode.getChildren().add(node);
        }
      }
    }
    return nodes;
  }
}

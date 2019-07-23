package cn.everlook.myweb.commons.util.treeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成前端treeSelect组件要求的数据对象
 *
 * @author liyqt
 * @createDate 2019/3/26
 */
public class TreeSelectNodeBuilder {
  
  /**
   * @param treeSelectNodes 从数据库里查询出来并封装到List<TreeNode>里面的对象
   * @param topId 最顶层的数据
   * @return
   */
  public static List<TreeSelectNode> build(List<TreeSelectNode> treeSelectNodes, Integer topId) {
    List<TreeSelectNode> nodes = new ArrayList<>();
    for (TreeSelectNode treeSelectNode : treeSelectNodes) {
      if (treeSelectNode.getPid() == topId) {
        nodes.add(treeSelectNode);
      }
      for (TreeSelectNode node : treeSelectNodes) {
        if (node.getPid() == treeSelectNode.getId()){
          treeSelectNode.getChildren().add(node);
        }
      }
    }
    return nodes;
  }
}
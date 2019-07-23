package cn.everlook.myweb.web.controller.test.Guava;


import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


/**
 * 此处填写说明
 *
 * @author Administrator
 * @createDate 2019/2/18
 */
public class GuavaTest {
  
  public static void main(String[] args) {
//    ImmutableList list = ImmutableList.of("a", "b", "c", "d");
//    System.out.println(list);
    int i = 1;
    String a = "";
    int j[] = {4, 1, 2, 3};
    List l = Ints.asList(j);
    
    //前置检查方法
    //条件检查 不通过抛出IllegalArgumentException及自定义描述 自定义描述支持类似于String.format()的字符串拼接但是只能用%s
//    try {
//      Preconditions.checkArgument(i >= 3, "Argument was %s but expected nonnegative", i);
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//    }
    //空值检查 不通过抛出NullPointerException及自定义描述
//    try {
//      Preconditions.checkNotNull(a, "Argument was null");
//    } catch (Exception e) {
//      System.out.println(e.getMessage());
//    }

//    //状态检查 不通过抛出IllegalStateException及自定义描述
//    Preconditions.checkState(i >= 0, "Argument was %s but expected nonnegative", i);
//    //检查列表、字符串或数组某一索引是否有效 不通过抛出IndexOutOfBoundsException
//    Preconditions.checkElementIndex(2, l.size());
//    //检查列表、字符串或数组某一位置是否有效 不通过抛出IndexOutOfBoundsException
//    Preconditions.checkPositionIndex(2, l.size());
//    //检查列表、字符串或数组某一范围是否有效 不通过抛出IndexOutOfBoundsException
//    Preconditions.checkPositionIndexes(1, 2, l.size());
    
    List lists = Ints.asList(4, 1, 2, 3);
    List sorts = Ordering.natural().sortedCopy(lists);
    System.out.println(sorts);
    
    List<Integer> list = Arrays.asList(1, 5, 3, 8, 2);
    Collections.sort(list, Ordering.natural());
    System.out.println(list);
  }
  
}

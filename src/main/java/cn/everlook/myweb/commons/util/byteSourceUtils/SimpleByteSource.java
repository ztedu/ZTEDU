package cn.everlook.myweb.commons.util.byteSourceUtils;

import java.io.Serializable;

/**
 * 盐值序列化
 *
 * @author Administrator
 * @createDate 2019/5/20
 */
public class SimpleByteSource extends org.apache.shiro.util.SimpleByteSource implements Serializable {
  
  private static final long serialVersionUID = 5528101080905698238L;
  
  public SimpleByteSource(byte[] bytes) {
    super(bytes);
    // TODO 自动生成的构造函数存根
  }
  
}

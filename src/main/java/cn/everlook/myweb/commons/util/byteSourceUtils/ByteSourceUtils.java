package cn.everlook.myweb.commons.util.byteSourceUtils;

//import org.apache.shiro.util.ByteSource;

import org.apache.shiro.util.ByteSource;

/**
 * 盐值序列化
 *
 * @author Administrator
 * @createDate 2019/5/20
 */
public class ByteSourceUtils {
  public static ByteSource bytes(byte[] bytes) {
    return new SimpleByteSource(bytes);
  }
  
  public static ByteSource bytes(String arg0) {
    return new SimpleByteSource(arg0.getBytes());
  }
}

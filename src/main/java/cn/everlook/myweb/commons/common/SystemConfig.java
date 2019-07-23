package cn.everlook.myweb.commons.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 此处填写说明
 *
 * @author Administrator
 * @createDate 2019/4/26
 */
public class SystemConfig {
  public static final String ENCODING = "UTF-8";
  public static final String DEFAULT_CONF = "config.properties";
  public static final boolean SYS_LINUX = !System.getProperty("os.name").toString().toUpperCase().contains("WINDOWS");
  private static Map<String, Properties> CONFS = new HashMap();
  private static Properties props = null;
  
  public SystemConfig() {
  }
  
  public static String get(String key) {
    return get("config.properties", key);
  }
  
  public static String get(String propertiesName, String key) {
    validProps(propertiesName);
    Object o = props.get(key);
    return o != null ? o.toString() : null;
  }
  
  public static long getLong(String key) {
    return getLong("config.properties", key);
  }
  
  public static long getLong(String propertiesName, String key) {
    validProps(propertiesName);
    Object o = props.get(key);
    if (o != null) {
      try {
        long l = Long.parseLong(o.toString());
        return l;
      } catch (NumberFormatException var5) {
      }
    }
    
    return 0L;
  }
  
  public static Integer getInteger(String key) {
    return getInteger("config.properties", key);
  }
  
  public static Integer getInteger(String propertiesName, String key) {
    validProps(propertiesName);
    Object o = props.get(key);
    if (o != null) {
      try {
        Integer l = Integer.parseInt(o.toString());
        return l;
      } catch (NumberFormatException var4) {
      }
    }
    
    return 0;
  }
  
  public static void validProps() {
    validProps("config.properties");
  }
  
  public static void validProps(String propertiesName) {
    if (!isLoaded(propertiesName)) {
      reloadProps(propertiesName);
    }
    
  }
  
  public static void reloadProps() {
    reloadProps("config.properties");
  }
  
  public static void reloadProps(String propertiesName) {
    if (props == null) {
      props = new Properties();
    }
    
    CONFS.remove(propertiesName);
    Properties properties = loadProperties(propertiesName);
    if (properties != null) {
      props.putAll(properties);
      CONFS.put(propertiesName, properties);
    }
    
  }
  
  public static Properties loadProperties(String resourceName) {
    Properties properties = null;
    InputStream in = null;
    
    try {
      properties = new Properties();
      in = SystemConfig.class.getClassLoader().getResourceAsStream(resourceName);
      properties.load(in);
    } catch (Exception var12) {
      var12.printStackTrace();
    } finally {
      try {
        if (in != null) {
          in.close();
        }
      } catch (IOException var11) {
        var11.printStackTrace();
      }
      
    }
    
    return properties;
  }
  
  public static boolean isLoaded(String propertiesName) {
    return CONFS.containsKey(propertiesName);
  }
  
  public static Properties getLoadedConfig(String propertiesName) {
    return (Properties) CONFS.get(propertiesName);
  }
}

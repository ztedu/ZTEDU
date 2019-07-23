package cn.everlook.myweb.commons.util.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 创建RetryLimitHashedCredentialsMatcher类,此类有登录失败次数的判断，
 * 多于5次后再等待1分钟后才能重试。
 *
 * @author Administrator
 * @createDate 2019/3/1
 */
public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
  
  private Cache<String, AtomicInteger> passwordRetryCache;
  
  public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
    passwordRetryCache = cacheManager.getCache("passwordRetryCache");
  }
  
  
  @Override
  public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
    String userName = token.getPrincipal().toString();
    AtomicInteger retryCount = passwordRetryCache.get(userName);
    if (null == retryCount) {
      retryCount = new AtomicInteger(0);
      passwordRetryCache.put(userName, retryCount);
    }
    
    if (retryCount.incrementAndGet() > 5) {
      throw new ExcessiveAttemptsException();
    }
    
    boolean matches = super.doCredentialsMatch(token, info);
    if (matches) {
      passwordRetryCache.remove(userName);
    }
    
    return matches;
  }
}

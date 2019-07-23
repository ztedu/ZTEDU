package cn.everlook.myweb.commons.util.BeanValidator;

import cn.everlook.myweb.commons.exception.ParamException;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.collections.MapUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.*;

/**
 * 自定义的验证器,验证一个参数是否符合规定
 * 验证
 *
 * @author liyqt
 * @createDate 2018/10/22
 */
public class BeanValidator {
  //1.创建validator工厂
  private static ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
  
  public static <T> Map<String, String> validate(T t, Class... groups) {
    //2.获取Validator
    Validator validator = validatorFactory.getValidator();
    //3.校验  获得的Set<ConstraintViolation> -----约束违反的set集合
    //这个gropus感觉没什么用，主要是为了迎合参数列表,另外，t不能是集合类型
    Set validateResult = validator.validate(t, groups);
    if (validateResult.isEmpty()) {
      return Collections.emptyMap();
    } else {
      LinkedHashMap errors = Maps.newLinkedHashMap();
      Iterator iterator = validateResult.iterator();
      while (iterator.hasNext()) {
        ConstraintViolation violation = (ConstraintViolation) iterator.next();
        //4.封装结果集  （属性值-错误信息）-》
        errors.put(violation.getPropertyPath().toString(), violation.getMessage());
      }
      return errors;
    }
  }
  
  //对一个集合类型进行遍历校验，上面的validate方法，不能处理集合类型
  public static Map<String, String> validateList(Collection<?> collection) {
    Preconditions.checkNotNull(collection);
    Iterator iterator = collection.iterator();
    Map errors;
    
    do {
      if (!iterator.hasNext()) {
        return Collections.emptyMap();
      }
      Object object = iterator.next();
      errors = validate(object, new Class[0]);
    } while (errors.isEmpty());//只要集合内有一个字段错误，那么直接返回，不用考虑剩余元素
    
    return errors;
  }
  
  //通用方法，至少传入一个Object参数，这个方法还是有问题，如果first为集合就
  public static Map<String, String> validateObject(Object first, Object... objects) {
    if (objects != null && objects.length > 0) {
      return validateList(Lists.asList(first, objects));
    } else {
      return validate(first, new Class[0]);
    }
  }
  
  //最终方法：可以检验任何
  public static void check(Object param) throws ParamException {//BeanValidator->controller->handlerExcetionResolver
    //异常层层向上抛出
    Map<String, String> map = BeanValidator.validateObject(param);
    if (MapUtils.isNotEmpty(map)) {
      List<String> errorList = new ArrayList<>();
      for (Map.Entry<String, String> entry : map.entrySet()) {
        errorList.add(entry.getValue());
      }
      throw new ParamException(errorList.get(errorList.size()-1));//自定义异常向上抛出
//      throw new ParamException(map.toString());
      //日志打印等后续工作......
    }
  }
}

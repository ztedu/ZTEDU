package cn.everlook.myweb.persistence.entity.vo.test;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 测试验证器
 * Bean Validation 中内置的 constraint
 *  @Null   被注释的元素必须为 null
 * 	@NotNull    被注释的元素必须不为 null
 * 	@AssertTrue     被注释的元素必须为 true
 * 	@AssertFalse    被注释的元素必须为 false
 * 	@Min(value= ,massage=)     被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * 	@Max(value)     被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * 	@DecimalMin(value)  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
 * 	@DecimalMax(value)  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
 * 	@Size(max=, min=,massage=)   被注释的元素的大小必须在指定的范围内
 * 	@Digits (integer, fraction)     被注释的元素必须是一个数字，其值必须在可接受的范围内
 * 	@Past   被注释的元素必须是一个过去的日期
 * 	@Future     被注释的元素必须是一个将来的日期
 * 	@Pattern(regex=,flag=)  被注释的元素必须符合指定的正则表达式
 *
 * Hibernate Validator 附加的 constraint
 * 	@NotBlank(message =)   验证字符串非null，且长度必须大于0
 * 	@Email  被注释的元素必须是电子邮箱地址
 * 	@Length(min=,max=)  被注释的字符串的大小必须在指定的范围内
 * 	@NotEmpty   被注释的字符串的必须非空
 * 	@Range(min=,max=,message=)  被注释的元素必须在合适的范围内
 *
 *  @Past 验证 Date 和 Calendar 对象是否在当前时间之前
 *  @Future 验证 Date 和 Calendar 对象是否在当前时间之后
 *  @Pattern验证 String 对象是否符合正则表达式的规则
 *
 *
 * @NotNull：不能为null，但可以为empty
 * @NotEmpty：不能为null，而且长度必须大于0
 * @NotBlank：只能作用在String上，不能为null，而且调用trim()后，长度必须大于0
 * @author liyqt
 * @createDate 2018/10/22
 */
@Setter
@Getter
public class TestVo {
  
  @NotBlank(message = "msg不能为空")
  private String msg;
  
  @NotNull(message = "id不能为空")
  @Max(value = 10, message = "id 不能大于10")
  @Min(value = 0, message = "id 至少大于等于0")
  private Integer id;
  
//  @NotEmpty
  private List<String> str;
}

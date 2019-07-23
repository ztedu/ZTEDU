/**
 * @Title:        ZTEDU
 * @Description   对自定义组件进行测试
 * @Company:      http://www.ztedu.online
 *
 * @Author        LYQ
 * @CreateDate    2019/1/21 19:43
 */

/**
 扩展一个test模块
 **/

layui.define(function (exports) { //提示：模块也可以依赖其它模块，如：layui.define('layer', callback);
  var obj = {
    hello: function (str) {
      alert('Hello ' + (str || 'mymod'));
    }
  };

  //输出test接口
  exports('mymod', obj);
});
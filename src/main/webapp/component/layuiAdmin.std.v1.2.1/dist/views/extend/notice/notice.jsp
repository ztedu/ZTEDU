<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
  <meta charset="utf-8">
  <title>ZTEDU</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/style/login.css" media="all">
  <script>
    if (window != top)
      top.location.replace(location.href);
    //    如果当前窗口不是最上层窗口（比如是在Iframe中），那么就把自己变为最上层窗口。
    // 这可以防止别的网站把你自己的网站放在他的Iframe中，从而损害你的利益（因为会误导浏览者）。
  </script>


</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
  <div class="layadmin-user-login-main">
    <div class="layadmin-user-login-box layadmin-user-login-header">
      <h2>layuiAdmin</h2>
      <p>layui 官方出品的单页面后台管理模板系统</p>
    </div>
    <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
      <div class="layui-form-item">
        <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
        <input type="text" name="username" id="LAY-user-login-username" lay-verify="required" placeholder="用户名"
               class="layui-input">
      </div>
      <div class="layui-form-item">
        <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
        <input type="password" name="password" id="LAY-user-login-password" lay-verify="required" placeholder="密码"
               class="layui-input">
      </div>
      <div class="layui-form-item">
        <div class="layui-row">
          <div class="layui-col-xs7">
            <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
            <input type="text" name="vercode" id="LAY-user-login-vercode" lay-verify="required" placeholder="图形验证码"
                   class="layui-input">
          </div>
          <div class="layui-col-xs5">
            <div style="margin-left: 10px;">
              <img src="https://www.oschina.net/action/user/captcha" class="layadmin-user-login-codeimg"
                   id="LAY-user-get-vercode">
            </div>
          </div>
        </div>
      </div>
      <div class="layui-form-item" style="margin-bottom: 20px;">
        <input type="checkbox" lay-skin="primary" name="remember" title="记住密码">
        <a href="forget.html" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">忘记密码？</a>
      </div>

      <div class="layui-form-item">
        <button class="layui-btn layui-btn-fluid" lay-submit lay-filter="LAY-user-login-submit">登 入</button>
      </div>
      <%--<div class="layui-form-item">--%>
      <%--<button class="layui-btn layui-btn-fluid" id="Button1">测 试</button>--%>
      <%--</div>--%>
      <div class="layui-trans layui-form-item layadmin-user-login-other">
        <label>社交账号登入</label>
        <a href="javascript:;"><i class="layui-icon layui-icon-login-qq"></i></a>
        <a href="javascript:;"><i class="layui-icon layui-icon-login-wechat"></i></a>
        <a href="javascript:;"><i class="layui-icon layui-icon-login-weibo"></i></a>
        <a href="/logout.page" class="layadmin-user-jump-change layadmin-link">注册帐号</a>
      </div>
    </div>
  </div>

  <div class="layui-trans layadmin-user-login-footer">
    <p>© 2018 <a href="http://www.layui.com/" target="_blank">layui.com</a></p>
    <p>
      <span><a href="http://www.layui.com/admin/#get" target="_blank">获取授权</a></span>
      <span><a href="http://www.layui.com/admin/pro/" target="_blank">在线演示</a></span>
      <span><a href="http://www.layui.com/admin/" target="_blank">前往官网</a></span>
    </p>
  </div>
</div>

<script src="/layuiadmin/layui/layui.js"></script>

<script>
  layui.config({
    base: '/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'user', 'notice'], function () {
    var $ = layui.$
        , setter = layui.setter
        , admin = layui.admin
        , form = layui.form
        , router = layui.router()
        , search = router.search
        , notice = layui.notice;

    form.render();

    //提交
    form.on('submit(LAY-user-login-submit)', function (obj) {
      $(this).text('登陆中...').attr("disabled", "disabled").addClass("layui-disabled");
      console.log('000==' + JSON.stringify(obj));
      //请求登入接口
      admin.req({
        url: layui.setter.base + 'json/user/login.js' //实际使用请改成服务端真实接口
        , data: obj.field
        , done: function (res) {

          //请求成功后，写入 access_token
          layui.data(setter.tableName, {
            key: setter.request.tokenName
            , value: res.data.access_token
          });

          //登入成功的提示与跳转
          layer.msg('登入成功', {
            offset: '15px'
            , icon: 1
            , time: 1000
          }, function () {
            // window.location.href = 'index.jsp'; //后台主页
            window.location.href = 'test.jsp';//测试页面
          });
        }
      });

    });


    //实际使用时记得删除该代码
    // layer.msg('为了方便演示，用户名密码可随意输入', {
    //   offset: '15px'
    //   , icon: 1
    // });

    // 警告消息
    notice.warning({
      title: '消息通知',
      message: '你有新的消息，请注意查收!'
    });

    // 参数设置
    notice.info({
      title: '消息通知',
      message: '你有新的消息，请注意查收!',
      position: 'topRight',    // 位置
      transitionIn: 'bounceInLeft',    // 进入动画
      transitionOut: 'fadeOut',      // 退出动画
      onOpen: function () {
        notice.msg('open', {icon: 1});
      },
      onClose: function () {
        notice.msg('close', {icon: 1});
      },
      buttons: [
        ['<button>Ok</button>', function (instance, toast) {
          alert("Hello world!");
        }],
        ['<button>Close</button>', function (instance, toast) {
          instance.hide({transitionOut: 'fadeOutUp'}, toast);
        }]
      ]
    });

    // 成功提示框
    notice.msg('This is a message of success', {icon: 1});

    $(document).ready(function () {
      $('#Button1').click(function () {
//      $('#textbox1').val() == '' ? alert('textbox1不能为空') : alert('我被点击了');

        // 警告消息
        notice.warning({
          title: '消息通知',
          message: '你有新的消息，请注意查收!'
        });

      });
    });

  });
</script>


</body>


</html>
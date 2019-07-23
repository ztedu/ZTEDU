<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/2/28
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>

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

  <style>
    body {
      background-image: url("/res/images/common/bgimage/bg_login.svg");
      background-position: center 110px;
      background-repeat: no-repeat;
      background-size: 100%;
      background-color: #f0f2f5;
    }
  </style>

</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">
  <div class="layadmin-user-login-main">
    <div class="layadmin-user-login-box layadmin-user-login-header">
      <h1><b>智途教育</b></h1>
      <p>智途教育信息咨询有限公司</p>
    </div>
    <form class="layadmin-user-login-box layadmin-user-login-body layui-form" method="post"
          id="loginForm">
      <div class="layui-form-item">
        <label class="layadmin-user-login-icon layui-icon layui-icon-username" for="LAY-user-login-username"></label>
        <input type="text" name="loginName" id="LAY-user-login-username" lay-verify="required" placeholder="用户名"
               class="layui-input">
      </div>
      <div class="layui-form-item">
        <label class="layadmin-user-login-icon layui-icon layui-icon-password" for="LAY-user-login-password"></label>
        <input type="password" name="pwd" id="LAY-user-login-password" lay-verify="required" placeholder="密码"
               class="layui-input">
      </div>
      <div class="layui-form-item">
        <div class="layui-row">
          <div class="layui-col-xs7">
            <label class="layadmin-user-login-icon layui-icon layui-icon-vercode" for="LAY-user-login-vercode"></label>
            <input type="text" name="captchaCode" autocomplete="off" id="LAY-user-login-vercode" lay-verify="required"
                   placeholder="图形验证码"
                   class="layui-input">
          </div>
          <div class="layui-col-xs5">
            <div style="margin-left: 10px;">
              <!-- 验证码,请求地址为在Web.xml中配置的Kaptcha内置的Servlet-->
              <!-- Kaptcha Servlet生成验证码保存至SESSION并将图片返回 -->
              <%--class="layadmin-user-login-codeimg"--%>
              <img src="/kaptcha" onclick="changeCode();" id="LAY-vercode">
            </div>
          </div>
        </div>
      </div>
      <div class="layui-form-item" style="margin-bottom: 20px;">
        <input type="checkbox" name="rememberMe" title="记住我" lay-skin="primary"/>
        <a href="forget.html" class="layadmin-user-jump-change layadmin-link" style="margin-top: 7px;">忘记密码？</a>
      </div>


      <div class="layui-form-item">
        <%--<div style="color: red;margin: auto;">${message}</div>--%>
        <%--<br/>--%>
        <button class="layui-btn layui-btn-fluid" id="LAY-user-login-submit" lay-filter="LAY-user-login-submit" type="button"
                lay-submit>登 入
        </button>
        <%--<button type="button"  class="layui-btn layui-btn-disabled" disabled>下一步</button>--%>
      </div>

      <div class="layui-trans layui-form-item layadmin-user-login-other">
        <label>社交账号登入</label>
        <a href="javascript:;"><i class="layui-icon layui-icon-login-qq"></i></a>
        <a href="javascript:;"><i class="layui-icon layui-icon-login-wechat"></i></a>
        <a href="javascript:;"><i class="layui-icon layui-icon-login-weibo"></i></a>
        <a href="/logout.page" class="layadmin-user-jump-change layadmin-link">注册帐号</a>
      </div>
    </form>
  </div>

  <div class="layui-trans layadmin-user-login-footer">
    <p>© 2019 智途教育，让你为未来积蓄力量！</p>
  </div>
</div>

<script src="/layuiadmin/layui/layui.js"></script>

<script language="JavaScript">
  if (window != top) {
    top.location.href = location.href;
  }
</script>


<%--<script type="text/javascript">--%>

<%--</script>--%>

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
    form.on('submit(LAY-user-login-submit)', function (data) {
      // layer.msg(JSON.stringify(data.field));
      $(this).text('登陆中...').attr("disabled", "disabled").addClass("layui-disabled");

      // setTimeout(function () {
      //   var loginForm = document.forms[0];
      //   loginForm.submit();
      // },1000);


      var username = data.field.loginName;
      var password = data.field.pwd;
      var vcode = data.field.vercode;
      var rememberMe = data.field.rememberMe;
      var captchaCode = data.field.captchaCode;
      if (rememberMe == "on") {
        rememberMe = true;
      } else {
        rememberMe = false;
      }


      <%--fetch("<%=contextPath%>/login/login.do", {--%>
      <%--body:JSON.stringify(data.field),--%>
      <%--method: 'post',--%>
      <%--headers: {--%>
      <%--'Content-Type': 'application/json; charset=utf8'--%>
      <%--}--%>
      <%--}).then(r=>r.json()).then(console.log);--%>


      $.ajax({
        type: "POST",
        data: JSON.stringify({
          "loginName": username,
          "pwd": password,
          "rememberMe": rememberMe,
          "captchaCode": captchaCode
        }),
        contentType: 'application/json; charset=utf8',
        dataType: "json",
        url: "<%=contextPath%>/login/login.do",
        success: function (result) {
          if (result.status == 201) {
            notice.msg(result.message, {icon: 2, timeout: 2000});
            relodaBtn();
          } else if (result.status == 202) {
            notice.msg(result.message, {icon: 2, timeout: 2000});
            relodaBtn();
          } else if (result.status == 203) {
            notice.msg(result.message, {icon: 2, timeout: 2000});
            relodaBtn();
          } else if (result.status == 204) {
            notice.msg(result.message, {icon: 2, timeout: 2000});
            relodaBtn();
          } else if (result.status == 205) {
            notice.msg(result.message, {icon: 2, timeout: 2000});
            relodaBtn();
          } else if (result.status == 200) {
            //登入成功的提示与跳转
            layer.msg('登入成功', {
              offset: '15px'
              , icon: 1
              , time: 1000
            }, function () {
              location.href = "<%=contextPath%>/login/index.do"//后台主页
            });
          } else {
            //登入失败的提示与跳转
            layer.msg('登入失败', {
              offset: '15px'
              , icon: 2
              , time: 1000
            }, function () {
              relodaBtn();
            });
          }
        }
      });
      return false;
    });


    // 刷新界面
    function reloadPage() {
      setTimeout(function () {
        location = location;
      }, 2500);
    }

    function kickout() {
      var href = location.href;
      if (href.indexOf("kickout") > 0) {
        layer.msg('您的账号在另一台设备上登录，您被挤下线，若不是您本人操作，请立即修改密码！', {
          offset: '15px'
          , icon: 2
          , time: 5000
          // ,offset:'auto'
        });
      }
    }

    // 刷新按钮的状态
    function relodaBtn() {
      $("#LAY-user-login-submit").removeAttr("disabled");
      $("#LAY-user-login-submit").text('登陆');
      $("#LAY-user-login-submit").removeClass("layui-disabled");
    }

    window.onload = kickout();


  });
</script>

<script>
  function changeCode() {
    document.getElementById("LAY-vercode").src = "/kaptcha";
  }
</script>


</body>


</html>

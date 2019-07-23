<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/5/7
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<style>
  /** 错误页面样式 */
  .error-page {
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    text-align: center;
  }

  .error-page-img {
    min-width: 300px;
    max-width: 100%;
    max-height: 300px;
  }

  .error-page-info {
    display: inline-block;
    text-align: center;
    vertical-align: middle;
    padding-left: 30px;
  }

  .error-page-info h1 {
    color: #434e59;
    font-size: 72px;
    font-weight: 600;
    margin-bottom: 10px;
  }

  .error-page-info-desc {
    color: #777;
    font-size: 20px;
    line-height: 28px;
    margin-bottom: 16px;
  }

  body {
    background-image: url("../res/images/common/bgimage/bg_login.svg");
    background-position: center 110px;
    background-repeat: no-repeat;
    background-size: 100%;
    background-color: #f0f2f5;
  }
</style>

<head>
  <meta charset="utf-8"/>
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>403</title>
  <link rel="stylesheet" href="../layuiadmin/layui/css/layui.css" media="all">
</head>

<body>

<!-- 正文开始 -->
<div class="error-page">
    <img class="error-page-img" src="../res/images/error/403/3.svg">
    <div class="error-page-info">
        <h1>403</h1>
        <div class="error-page-info-desc">抱歉，你无权访问此页面</div>
        <div>
            <a href="/login/toLogin.do" class="layui-btn">返回登录页</a>
        </div>
    </div>
</div>

<!-- js部分 -->
<!-- js部分 -->
<script src="/layuiadmin/layui/layui.js"></script>

</body>

</html>
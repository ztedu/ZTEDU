<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2018/12/10
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
  <base href="<%=basePath%>">
  <meta charset="utf-8">
  <title>layer iframe 示例</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/style/admin.css" media="all">
  <style>
    body {
      padding: 10px;
      font-size: 14px;
      background: #fff;
      width: 95%;
      margin: 0 auto;
      font-size: 14px;
      line-height: 20px;
      overflow: hidden;
    }

    p {
      margin-bottom: 10px;
    }

    input {
      border: 1px solid #999;
      padding: 5px 10px;
      margin: 0 10px 10px 0;
    }
  </style>

</head>
<body>
<input class="layui-input" placeholder="标记" id="LAY_mark">

<div class="layui-btn-container">
  <button class="layui-btn layui-btn-primary" data-type="auto">让层自适应iframe</button>
  <button class="layui-btn layui-btn-primary" data-type="parentPopup">在父层弹出一个层</button>
  <button class="layui-btn layui-btn-primary" data-type="setParent">给父页面传值</button>
  <button class="layui-btn layui-btn-primary" data-type="close">在内部关闭iframe</button>
</div>

<script src="/layuiadmin/layui/layui.js"></script>
<script>
  layui.use('layer', function () {
    var $ = layui.$
        , layer = layui.layer
        , index = parent.layer.getFrameIndex(window.name); //获取窗口索引

    var active = {
      //让层自适应iframe
      auto: function () {
        $('body').append('插入很多酱油。插入很多酱油。插入很多酱油。插入很多酱油。插入很多酱油。插入很多酱油。插入很多酱油。');
        parent.layer.iframeAuto(index);
      }

      //在父层弹出一个层
      , parentPopup: function () {
        top.layer.msg('Hi, man', {shade: 0.3})
      }

      //给父页面传值
      , setParent: function () {
        var id = '#LAY_layer_iframe_demo'
            , mark = $('#LAY_mark')
            , val = mark.val();

        if (val === '') {
          mark.focus();
          parent.layer.msg('请填写标记');
          return true;
        }

        parent.layer.msg('您将标记 [ ' + val + ' ] 成功传送给了父窗口');
        parent.layui.$(id).text('我被改变了');
        parent.layer.tips('Look here', id, {
          time: 5000
        });
        parent.layer.close(index);
      }


      //在内部关闭iframe
      , close: function (set) {
        parent.layer.close(index);
      }
    }

    $('.layui-btn-container .layui-btn').on('click', function () {
      var othis = $(this)
          , type = othis.data('type');
      active[type] && active[type].call(this);
    });
  });
</script>
</body>
</html>


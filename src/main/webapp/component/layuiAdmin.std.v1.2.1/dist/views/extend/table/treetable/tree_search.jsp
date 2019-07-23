<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/2/20
  Time: 21:05
  https://gitee.com/whvse/treetable-lay
  To change this template use File | Settings | File Templates.
--%>
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
  <style>
    input {
      height: 33px;
      line-height: 33px;
      padding: 0 7px;
      border: 1px solid #ccc;
      border-radius: 2px;
      margin-bottom: -2px;
      outline: none;
    }

    input:focus {
      border-color: #009E94;
    }
  </style>
</head>
<body>


<!-- 加载动画，移除位置在common.js中 -->
<div class="page-loading">
  <div class="rubik-loader"></div>
</div>


<div class="layui-container">
  <!-- 关闭Tab时顶部标题 -->
  <%--<div class="layui-body-header">--%>
  <%--<span class="layui-body-header-title">树形表格</span>--%>
  <%--<span class="layui-breadcrumb pull-right">--%>
  <%--<a href="../../console/console.html">首页</a>--%>
  <%--<a><cite>树形表格</cite></a>--%>
  <%--</span>--%>
  <%--</div>--%>

  <br><br>
  <a class="layui-btn layui-btn-normal" href="index.html">&lt;&lt;返回</a>
  &nbsp;&nbsp;
  <div class="layui-btn-group">
    <button class="layui-btn" id="btn-expand">全部展开</button>
    <button class="layui-btn" id="btn-fold">全部折叠</button>
  </div>
  &nbsp;&nbsp;
  <input id="edt-search" type="text" placeholder="输入关键字" style="width: 120px;"/>&nbsp;&nbsp;
  <button class="layui-btn" id="btn-search">&nbsp;&nbsp;搜索&nbsp;&nbsp;</button>

  <table id="auth-table" class="layui-table" lay-filter="auth-table"></table>
</div>

<script src="/layuiadmin/layui/layui.js"></script>

<script>
  layui.config({
    base: '/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'user', 'notice', 'treetable', 'table', 'layer', 'form', 'admin'], function () {
    var $ = layui.$
        , setter = layui.setter
        , layer = layui.layer
        , form = layui.form
        , notice = layui.notice
        , table = layui.table
        , admin = layui.admin
        , treetable = layui.treetable;


// 渲染表格
    layer.load(2);
    treetable.render({
      treeColIndex: 1,
      treeSpid: -1,
      treeIdName: 'authorityId',
      treePidName: 'parentId',
      elem: '#auth-table',
      url: layui.setter.base + 'json/treetable/tree_search.js',
      page: false,
      cols: [[
        {type: 'numbers'},
        {field: 'authorityName', minWidth: 200, title: '权限名称'},
        {field: 'authority', title: '权限标识'},
        {field: 'menuUrl', title: '菜单url'},
        {
          field: 'isMenu', width: 80, align: 'center', templet: function (d) {
            if (d.isMenu == 1) {
              return '<span class="layui-badge layui-bg-gray">按钮</span>';
            }
            if (d.parentId == -1) {
              return '<span class="layui-badge layui-bg-blue">目录</span>';
            } else {
              return '<span class="layui-badge-rim">菜单</span>';
            }
          }, title: '类型'
        }
      ]],
      done: function () {
        layer.closeAll('loading');
      }
    });

    $('#btn-expand').click(function () {
      treetable.expandAll('#auth-table');
    });

    $('#btn-fold').click(function () {
      treetable.foldAll('#auth-table');
    });

    $('#btn-search').click(function () {
      var keyword = $('#edt-search').val();
      var searchCount = 0;
      $('#auth-table').next('.treeTable').find('.layui-table-body tbody tr td').each(function () {
        $(this).css('background-color', 'transparent');
        var text = $(this).text();
        if (keyword != '' && text.indexOf(keyword) >= 0) {
          $(this).css('background-color', 'rgba(250,230,160,0.5)');
          if (searchCount == 0) {
            treetable.expandAll('#auth-table');
            $('html,body').stop(true);
            $('html,body').animate({scrollTop: $(this).offset().top - 150}, 500);
          }
          searchCount++;
        }
      });
      if (keyword == '') {
        layer.msg("请输入搜索内容", {icon: 5});
      } else if (searchCount == 0) {
        layer.msg("没有匹配结果", {icon: 5});
      }
    });


    // 移除loading动画
    setTimeout(function () {
      admin.removeLoading();
    }, window == top ? 300 : 150);


  });
</script>


</body>


</html>

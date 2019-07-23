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
</head>
<body>


<!-- 加载动画，移除位置在common.js中 -->
<div class="page-loading">
  <div class="rubik-loader"></div>
</div>

<!-- 关闭Tab时顶部标题 -->
<div class="layui-body-header">
  <span class="layui-body-header-title">树形表格</span>
  <span class="layui-breadcrumb pull-right">
        <a href="../../console/console.html">首页</a>
        <a><cite>树形表格</cite></a>
    </span>
</div>


<div class="layui-fluid">
  <div class="layui-card">
    <div class="layui-card-body">
      <div>
        <button class="layui-btn" id="btn-expand">全部展开</button>
        <button class="layui-btn" id="btn-fold">全部折叠</button>
      </div>
      <table id="auth-table" class="layui-table" lay-filter="auth-table"></table>
    </div>
  </div>
</div>

<!-- 操作列 -->
<script type="text/html" id="auth-state">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">修改</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

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

    form.render('select');

    // 渲染表格
    treetable.render({
      treeColIndex: 1,
      treeSpid: -1,
      treeIdName: 'authorityId',
      treePidName: 'parentId',
      elem: '#auth-table',
      url: layui.setter.base + 'json/user/menus.js',
      page: false,
      cellMinWidth: 100,
      cols: [[
        {type: 'numbers'},
        {field: 'authorityName', minWidth: 200, title: '权限名称'},
        {field: 'authority', title: '权限标识'},
        {field: 'menuUrl', title: '菜单url'},
        {field: 'orderNumber', minWidth: 80, align: 'center', title: '排序号'},
        {
          field: 'isMenu', minWidth: 80, align: 'center', templet: function (d) {
            if (d.isMenu == 1) {
              return '<span class="layui-badge layui-bg-gray">按钮</span>';
            }
            if (d.parentId == -1) {
              return '<span class="layui-badge layui-bg-blue">目录</span>';
            } else {
              return '<span class="layui-badge-rim layui-bg-green">菜单</span>';
            }
          }, title: '类型'
        },
        {templet: '#auth-state', minWidth: 120, align: 'center', title: '操作'}
      ]],
      done: function () {
        layer.closeAll('loading');
      }
    });


    //监听工具条
    table.on('tool(auth-table)', function (obj) {
      var data = obj.data; //获得当前行数据
      var layEvent = obj.event; //获得 lay-event 对应的值

      if (layEvent === 'edit') { //查看
        layer.msg('点击了修改');
      } else if (layEvent === 'del') { //删除
        layer.msg('点击了删除');
      }
    });

    $('#btn-expand').click(function () {
      treetable.expandAll('#auth-table');
    });

    $('#btn-fold').click(function () {
      treetable.foldAll('#auth-table');
    });

    // 移除loading动画
    setTimeout(function () {
      admin.removeLoading();
    }, window == top ? 300 : 150);

  });
</script>


</body>


</html>
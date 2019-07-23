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

<div class="layui-container">
    <br><br>
    <a class="layui-btn layui-btn-normal" href="index.html">&lt;&lt;返回</a>
    &nbsp;&nbsp;
    <div class="layui-btn-group">
        <button class="layui-btn" id="btn-expand">全部展开</button>
        <button class="layui-btn" id="btn-fold">全部折叠</button>
        <button class="layui-btn" id="btn-refresh">刷新表格</button>
    </div>

    <table id="table1" class="layui-table" lay-filter="table1"></table>
</div>
<!-- 操作列 -->
<script type="text/html" id="oper-col">
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


        // 渲染表格
        var renderTable = function () {
            layer.load(2);
            treetable.render({
                treeColIndex: 2,
                treeSpid: -1,
                treeIdName: 'd_id',
                treePidName: 'd_pid',
                elem: '#table1',
                url: layui.setter.base + 'json/treetable/treetable2.js',
                page: false,
                cols: [[
                    {type: 'numbers'},
                    {field: 'id', title: 'id'},
                    {field: 'name', title: 'name'},
                    {field: 'sex', title: 'sex'},
                    {field: 'pid', title: 'pid'},
                    {templet: '#oper-col', title: 'oper'}
                ]],
                done: function () {
                    layer.closeAll('loading');
                }
            });
        };

        renderTable();

        $('#btn-expand').click(function () {
            treetable.expandAll('#table1');
        });

        $('#btn-fold').click(function () {
            treetable.foldAll('#table1');
        });

        $('#btn-refresh').click(function () {
            renderTable();
        });


    // 移除loading动画
    setTimeout(function () {
      admin.removeLoading();
    }, window == top ? 300 : 150);

  });
</script>


</body>


</html>

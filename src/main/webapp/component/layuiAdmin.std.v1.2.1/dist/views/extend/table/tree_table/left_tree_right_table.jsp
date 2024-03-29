<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/15
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
  <title>左树右表</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="renderer" content="webkit">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="/layuiadmin/layui/css/layui.css" media="all">
  <%--<link rel="stylesheet" href="/layuiadmin/style/layui/dtree/dtree.css" media="all">--%>
  <link rel="stylesheet" href="/layuiadmin/layui/css/modules/layui-icon-extend/dtree/dtreefont.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/style/admin.css" media="all">
  <style>
    #ltTree {
      height: 535px;
      overflow: auto;
    }

    @media screen and (max-width: 750px) {
      #ltTree {
        height: auto;
      }
    }
  </style>
</head>
<body>


<!-- 加载动画，移除位置在common.js中 -->
<div class="page-loading">
  <div class="rubik-loader"></div>
</div>

<!-- 关闭Tab时顶部标题 -->
<div class="layui-body-header">
  <span class="layui-body-header-title">左树右表</span>
  <span class="layui-breadcrumb pull-right">
        <a href="../../console/console.html">首页</a>
        <a><cite>左树右表</cite></a>
    </span>
</div>

<!-- 正文开始 -->
<div class="layui-fluid">
  <div class="layui-row layui-col-space15">
    <!-- 左树 -->
    <div class="layui-col-sm12 layui-col-md4 layui-col-lg3">
      <div class="layui-card">
        <div class="layui-card-body mini-bar" id="ltTree">

        </div>
      </div>
    </div>
    <!-- 右表 -->
    <div class="layui-col-sm12 layui-col-md8 layui-col-lg9">
      <div class="layui-card">
        <div class="layui-card-body">

          <div class="layui-form toolbar">
            <div class="layui-form-item">
              <div class="layui-inline">
                <label class="layui-form-label w-auto">搜索：</label>
                <div class="layui-input-inline mr0">
                  <input id="edtSearch" class="layui-input" type="text" placeholder="输入关键字"/>
                </div>
              </div>
              <div class="layui-inline">
                <button class="layui-btn icon-btn" id="btnSearch">
                  <i class="layui-icon">&#xe615;</i>搜索
                </button>
                <button id="btnAdd" class="layui-btn icon-btn">
                  <i class="layui-icon">&#xe654;</i>新增
                </button>
                <button id="btnDel" class="layui-btn layui-btn-danger icon-btn">
                  <i class="layui-icon">&#xe640;</i>删除
                </button>
              </div>
            </div>
          </div>

          <table class="layui-table" id="rtTable" lay-filter="rtTable"></table>

        </div>
      </div>
    </div>

  </div>
</div>

<!-- 表格操作列 -->
<script type="text/html" id="user-table-bar">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">修改</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

<script src="/layuiadmin/layui/layui.js"></script>

<script>
  layui.config({
    base: '/layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'layer', 'form', 'table', 'util', 'dtree', 'admin'], function () {
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    var table = layui.table;
    var util = layui.util;
    var dtree = layui.dtree;
    var admin = layui.admin;

    // 渲染表格
    var ins1 = table.render({
      elem: '#rtTable',
      url: layui.setter.base + 'json/user/left_tree_right_table_user.js',
      page: true,
      cellMinWidth: 100,
      cols: [[
        {type: 'checkbox'},
        {field: 'username', align: 'center', sort: true, title: '账号'},
        {field: 'nickName', align: 'center', sort: true, title: '用户名'},
        {field: 'phone', align: 'center', sort: true, title: '手机号'},
        {field: 'sex', align: 'center', sort: true, title: '性别'},
        {
          sort: true, align: 'center', templet: function (d) {
          return util.toDateString(d.createTime);
        }, title: '创建时间'
        },
        {align: 'center', align: 'center', toolbar: '#user-table-bar', title: '操作', minWidth: 120}
      ]]
    });

    // 监听工具条
    table.on('tool(rtTable)', function (obj) {
      var data = obj.data; //获得当前行数据
      var layEvent = obj.event; //获得 lay-event 对应的值

      if (layEvent === 'edit') { // 查看
        layer.msg('点击了修改');
      } else if (layEvent === 'del') { // 删除
        layer.msg('点击了删除');
      }
    });

    // 批量删除
    $('#btnDel').click(function () {
      var checkRows = table.checkStatus('rtTable');
      if (checkRows.data.length == 0) {
        layer.msg('请选择要删除的数据', {icon: 2});
      } else {
        layer.msg('你选择了' + checkRows.data.length + '条数据', {icon: 1});
      }
    });

    // 搜索按钮点击事件
    $('#btnSearch').click(function () {
      var value = $('#edtSearch').val();
      table.reload('rtTable', {where: {search: value}});
    });

    // 树形渲染
    dtree.render({
      elem: '#ltTree',
      url: layui.setter.base + 'json/user/left_tree_right_table.js',
      type: 'all',
      initLevel: '2',
      dot: false,
      method: 'GET'
    });
    // 树形点击事件
    dtree.on('node("ltTree")', function (obj) {
      var data = obj.param;
      layer.msg('你选择了：' + data.nodeId + '-' + data.context);
      table.reload('rtTable', {where: {nodeId: data.nodeId}});
    });


    // 移除loading动画
    setTimeout(function () {
      admin.removeLoading();
    }, window == top ? 300 : 150);


  });
</script>


</body>


</html>

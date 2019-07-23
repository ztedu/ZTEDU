<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/7/11
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>
<html>
<head>
  <meta charset="utf-8">
  <title>更新用户</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" type="text/css" href="../../../../../../nprogress/nprogress.css"/>
  <link rel="stylesheet" href="/layuiadmin/layui/css/modules/layui-icon-extend/requird/iconfont.css" media="all">
</head>
<body>

<div class="layui-fluid">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-sm12 layui-col-md12 layui-col-lg12">
      <div class="layui-card">
        <div class="layui-card-body">
          <form class="layui-form" id="searchFormRole" method="post" onsubmit="return false;">
            <%--<blockquote class="layui-elem-quote layui-text">--%>
              <div class="layui-form-item">
                <%--<div class="layui-inline">--%>
                  <%--<label class="layui-form-label">角色名称:</label>--%>
                  <%--<div class="layui-input-inline mr0">--%>
                    <%--<input type="text" name="name" id="name" autocomplete="off" class="layui-input" placeholder="角色名称"/>--%>
                  <%--</div>--%>
                <%--</div>--%>
                <div class="layui-inline">
                  <%--<a class="layui-btn layui-btn-warm" id="search_btn">--%>
                    <%--<i class="layui-icon">&#xe615;</i>搜索--%>
                  <%--</a>--%>
                  <%--<button type="reset" class="layui-btn layui-btn-normal icon-btn" id="reset_btn">--%>
                    <%--<i class="layui-icon">&#xe9aa;</i>清空--%>
                  <%--</button>--%>
                  <a class="layui-btn icon-btn" id="addRoles_btn">
                    <i class="layui-icon">&#xe654;</i>确认分配
                  </a>
                </div>
              </div>
            <%--</blockquote>--%>
          </form>
          <%--表格--%>
          <table class="layui-table" id="roleList" lay-filter="roleList"></table>
        </div>
      </div>
    </div>
  </div>
</div>


<script src="/layuiadmin/layui/layui.js"></script>
<script src="/nprogress/nprogress.js"></script>

<script type="text/javascript">
  layui.config({
    base: '../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index', //主入口模块
    "tablePlug": "../lib/extend/tablePlug/tablePlug"
  }).use(['index', 'common', 'treeSelect', 'tree', 'notice', 'laydate', 'tablePlug'], function () {//需要显式use common模块
    var $ = layui.$,
        form = layui.form,
        layer = parent.layer == undefined ? layui.layer : top.layer,
        table = layui.table

    $(function () {
      NProgress.start();
    });


    //角色列表
    tableIns = table.render({
      elem: '#roleList',
      url: '/user/loadAllUserRoles.do?id=${user.id}',
      cellMinWidth: 95,
      page: {
        groups: 5 //只显示 5 个连续页码
      },
      height: "full",
      limits: [10, 20, 50, 100],
      limit: 10,
      id: "roleListTable",
      even: true,
      cols: [[
        {
          type: "checkbox", fixed: "left", width: 50
        }, {
          field: 'id', title: '角色ID', minWidth: 50, width: 80, align: 'center', sort: true
        }, {
          field: 'name', title: '角色名称', minWidth: 100, align: 'center'
        }, {
          field: 'remark', title: '角色备注', minWidth: 180, align: 'center'
        }
      ]],
      done: function (res, curr, count) {   //返回数据执行回调函数
        NProgress.done();
        // layer.close(index);    //返回数据关闭loading
        currentPage = curr;
        tableCounts = count;
        tableLimit = $(".layui-laypage-limits").find("option:selected").val();
      }
    });


    //查询角色信息
    <%--$("#search_btn").on("click", function () {--%>
      <%--var params = $("#searchFormRole").serialize();--%>
      <%--table.reload('roleListTable', {--%>
        <%--// url: '/role/loadAllRoles.do?' + params,--%>
        <%--url: '/user/loadAllSelectUserRoles.do?id=${user.id}&' + params,--%>
        <%--page: {--%>
          <%--curr: 1  //从第一页开始--%>
        <%--},--%>
      <%--});--%>
    <%--});--%>


    // reset_btn,清空按钮后刷新角色信息列表
    <%--$("#reset_btn").on("click", function () {--%>
      <%--form.render();--%>
      <%--table.reload('roleListTable', {--%>
        <%--url: '/user/loadAllUserRoles.do?id=${user.id}',--%>
        <%--page: {--%>
          <%--curr: 1  //清空按钮点击后刷新整个列表界面，从第一页开始展示--%>
        <%--},--%>
      <%--});--%>
    <%--});--%>


    //回车键进行搜索
    // $('#searchFormRole').bind('keydown', function (event) {
    //   if (event.keyCode == "13") {
    //     var params = $("#searchFormRole").serialize();
    //     table.reload('roleListTable', {
    //       url: '/role/loadAllRoles.do?' + params,
    //       page: {
    //         curr: 1  //从第一页开始
    //       },
    //     });
    //   }
    // });


    // addRoles_btn,添加角色按钮点击
    $("#addRoles_btn").on("click", function () {
      var checkStatus = table.checkStatus('roleListTable'),//选中状态
          data = checkStatus.data;//选中的对象集
      var ids = "id=${user.id}";
      if (data.length > 0) {
        for (var i in data) {
          ids += "&ids=" + data[i].id;
        }
        $.post("/user/addRoles.do?" + ids, function (data) {
          layer.closeAll('loading');
          if (data.ret) {
            //关闭提示框
            parent.layer.msg('角色分配成功！', {icon: 1, time: 1500, shade: 0.2}, function () {
              var addIndex = window.parent.layer.getFrameIndex(window.name);
              window.parent.layer.close(addIndex);
            });
          } else {
            parent.layer.msg('角色分配失败！', {icon: 2, time: 1500, shade: 0.2});
          }
        })
      } else {
        layer.msg("请选择对应的角色!", {
          icon: 0
        });
      }
    });

  });


</script>
</body>
</html>

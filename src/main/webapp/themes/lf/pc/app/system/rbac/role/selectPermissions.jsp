<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/7/5
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>
<html>
<meta charset="utf-8">
<title>权限管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
<link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
<link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
<link rel="stylesheet" href="../../../../../../layuiadmin/style/layui/ztree/zTreeStyle.css" media="all">
<link rel="stylesheet" type="text/css" href="../../../../../../nprogress/nprogress.css"/>
<link rel="stylesheet" href="/layuiadmin/layui/css/modules/layui-icon-extend/file/iconfont.css" media="all">

</head>
<body>
<div>
  <div class="layui-fluid">
    <div class="layui-row layui-col-space15">
      <div class="layui-col-sm12 layui-col-md2 layui-col-lg12">
        <div class="layui-card">
          <div class="layui-card-body mini-bar">
            <blockquote class="layui-elem-quote layui-text">
              <button class="layui-btn icon-btn" id="">
                <i class="layui-icon">&#xe615;</i>搜索
              </button>
              <div class="layui-input-inline mr0">
                <input id="key" class="layui-input" type="search" placeholder="输入权限名称" autocomplete="off"/>
              </div>
              <br/>
            </blockquote>
            <ul id="ltTree" class="ztree"></ul>
          </div>
        </div>
      </div>
    </div>
    <div style="text-align: center;padding-top: 10px;" class="layui-row layui-col-space15">
      <a class="layui-btn layui-btn-normal addRolePermission_btn">确认分配</a>
    </div>
  </div>
</div>


<script src="/layuiadmin/layui/layui.js"></script>
<script src="/nprogress/nprogress.js"></script>


<script type="text/javascript">
  var ztreePermission;


  layui.config({
    base: '../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index', //主入口模块
    "tablePlug": "../lib/extend/tablePlug/tablePlug"
  }).use(['index', 'layer', 'common', 'laypage', 'ztree', 'fuzzysearch'], function () {//需要显式use common模块

    var $ = layui.$,
        fuzzysearch = layui.fuzzysearch,
        zTree = layui.ztree,
        layer = layui.layer;

    var setting = {
      check: {
        enable: true
      },
      view: {
        dblClickExpand: false,
        showLine: true,
        selectedMulti: false
      }
    };


    $(function () {
      NProgress.start();
      initRolePermissionTree();
    });


    $(".addRolePermission_btn").click(function () {
      //得到选中的树的节点的id
      var treeObj = $.fn.zTree.getZTreeObj("ltTree");
      var nodes = treeObj.getCheckedNodes(true);
      var params = "id=${role.id}";
      for (var i = 0; i < nodes.length; i++) {
        params += "&ids=" + nodes[i].id;
      }

      $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf8',
        dataType: "json",
        url: '/role/addRolePermission.do?' + params,
        success: function (json) {
          layer.msg(json.msg, {
            offset: '15px'
            , icon: 1
            , time: 1000
            , offset: '50%'
            , shift: 6
          }, function () {
            //得到当前弹出层的index
            var index = window.parent.layer.getFrameIndex(window.name);
            //关闭
            window.parent.layer.close(index);
          });
        }
      });

    });


    //加载权限树
    function initRolePermissionTree() {
      $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf8',
        dataType: "json",
        url: '/role/initRolePermissionTree.do?id=' + ${role.id},
        <%--url: "<%=contextPath%>/role/initRolePermissionTree.do?id=${role.id}",--%>
        success: function (json) {
          ztreePermission = zTree.init($("#ltTree"), setting, json);
          fuzzysearch('ltTree', '#key', null, false); //初始化模糊搜索方法
          NProgress.done();
        }
      });
    }


  });


</script>
</body>
</html>


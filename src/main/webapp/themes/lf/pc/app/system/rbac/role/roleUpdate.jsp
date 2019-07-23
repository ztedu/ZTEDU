<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/3/24
  Time: 20:00
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>

<html>
<head>
  <meta charset="utf-8">
  <title>修改角色</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/layui/css/modules/layui-icon-extend/requird/iconfont.css" media="all">
  <link rel="stylesheet" type="text/css" href="../../../../../../nprogress/nprogress.css"/>
  <style type="text/css">
    .downpanel .layui-select-title span {
      line-height: 38px;
    }

    .downpanel dl dd:hover {
      background-color: inherit;
    }
  </style>
</head>
<body>

<div class="layui-fluid">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-sm12 layui-col-md12 layui-col-lg12">
      <div class="layui-card">
        <div class="layui-card-body">
          <form class="layui-form layui-row" method="post" id="frm">
            <div class="layui-form-item">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 角色名称</label>
                  <div class="layui-input-inline">
                    <input type="text" name="name" id="name" value="${role.name}" lay-verify="required" autocomplete="off"
                           placeholder="请输入角色名称"
                           class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 排序码</label>
                  <div class="layui-input-inline">
                    <input id="order_num" type="text" name="orderNum" value="${role.orderNum}" placeholder="请输入排序码"
                           lay-verify="required"
                           autocomplete="off" class="layui-input"
                           onkeyup="this.value=this.value.replace(/\D/g,'')"
                           onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" size="14">
                  </div>
                </div>
              </div>
              <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">角色备注</label>
                <div class="layui-input-block">
                  <textarea class="layui-textarea" placeholder="请输入角色备注" name="remark">${role.remark}</textarea>
                </div>
              </div>
              <div class="layui-form-item">
                <div class="layui-form-item">
                  <div class="layui-inline">
                    <label class="layui-form-label">是否可用</label>
                    <div class="layui-input-inline">
                      <input type="radio" name="available" value="1" title="可用" ${role.available == 1?'checked':''}>
                      <input type="radio" name="available" value="0" title="不可用" ${role.available == 0?'checked':''}>
                    </div>
                  </div>
                </div>
                <div class="layui-form-item" style="text-align: center">
                  <button class="layui-btn" lay-submit="" lay-filter="updateRole">提交修改</button>
                  <button type="reset" class="layui-btn layui-btn-warm">重置</button>
                </div>
              </div>
            </div>
          </form>
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
    index: 'lib/index' //主入口模块
  }).use(['index', 'common', 'treeSelect', 'tree', 'notice'], function () {//需要显式use common模块
    var $ = layui.$,
        form = layui.form,
        admin = layui.admin,
        layer = parent.layer == undefined ? layui.layer : top.layer;
    NProgress.start();
    NProgress.done();


    //监听提交
    form.on('submit(updateRole)', function (data) {
      var data = $("#frm").serialize();
      //使用ajax
      $.ajax({
        url: '/role/updateRole.do?id=' +${role.id},
        type: 'POST',
        async: true,//是否异步
        data: data,
        timeout: 10000,
        dataType: 'json',
        success: function (data) {
          if (data.ret) {
            layer.msg('角色信息修改成功', {
              offset: '15px'
              , icon: 1
              , time: 1000
              , offset: '50%'
              , shift: 6
            }, function () {
              var updateIndex = window.parent.layer.getFrameIndex(window.name);
              window.parent.layer.close(updateIndex);
            });
          } else {
            layer.msg(data.msg, {
              offset: '15px'
              , icon: 2
              , time: 3000
              , offset: '50%'
              , shift: 6
            });
          }
        }
      });
      return false;
    });


  });


</script>
</body>
</html>
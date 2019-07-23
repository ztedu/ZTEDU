<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/7/1
  Time: 21:50
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>

<head>
  <meta charset="utf-8">
  <title>添加权限</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/layui/css/modules/layui-icon-extend/requird/iconfont.css" media="all">
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
                <div class="layui-block">
                  <label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 父级菜单</label>
                  <div class="layui-input-block">
                    <input type="text" name="pid" id="pid_tree" lay-filter="pid_tree" autocomplete="off" lay-verify="required"
                           class="layui-input">
                    <%--//设置默认的类型为permission--%>
                    <input type="hidden" name="type" value="permission">
                  </div>
                </div>
              </div>
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 权限名称</label>
                  <div class="layui-input-inline">
                    <input type="text" name="name" lay-verify="required" autocomplete="off" placeholder="请输入菜单名称"
                           class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 权限编码</label>
                  <div class="layui-input-inline">
                    <input type="text" name="percode" lay-verify="required" autocomplete="off" placeholder="请输入权限编码"
                           class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 排序码</label>
                  <div class="layui-input-inline">
                    <input id="order_num" type="text" name="orderNum" placeholder="请输入排序码" lay-verify="required"
                           autocomplete="off" class="layui-input"
                           onkeyup="this.value=this.value.replace(/\D/g,'')"
                           onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" size="14">
                  </div>
                </div>
              </div>
              <div class="layui-form-item">
                <div class="layui-form-item">
                  <div class="layui-inline">
                    <label class="layui-form-label">是否可用</label>
                    <div class="layui-input-inline">
                      <input type="radio" name="available" value="1" title="可用" checked="">
                      <input type="radio" name="available" value="0" title="不可用">
                    </div>
                  </div>
                </div>
                <div class="layui-form-item" style="text-align: center">
                  <button class="layui-btn" lay-submit="" lay-filter="addPermission">提交</button>
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


<script type="text/javascript">
  layui.config({
    base: '../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'common', 'treeSelect', 'tree', 'notice'], function () {//需要显式use common模块
    var $ = layui.$,
        form = layui.form,
        layer = parent.layer == undefined ? layui.layer : top.layer,
        treeSelect = layui.treeSelect;

    //监听提交
    form.on('submit(addPermission)', function (data) {
      var data = $("#frm").serialize();
      //使用ajax
      $.ajax({
        url: '/permission/addPermission.do',
        type: 'POST',
        async: true,//是否异步
        data: data,
        timeout: 10000,
        dataType: 'json',
        success: function (data) {
          if (data.ret) {
            layer.msg('权限添加成功', {
              offset: '15px'
              , icon: 1
              , time: 1000
              , offset: '50%'
              , shift: 6
            }, function () {
              var addIndex = window.parent.layer.getFrameIndex(window.name);
              window.parent.layer.close(addIndex);
              window.parent.addSuccess = true;
            });
          } else {
            window.parent.addSuccess = false;
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

    // https://fly.layui.com/extend/treeSelect/
    treeSelect.render({
      // 选择器
      elem: '#pid_tree',
      // 数据
      data: "/menu/loadMenuTreeMenus.do",
      // 异步加载方式：get/post，默认get
      type: 'get',
      // 占位符
      placeholder: '选择父级菜单',
      // 是否开启搜索功能：true/false，默认false
      search: true,
      // 一些可定制的样式
      style: {
        folder: {
          enable: true
        },
        line: {
          enable: true
        }
      },
      // 点击回调
      click: function (d) {
      },
      // 加载完成后的回调函数
      success: function (d) {
      }
    });


  });


</script>
</body>
</html>

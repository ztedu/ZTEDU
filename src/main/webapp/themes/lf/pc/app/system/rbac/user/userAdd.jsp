<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/7/6
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>

<html>
<head>
  <meta charset="utf-8">
  <title>添加用户</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" type="text/css" href="../../../../../../nprogress/nprogress.css"/>
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
                <div class="layui-inline">
                  <label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 所在部门</label>
                  <div class="layui-input-inline">
                    <input type="text" name="deptId" id="deptTree" lay-filter="deptTree" autocomplete="off" lay-verify="required"
                           class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 用户名称</label>
                  <div class="layui-input-inline">
                    <input type="text" name="name" id="name" lay-verify="required" autocomplete="off" placeholder="请输入用户名称"
                           class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 登录名</label>
                  <div class="layui-input-inline">
                    <input type="text" name="loginName" id="loginName" onfocus="createLoginNewName()" lay-verify="required"
                           autocomplete="off"
                           placeholder="请输入登录名"
                           class="layui-input">
                  </div>
                </div>
              </div>
              <div class="layui-form-item">
                <%--<div class="layui-inline">--%>
                  <%--<label class="layui-form-label"> 职位</label>--%>
                  <%--<div class="layui-input-inline">--%>
                    <%--<select name="position" id="position" lay-search=""></select>--%>
                  <%--</div>--%>
                <%--</div>--%>
                <div class="layui-inline">
                  <label class="layui-form-label"> 领导部门</label>
                  <div class="layui-input-inline">
                    <input type="text" name="userMgrDeptId" id="userMgrDeptTree" lay-filter="userMgrDeptTree" autocomplete="off"
                           class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">领导姓名</label>
                  <div class="layui-input-inline">
                    <select name="mgr" id="mgr" lay-search=""></select>
                  </div>
                </div>
              </div>
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">入职日期</label>
                  <div class="layui-input-inline">
                    <input type="text" name="hireDate" class="layui-input" id="hireDate" placeholder="入职日期">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">生日</label>
                  <div class="layui-input-inline">
                    <input type="text" name="birthDate" class="layui-input" id="birthDate" placeholder="生日">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">工号</label>
                  <div class="layui-input-inline">
                    <input type="text" name="userNo" class="layui-input" id="userNo" placeholder="工号">
                  </div>
                </div>
              </div>
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label"> 手机号码</label>
                  <div class="layui-input-inline">
                    <input type="text" name="phone" autocomplete="off" placeholder="请输入手机号码"
                           class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label"> 固话</label>
                  <div class="layui-input-inline">
                    <input type="text" name="tel" autocomplete="off" placeholder="请输入固话"
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
                <label class="layui-form-label">用户地址</label>
                <div class="layui-input-block">
                  <input type="text" name="address" autocomplete="off" placeholder="请输入用户地址"
                         class="layui-input">
                </div>
              </div>
              <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                  <textarea class="layui-textarea" placeholder="请输入备注" name="remark"></textarea>
                </div>
              </div>
              <div class="layui-form-item">
                <div class="layui-form-item">
                  <div class="layui-inline">
                    <label class="layui-form-label">用户性别</label>
                    <div class="layui-input-inline">
                      <input type="radio" name="sex" value="0" title="男" checked="">
                      <input type="radio" name="sex" value="1" title="女">
                    </div>
                  </div>
                  <div class="layui-inline">
                    <label class="layui-form-label">是否可用</label>
                    <div class="layui-input-inline">
                      <input type="radio" name="available" value="1" title="可用" checked="">
                      <input type="radio" name="available" value="0" title="不可用">
                    </div>
                  </div>
                  <div class="layui-inline">
                    <label class="layui-form-label">系统用户</label>
                    <div class="layui-input-inline">
                      <input type="radio" name="isSystem" value="1" title="是">
                      <input type="radio" name="isSystem" value="0" title="不是" checked="">
                    </div>
                  </div>
                </div>
                <div class="layui-form-item" style="text-align: center">
                  <button class="layui-btn" lay-submit="" lay-filter="addUserBtn">提交</button>
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
  }).use(['index', 'common', 'treeSelect', 'tree', 'notice', 'laydate'], function () {//需要显式use common模块
    var $ = layui.$,
        form = layui.form,
        layer = parent.layer == undefined ? layui.layer : top.layer,
        laydate = layui.laydate,
        treeSelect = layui.treeSelect,
        treeSelect2 = layui.treeSelect;

    $(function () {
      NProgress.start();
      //自定义职位
      // initPosition();
    });


    //日期时间选择器
    laydate.render({
      elem: '#hireDate'
    });

    //日期时间选择器
    laydate.render({
      elem: '#birthDate'
    });


    //监听提交
    form.on('submit(addUserBtn)', function (data) {
      var data = $("#frm").serialize();
      //使用ajax
      $.ajax({
        url: '/user/addNewUser.do',
        type: 'POST',
        async: true,//是否异步
        data: data,
        timeout: 10000,
        dataType: 'json',
        success: function (data) {
          if (data.ret) {
            layer.msg('用户添加成功', {
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


    treeSelect.render({
      // 选择器
      elem: '#deptTree',
      // 数据
      data: "/dept/loadDeptTreeMenus.do",
      // 异步加载方式：get/post，默认get
      type: 'get',
      // 占位符
      placeholder: '选择所属部门',
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
        window.parent.addedNodeParent = d.current;
      },
      // 加载完成后的回调函数
      success: function (d) {
        NProgress.done();

        treeSelect2.render({
          // 选择器
          elem: '#userMgrDeptTree',
          // 数据
          data: "/dept/loadDeptTreeMenus.do",
          // 异步加载方式：get/post，默认get
          type: 'get',
          // 占位符
          placeholder: '选择领导部门',
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
            initUserMrg(d.current.id);
          },
          // 加载完成后的回调函数
          success: function (d) {
            NProgress.done();
          }
        });
      }
    });


    //刷新选择领导选择框
    function initUserMrg(msgId) {
      $.post("/user/loadAllUserByDeptId.do", {
        deptId: msgId,//将需要删除的id作为参数传入
      }, function (json) {
        var mgr = $("#mgr");
        var html = "";
        if (json != null) {
          for (var i = 0; i < json.length; i++) {
            html += "<option value=" + json[i].id + ">" + json[i].name + "</option>";
          }
        }
        mgr.html(html);
        form.render("select");
      });
    };


    // 职位自定义
    // function initPosition() {
    //   $.post("/role/loadAllPosition.do", function (json) {
    //     var position = $("#position");
    //     var html = "";
    //     if (json != null) {
    //       for (var i = 0; i < json.length; i++) {
    //         html += "<option value=" + json[i].id + ">" + json[i].name + "</option>";
    //       }
    //     }
    //     position.html(html);
    //     form.render("select");
    //   });
    // }


    //自动得到用户名的全拼
    window.createLoginNewName = function() {
      //得到用户名
      var userName = $("#name").val();
      var url = "/user/createLoginName.do";
      $.post(url, {name: userName}, function (str) {
        $("#loginName").val(str);
      })
    }

  });


</script>
</body>
</html>
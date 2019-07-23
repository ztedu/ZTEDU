<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/7/8
  Time: 0:12
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
                    <input type="text" name="name" value="${user.name}" id="name" lay-verify="required" autocomplete="off"
                           placeholder="请输入用户名称"
                           class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 登录名</label>
                  <div class="layui-input-inline">
                    <input type="text" name="loginName" value="${user.loginName}" id="loginName" onfocus="createLoginNewName()"
                           lay-verify="required"
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
                    <input type="text" name="hireDate" value="<fmt:formatDate value="${user.hireDate}" pattern="yyyy-MM-dd"/>"
                           class="layui-input" id="hireDate"
                           placeholder="入职日期">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">生日</label>
                  <div class="layui-input-inline">
                    <input type="text" name="birthDate" value="<fmt:formatDate value="${user.birthDate}" pattern="yyyy-MM-dd"/>"
                           class="layui-input" id="birthDate"
                           placeholder="生日">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">工号</label>
                  <div class="layui-input-inline">
                    <input type="text" name="userNo" value="${user.userNo}" class="layui-input" id="userNo" placeholder="工号">
                  </div>
                </div>
              </div>
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label"> 手机号码</label>
                  <div class="layui-input-inline">
                    <input type="text" name="phone" value="${user.phone}" autocomplete="off" placeholder="请输入手机号码"
                           class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label"> 固话</label>
                  <div class="layui-input-inline">
                    <input type="text" name="tel" value="${user.tel}" autocomplete="off" placeholder="请输入固话"
                           class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 排序码</label>
                  <div class="layui-input-inline">
                    <input id="order_num" type="text" name="orderNum" value="${user.orderNum}" placeholder="请输入排序码"
                           lay-verify="required"
                           autocomplete="off" class="layui-input"
                           onkeyup="this.value=this.value.replace(/\D/g,'')"
                           onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="11" size="14">
                  </div>
                </div>
              </div>
              <div class="layui-form-item">
                <label class="layui-form-label">用户地址</label>
                <div class="layui-input-block">
                  <input type="text" name="address" value="${user.address}" autocomplete="off" placeholder="请输入用户地址"
                         class="layui-input">
                </div>
              </div>
              <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注</label>
                <div class="layui-input-block">
                  <textarea class="layui-textarea" placeholder="请输入备注" name="remark">${user.remark}</textarea>
                </div>
              </div>
              <div class="layui-form-item">
                <div class="layui-form-item">
                  <div class="layui-inline">
                    <label class="layui-form-label">用户性别</label>
                    <div class="layui-input-inline">
                      <input type="radio" name="sex" value="1" title="女" ${user.sex == 1?'checked':''}>
                      <input type="radio" name="sex" value="0" title="男" ${user.sex == 0?'checked':''}>
                    </div>
                  </div>
                  <div class="layui-inline">
                    <label class="layui-form-label">是否可用</label>
                    <div class="layui-input-inline">
                      <input type="radio" name="available" value="1" title="可用" ${user.available == 1?'checked':''}>
                      <input type="radio" name="available" value="0" title="不可用" ${user.available == 0?'checked':''}>
                    </div>
                  </div>
                  <div class="layui-inline">
                    <label class="layui-form-label">系统用户</label>
                    <div class="layui-input-inline">
                      <input type="radio" name="isSystem" value="1" title="是" ${user.isSystem == 1?'checked':''}>
                      <input type="radio" name="isSystem" value="0" title="不是" ${user.isSystem == 0?'checked':''}>
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
      , theme: 'molv'
    });

    //日期时间选择器
    laydate.render({
      elem: '#birthDate'
      , theme: 'molv'
    });


    //监听提交
    form.on('submit(addUserBtn)', function (data) {
      var data = $("#frm").serialize();
      //使用ajax
      $.ajax({
        url: '/user/UpdateUser.do?id=' +${user.id},
        type: 'POST',
        async: true,//是否异步
        data: data,
        timeout: 10000,
        dataType: 'json',
        success: function (data) {
          if (data.ret) {
            layer.msg('用户修改成功', {
              offset: '15px'
              , icon: 1
              , time: 1000
              , offset: '50%'
              , shift: 6
            }, function () {
              var addIndex = window.parent.layer.getFrameIndex(window.name);
              window.parent.layer.close(addIndex);
              window.parent.addSuccess = true;
              window.parent.addedNewDept = data.data;
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
        treeSelect.checkNode('deptTree', ${user.deptId});
        treeSelect.refresh('deptTree');
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
            treeSelect.checkNode('userMgrDeptTree', ${userLeader.deptId});
            treeSelect.refresh('userMgrDeptTree');

            initUserMrg(${userLeader.deptId});
          }
        });
      }
    });


    //刷新选择领导选择框
    function initUserMrg(msgId) {
      $.post("/user/loadAllUserByDeptId.do", {
        deptId: msgId,
      }, function (json) {
        var mgr = $("#mgr");
        var html = "";
        if (json != null) {
          var mgrval = ${user.mgr};
          for (var i = 0; i < json.length; i++) {
            if (mgrval == json[i].id) {
              html += "<option value=" + json[i].id + " selected>" + json[i].name + "</option>";
            } else {
              html += "<option value=" + json[i].id + ">" + json[i].name + "</option>";
            }
          }
        }
        mgr.html(html);
        form.render("select");
      });
    };


    <%--// 职位自定义--%>
    <%--function initPosition() {--%>
      <%--$.post("/role/loadAllPosition.do", function (json) {--%>
        <%--var position = $("#position");--%>
        <%--var html = "";--%>
        <%--if (json != null) {--%>
          <%--var positionval = ${user.position};--%>
          <%--for (var i = 0; i < json.length; i++) {--%>
            <%--if (positionval == json[i].id) {--%>
              <%--html += "<option value=" + json[i].id + " selected>" + json[i].name + "</option>";--%>
            <%--}else {--%>
              <%--html += "<option value=" + json[i].id + ">" + json[i].name + "</option>";--%>
            <%--}--%>
          <%--}--%>
        <%--}--%>
        <%--position.html(html);--%>
        <%--form.render("select");--%>
      <%--});--%>
    <%--}--%>


    //自动得到用户名的全拼
    window.createLoginNewName = function () {
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
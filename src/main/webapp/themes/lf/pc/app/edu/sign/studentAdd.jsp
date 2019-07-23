<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/6/12
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>

<html>
<head>
  <meta charset="utf-8">
  <title>添加学员</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/layui/css/modules/layui-icon-extend/requird/iconfont.css" media="all">
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
                  <label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 姓名</label>
                  <div class="layui-input-inline">
                    <input type="text" name="ztStudentName" lay-verify="required" autocomplete="off" placeholder="姓名"
                           class="layui-input">
                  </div>
                </div>
                <%--<div class="layui-inline">--%>
                  <%--<label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 报考院校</label>--%>
                  <%--<div class="layui-input-inline">--%>
                    <%--<input type="text" name="ztStudentEei" lay-verify="required" autocomplete="off" placeholder="报考院校"--%>
                           <%--class="layui-input">--%>
                  <%--</div>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                  <%--<label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 专业</label>--%>
                  <%--<div class="layui-input-inline">--%>
                    <%--<input type="text" name="ztStudentMajor" lay-verify="required" autocomplete="off" placeholder="专业"--%>
                           <%--class="layui-input">--%>
                  <%--</div>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                  <%--<label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 层次</label>--%>
                  <%--<div class="layui-input-inline">--%>
                    <%--<input type="text" name="ztStudentLevel" lay-verify="required" autocomplete="off" placeholder="层次"--%>
                           <%--class="layui-input">--%>
                  <%--</div>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                  <%--<label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 籍贯</label>--%>
                  <%--<div class="layui-input-inline">--%>
                    <%--<input type="text" name="ztStudentNativePlace" lay-verify="required" autocomplete="off" placeholder="籍贯"--%>
                           <%--class="layui-input">--%>
                  <%--</div>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                  <%--<label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 手机号</label>--%>
                  <%--<div class="layui-input-inline">--%>
                    <%--<input type="text" name="ztStudentMobilePhone" lay-verify="required" autocomplete="off" placeholder="手机号"--%>
                           <%--class="layui-input">--%>
                  <%--</div>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                  <%--<label class="layui-form-label">工作单位</label>--%>
                  <%--<div class="layui-input-inline">--%>
                    <%--<input type="text" name="ztStudentWorkUnit" autocomplete="off" placeholder="工作单位"--%>
                           <%--class="layui-input">--%>
                  <%--</div>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                  <%--<label class="layui-form-label"><i class="iconfont icon-essential" style="color: red"></i> 填表日期</label>--%>
                  <%--<div class="layui-input-inline">--%>
                    <%--<input type="text" name="ztStudentDateOfExam" class="layui-input" id="ztStudentDateOfExam"--%>
                           <%--placeholder="yyyy-MM-dd HH:mm:ss">--%>
                  <%--</div>--%>
                <%--</div>--%>
              </div>
              <%--<div class="layui-form-item">--%>
                <%--<div class="layui-inline">--%>
                  <%--<label class="layui-form-label"> 报名费</label>--%>
                  <%--<div class="layui-input-inline">--%>
                    <%--<input type="text" name="ztStudentRegistrationFee" autocomplete="off" placeholder="报名费"--%>
                           <%--class="layui-input">--%>
                  <%--</div>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                  <%--<label class="layui-form-label"> 招生人</label>--%>
                  <%--<div class="layui-input-inline">--%>
                    <%--<input type="text" name="ztUserId" autocomplete="off" placeholder="招生人"--%>
                           <%--class="layui-input">--%>
                  <%--</div>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                  <%--<label class="layui-form-label"> 介绍人</label>--%>
                  <%--<div class="layui-input-inline">--%>
                    <%--<input type="text" name="ztIntroducer" autocomplete="off" placeholder="介绍人"--%>
                           <%--class="layui-input">--%>
                  <%--</div>--%>
                <%--</div>--%>
                <%--<div class="layui-inline">--%>
                  <%--<label class="layui-form-label"> 买书</label>--%>
                  <%--<div class="layui-input-inline">--%>
                    <%--<input type="text" name="ztBuyBooks" autocomplete="off" placeholder="买书"--%>
                           <%--class="layui-input">--%>
                  <%--</div>--%>
                <%--</div>--%>
              <%--</div>--%>
              <%--<div class="layui-form-item layui-form-text">--%>
                <%--<label class="layui-form-label">备注</label>--%>
                <%--<div class="layui-input-block">--%>
                  <%--<textarea class="layui-textarea" placeholder="备注" name="remark"></textarea>--%>
                <%--</div>--%>
              <%--</div>--%>
              <div class="layui-form-item">
                <%--<div class="layui-form-item">--%>
                  <%--<div class="layui-inline">--%>
                    <%--<label class="layui-form-label">性别</label>--%>
                    <%--<div class="layui-input-inline">--%>
                      <%--<input type="radio" name="available" value="1" title="男" checked="">--%>
                      <%--<input type="radio" name="available" value="0" title="女">--%>
                    <%--</div>--%>
                  <%--</div>--%>
                <%--</div>--%>
                <div class="layui-form-item" style="text-align: center">
                  <button class="layui-btn" lay-submit="" lay-filter="addStudentInfo">提交</button>
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
  }).use(['index', 'common', 'treeSelect', 'laydate', 'tree', 'notice'], function () {//需要显式use common模块
    var $ = layui.$,
        form = layui.form,
        layer = parent.layer == undefined ? layui.layer : top.layer,
        treeSelect = layui.treeSelect,
        laydate = layui.laydate;


    //日期时间选择器
    laydate.render({
      elem: '#ztStudentDateOfExam',
      type: 'datetime',
      value: new Date()
    });

    //监听提交
    form.on('submit(addStudentInfo)', function () {
      var data = $("#frm").serialize();
      //使用ajax
      $.ajax({
        url: '/student/addStudentInfo.do',
        type: 'POST',
        async: true,//是否异步
        data: data,
        timeout: 10000,
        dataType: 'json',
        success: function (data) {
          if (data.ret) {
            layer.msg('部门添加成功', {
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


  });


</script>
</body>
</html>

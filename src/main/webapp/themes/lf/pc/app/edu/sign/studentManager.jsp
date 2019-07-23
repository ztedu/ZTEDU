<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/6/10
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>

<html>
<head>
  <meta charset="utf-8">
  <title>学员管理</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" type="text/css" href="../../../../../../nprogress/nprogress.css"/>
  <link rel="stylesheet" href="/layuiadmin/layui/css/modules/layui-icon-extend/file/iconfont.css" media="all">

</head>
<body>
<div class="layui-fluid">
  <div class="layui-row layui-col-space15">
    <div class="layui-col-sm12 layui-col-md12 layui-col-lg12" id="rightTable">
      <div class="layui-card">
        <div class="layui-card-body">
          <form class="layui-form" id="searchForm" method="post" onsubmit="return false;">
            <blockquote class="layui-elem-quote layui-text">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">报考学员:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="ztStudentName" id="ztStudentName" autocomplete="off" class="layui-input"
                           placeholder="报考学员"/>
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">报考院校:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="ztStudentEei" autocomplete="off" class="layui-input" placeholder="报考院校"/>
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">专业:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="ztStudentMajor" autocomplete="off" class="layui-input" placeholder="专业"/>
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">招生人:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="ztUserId" autocomplete="off" class="layui-input" placeholder="招生人"/>
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">报名时间:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="betweenDate" id="betweenDate" autocomplete="off" class="layui-input"
                           style="width: 300px"
                           placeholder="报名时间"/>
                    <input name="beginDate" id="beginDate" autocomplete="off" class="layui-input" type="hidden"/>
                    <input name="endDate" id="endDate" autocomplete="off" class="layui-input" type="hidden"/>
                  </div>
                </div>
              </div>
              <div class="layui-form-item" style="text-align: center;">
                <a class="layui-btn" id="search_btn">
                  <i class="layui-icon">&#xe615;</i>搜索
                </a>
                <button type="reset" class="layui-btn layui-btn-normal icon-btn" id="reset_btn">
                  <i class="layui-icon">&#xe9aa;</i>清空
                </button>
                <shiro:hasPermission name="student:create">
                  <a id="add_student_btn" class="layui-btn layui-btn-warm icon-btn">
                    <i class="layui-icon">&#xe654;</i>添加
                  </a>
                </shiro:hasPermission>
                <shiro:hasPermission name="student:batchdelete">
                  <a id="del_all_btn" class="layui-btn layui-btn-danger icon-btn">
                    <i class="layui-icon">&#xe640;</i>批量删除
                  </a>
                </shiro:hasPermission>
              </div>
            </blockquote>
          </form>
          <%--表格--%>
          <table class="layui-table" id="studentList" lay-filter="studentList"></table>
        </div>
      </div>
    </div>

  </div>
</div>


<!-- 表格操作列 -->
<script type="text/html" id="student-tool-bar">
  <shiro:hasPermission name="student:update">
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="dept_edit">编辑</a>
  </shiro:hasPermission>

  <shiro:hasPermission name="student:delete">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="dept_del">删除</a>
  </shiro:hasPermission>
</script>

<script type="text/html" id="student-toolbar">
  <div class="layui-btn-container">
    <a class="layui-btn layui-btn-sm" id="open_up_btn" lay-event="openOrCloseForm">
      <i class="iconfont layui-extend-zhankai" id="turn_up_icon" style="color: white"/>
    </a>
  </div>
</script>

<script src="/layuiadmin/layui/layui.js"></script>
<script src="/nprogress/nprogress.js"></script>

<script type="text/javascript">
  var tableIns;
  var tableCounts;//数据表格总的数据数
  var currentPage;//数据表格当前的页码值
  var tableLimit;//数据表格每页条数的限制条数
  var addSuccess;//添加部门是否成功
  var addedNodeParent;//新增树节点的父亲节点
  var upadteNodeSuccess;//修改左边的树节点是否成功
  var updatedNodeDept;//修改节点成功后返回的更新后的节点信息


  layui.config({
    base: '../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index', //主入口模块
    "tablePlug": "../lib/extend/tablePlug/tablePlug",
    "laydatePro": "../lib/extend/laydatePro/laydatePro"
  }).use(['index', 'common', 'laypage', 'fuzzysearch', 'layuiTableExtend', 'tablePlug', 'laydatePro'], function () {//需要显式use common模块

    var $ = layui.$,
        form = layui.form,
        admin = layui.admin,
        index = layer.load(2),//添加laoding,0-2两种方式
        layuiTableExtend = layui.layuiTableExtend,
        laydate = layui.laydate,
        table = layui.table;


    $(function () {
      NProgress.start();
      addSuccess = false;

      laydate.render({
        elem: '#betweenDate',
        type: 'datetime', // 新增两个类型的支持 range的时候的date和datetime
        range: '~',
        quickSelect: [
          'today', // 这个是个内部的支持的，可以简化设置
          'lastDays-7', // 过去7天
          'lastDays-30', // 过去30天
          'yesterday', // 昨天
          'lastMonth', // 上个月
          'thisMonth', // 这个月
          {
            title: '昨、今、明',
            value: function () {
              var date1 = new Date();
              var date2 = new Date();
              date1.setDate(date1.getDate() - 1);
              date2.setDate(date2.getDate() + 1);
              return [date1, date2];
            }()
          }, {
            title: '当班',
            value: function () {
              var date1 = new Date();
              var date2 = new Date();
              date1.setDate(date1.getDate() - 1);
              date1.setHours(12, 30, 0, 0);
              date2.setHours(12, 30, 0, 0);
              return [date1, date2];
            }()
          } // value是一个区间的范围
        ],
        done: function (value, date) {
          document.getElementById("beginDate").value = value.split("~")[0].trim();
          document.getElementById("endDate").value = value.split("~")[1].trim();
        }
      });
    });

    //学员列表
    tableIns = table.render({
      elem: '#studentList',
      url: '/student/loadAllStudents.do',
      cellMinWidth: 95,
      page: {
        groups: 5 //只显示 5 个连续页码
      },
      height: "full",
      limits: [15, 40, 100, 300],
      limit: 15,
      id: "studentListTable",
      even: true,
      cols: [[
        {
          type: "checkbox", fixed: "left", width: 50
        }, {
          field: 'ztStudentName', title: '报考学员', minWidth: 80, width: 100, align: 'center', sort: false
        }, {
          field: 'ztStudentEei', title: '报考院校', minWidth: 80, width: 110, align: 'center', sort: false
        }, {
          field: 'ztStudentMajor', title: '专业', minWidth: 80, width: 110, align: 'center', sort: false
        }, {
          field: 'ztStudentLevel', title: '层次', minWidth: 80, width: 110, align: 'center', sort: false
        }, {
          field: 'ztStudentRegistrationFee', title: '报名费', minWidth: 80, width: 80, align: 'center', sort: false
        }, {
          field: 'ztUserId', title: '招生人', minWidth: 80, width: 110, align: 'center', sort: false
        }, {
          field: 'ztIntroducer', title: '报名人', minWidth: 80, width: 110, align: 'center', sort: false
        }, {
          field: 'ztBuyBooks', title: '买书', minWidth: 80, width: 110, align: 'center', sort: false
        }, {
          sort: true, align: 'center', minWidth: 80, width: 170, templet: function (d) {
            return layui.util.toDateString(d.ztStudentDateOfExam);
          }, title: '报名日期'
        },
        {align: 'center', fixed: 'right', toolbar: '#student-tool-bar', title: '操作', width: 160, minWidth: 160}
      ]],
      toolbar: true,
      toolbar: '#student-toolbar',
      done: function (res, curr, count) {   //返回数据执行回调函数
        NProgress.done();
        layer.close(index);
        currentPage = curr;
        tableCounts = count;
        tableLimit = $(".layui-laypage-limits").find("option:selected").val();
      }
    });


    //查询部门信息
    $("#search_btn").on("click", function () {
      var params = $("#searchForm").serialize();
      table.reload('studentListTable', {
        url: '/dept/loadAllDepts.do?' + params,
        page: {
          curr: 1  //从第一页开始
        },
      });
    });


    //头工具栏事件
    table.on('toolbar(studentList)', function (obj) {
      var checkStatus = table.checkStatus(obj.config.id);
      switch (obj.event) {
        case 'openOrCloseForm':
          if ($("#searchForm").is(":hidden")) {
            $("#searchForm").show(300);
            $("#turn_up_icon").addClass("layui-icon layui-extend-zhankai")
            $("#turn_up_icon").removeClass("layui-icon layui-extend-shouqi")
          } else {
            $("#searchForm").hide(300);
            $("#turn_up_icon").addClass("layui-icon layui-extend-shouqi")
            $("#turn_up_icon").removeClass("layui-icon layui-extend-zhankai")
          }
          break;
      }
      ;
    });

    // reset_btn,清空按钮后刷新部门信息列表
    $("#reset_btn").on("click", function () {
      form.render();
      table.reload('studentListTable', {
        url: '/dept/loadAllDepts.do',
        page: {
          curr: 1  //清空按钮点击后刷新整个列表界面，从第一页开始展示
        },
      });
    });

    //回车键进行搜索
    $('#searchForm').bind('keydown', function (event) {
      if (event.keyCode == "13") {
        var params = $("#searchForm").serialize();
        table.reload('studentListTable', {
          url: '/dept/loadAllDepts.do?' + params,
          page: {
            curr: 1  //从第一页开始
          },
        });
      }
    });

    // 跳转到添加学员列表页面
    $("#add_student_btn").click(function () {
      addSuccess = false;
      addedNodeParent = null;
      var index = layui.layer.open({
        title: "添加学员",
        type: 2,//ifream层
        area: ['100%', '100%'],
        maxmin: true,
        content: '/student/toAddStudent.do',
        success: function (layero, index) {
          setTimeout(function () {
            layui.layer.tips('点击此处返回学员列表', '.layui-layer-setwin .layui-layer-close', {
              tips: 3
            });
          }, 500);
        },
        end: function () {//layer弹窗关闭的时候回调
          if (addSuccess) {//添加部门成功的时候才能进入该方法刷新树和右边列表
            var curr = layuiTableExtend.tableAdd(tableLimit, currentPage, tableCounts);
            tableIns.reload({
              page: {
                curr: curr//刷新当前页的信息
              }
            });
          }
        }
      });

      // 改变窗口大小的时候，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
      $(window).on("resize", function () {
        layui.layer.full(index);
      });
    });

    //点击每行的编辑和删除按钮
    table.on('tool(studentList)', function (obj) {
      var layEvent = obj.event,
          data = obj.data;
      switch (layEvent) {
        case 'dept_edit'://编辑部门
          upDateDept(data);
          break;
        case 'dept_del'://删除部门
          deleteDept(data);
          break;
      }
    });

    //修改部门
    function upDateDept(dept) {
      upadteNodeSuccess = false;
      updatedNodeDept = null;
      addedNodeParent = null;
      var index = layui.layer.open({
        title: "修改部门",
        type: 2,
        area: ['80%', '80%'],
        content: "/dept/toUpdateDept.do?id=" + dept.id,
        success: function (layero, index) {
          setTimeout(function () {
            layui.layer.tips('点击此处返回部门列表', '.layui-layer-setwin .layui-layer-close', {
              tips: 3
            });
          }, 500);
        },
        end: function () {
          //刷新左边的树
          if (upadteNodeSuccess) {
            //刷新右边的table
            tableIns.reload({
              page: {
                curr: currentPage//刷新当前页的信息
              }
            });
          }
        }
      });

      // 改变窗口大小的时候，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
      $(window).on("resize", function () {
        layui.layer.full(index);
      });
    }


    //删除部门信息
    function deleteDept(dept) {
      layui.layer.confirm('确定删除【' + dept.name + '】部门吗?', {icon: 3, title: '提示信息'}, function (index) {
        $.post("/dept/deleteDept.do", {
          id: dept.id,//将需要删除的id作为参数传入
          pid: dept.pid//将需要删除的pid作为参数传入
        }, function (data) {
          if (data.code === 901) {
            layer.alert(data.msg, {icon: 2});
            layer.close(index);
          } else if (data.code === 902) {
            layer.alert(data.msg, {icon: 2});
            layer.close(index);
          } else if (data.code === 900) {
            layer.alert(data.msg, {icon: 2});
            layer.close(index);
          } else if (data.ret) {
            layer.msg('部门删除成功', {
              offset: '15px'
              , icon: 1
              , time: 1000
              , offset: '50%'
              , shift: 6
            }, function () {
              var curr = layuiTableExtend.tableDel(tableLimit, currentPage, tableCounts);
              tableIns.reload({
                page: {
                  curr: curr
                }
              });
              layer.close(index);
            });
          }
        })
      });
    }


    //批量删除
    $("#del_all_btn").click(function () {
      //得到当前表格里面的checkbox的选中对象集合
      var checkStatus = table.checkStatus('studentListTable'),//选中状态
          data = checkStatus.data;//选中的对象集
      var ids = "a=1";
      var deptIdArray = new Array();
      if (data.length > 0) {
        for (var i in data) {
          ids += "&ids=" + data[i].id;
          deptIdArray.push(data[i].id);
        }
        layer.confirm('确定删除选中的部门吗?', {icon: 3, title: '提示信息'}, function (index) {
          parent.layer.msg('删除中...', {icon: 16, shade: 0.3});
          $.post("/dept/batchDeleteDept.do?" + ids, function (data) {
            layer.closeAll('loading');
            if (data.ret) {
              //刷新table
              tableIns.reload({
                page: {
                  curr: layuiTableExtend.tableBatchDel(checkStatus)
                }
              });
              //关闭提示框
              layer.close(index);
              parent.layer.msg('删除成功！', {icon: 1, time: 1500, shade: 0.2});
            } else {
              if (data.code == 900) {
                // layer.alert(data.msg, {icon: 2});
                parent.layer.msg(data.msg, {icon: 2, time: 2000, shade: 0.2});
                layer.close(index);
              }
              if (data.code == 901) {
                // layer.alert(data.msg, {icon: 2});
                parent.layer.msg(data.msg, {icon: 2, time: 2000, shade: 0.2});
                layer.close(index);
              }
              //关闭提示框
              layer.close(index);

            }
          })
        })
      } else {
        layer.msg("请选择需要删除的部门!", {
          icon: 0
        });
      }
    });


  });


</script>
</body>
</html>

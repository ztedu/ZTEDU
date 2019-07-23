<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/22
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>

<html>
<head>
  <meta charset="utf-8">
  <title>日志管理</title>
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
<div class="layui-fluid">
  <div class="layui-row layui-col-space15">
    <%--<!-- 表格 -->--%>
    <div class="layui-col-sm15 layui-col-md15 layui-col-lg15" id="rightTable">
      <div class="layui-card">
        <div class="layui-card-body">
          <form class="layui-form" id="searchForm" method="post" onsubmit="return false;">
            <blockquote class="layui-elem-quote layui-text">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">日志类型:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="type" autocomplete="off" class="layui-input" placeholder="日志类型"/>
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">日志标题:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="title" autocomplete="off" class="layui-input" placeholder="日志标题"/>
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">请求方式:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="method" autocomplete="off" class="layui-input" placeholder="请求方式"/>
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">操作人:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="userName" autocomplete="off" class="layui-input" placeholder="操作人"/>
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">操作时间:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="betweenDate" id="betweenDate" autocomplete="off" class="layui-input"
                           style="width: 300px"
                           placeholder="操作时间"/>
                    <input name="beginDate" id="beginDate" autocomplete="off" class="layui-input" type="hidden"/>
                    <input name="endDate" id="endDate" autocomplete="off" class="layui-input" type="hidden"/>
                  </div>
                </div>
              </div>
              <div class="layui-form-item" style="text-align: center;">
                <shiro:hasPermission name="log:select">
                  <a class="layui-btn" id="search_btn">
                    <i class="layui-icon">&#xe615;</i>搜索
                  </a>
                </shiro:hasPermission>
                <shiro:hasPermission name="log:reset">
                  <button type="reset" class="layui-btn layui-btn-normal icon-btn" id="reset_btn">
                    <i class="layui-icon">&#xe9aa;</i>重置
                  </button>
                </shiro:hasPermission>
                <shiro:hasPermission name="log:batchDel">
                  <a id="del_all_btn" class="layui-btn layui-btn-danger icon-btn">
                    <i class="layui-icon">&#xe640;</i>批量删除
                  </a>
                </shiro:hasPermission>
              </div>
            </blockquote>
          </form>
          <%--表格--%>
          <table class="layui-table" id="logList" lay-filter="logList"></table>
        </div>
      </div>
    </div>

  </div>
</div>

<!-- 表格操作列 -->
<script type="text/html" id="log-tool-bar">
  <shiro:hasPermission name="log:restore">
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="log_restore">还原</a>
  </shiro:hasPermission>
  <shiro:hasPermission name="log:delete">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="log_delete">删除</a>
  </shiro:hasPermission>
  <shiro:hasPermission name="log:report">
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="log_report">打印</a>
  </shiro:hasPermission>
</script>

<script type="text/html" id="log-toolbar">
  <div class="layui-btn-container">
    <a class="layui-btn layui-btn-sm" id="open_up_btn" lay-event="openOrCloseForm">
      <i class="iconfont layui-extend-zhankai" id="turn_up_icon" style="color: white"/>
    </a>
    <shiro:hasPermission name="log:clearLog">
      <button class="layui-btn layui-btn-danger layui-btn-sm" lay-event="clearLogs">清空</button>
    </shiro:hasPermission>
    <shiro:hasPermission name="log:exportLogs">
      <button class="layui-btn layui-btn-normal layui-btn-sm" lay-event="exportLogs">导出</button>
    </shiro:hasPermission>
    <shiro:hasPermission name="log:clearLog">
      <button class="layui-btn layui-btn-normal layui-btn-sm" lay-event="isAll">导入</button>
    </shiro:hasPermission>
  </div>
</script>

<script src="/layuiadmin/layui/layui.js"></script>
<script src="/nprogress/nprogress.js"></script>

<script type="text/javascript">
  var tableIns;
  var tableCounts;//数据表格总的数据数
  var currentPage;//数据表格当前的页码值
  var tableLimit;//数据表格每页条数的限制条数

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
        tablePlug = layui.tablePlug,
        laydatePro = layui.laydatePro,
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
          // document.getElementById("beginDate").value = new Date(Date.parse(value.split("~")[0].trim().replace(/-/g, "/")));
          // document.getElementById("endDate").value = new Date(Date.parse(value.split("~")[1].trim().replace(/-/g, "/")));
          document.getElementById("beginDate").value = value.split("~")[0].trim();
          document.getElementById("endDate").value = value.split("~")[1].trim();
        }
      });
    });


    //部门列表
    tableIns = table.render({
      elem: '#logList',
      url: '/log/loadAllLogs.do',
      cellMinWidth: 95,
      page: {
        groups: 5 //只显示 5 个连续页码
      },
      height: "full",
      limits: [10, 20, 50, 100, 1000],
      limit: 10,
      id: "logListTable",
      even: true,
      // loading: true, //翻页加loading
      // skin: 'line' //表格风格
      cols: [[
        {
          type: "checkbox", fixed: "left", width: 50
        }, {
          field: 'logId', title: '日志ID', minWidth: 50, width: 300, align: 'center', sort: false
        }, {
          field: 'userName', title: '操作人', minWidth: 50, width: 120, align: 'center'
        }, {
          field: 'type', title: '日志类型', minWidth: 50, width: 120, align: 'center', sort: false
        }, {
          field: 'title', title: '日志标题', minWidth: 50, width: 120, align: 'center'
        }, {
          field: 'remoteAddr', title: '请求地址', minWidth: 100, width: 120, align: 'center'
        }, {
          field: 'requestUri', title: 'URI', minWidth: 100, width: 150, align: 'center'
        }, {
          field: 'method', title: '请求方式', minWidth: 50, width: 100, align: 'center'
        }, {
          field: 'params', title: '提交参数', minWidth: 50, width: 150, align: 'center'
        }, {
          field: 'operateDate', title: '开始时间', minWidth: 50, width: 200, align: 'center'
        }, {
          field: 'timeout', title: '结束时间', minWidth: 50, width: 100, align: 'center'
        }, {
          field: 'exception', title: '异常', minWidth: 50, width: 100, align: 'center'
        }, {align: 'center', fixed: 'right', toolbar: '#log-tool-bar', title: '操作', minWidth: 80, width: 170}
      ]],
      toolbar: true,
      toolbar: '#log-toolbar',
      done: function (res, curr, count) { //返回数据执行回调函数
        NProgress.done();
        layer.close(index); //返回数据关闭loading
        //如果是异步请求数据方式，res即为你接口返回的信息。
        //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
        //得到当前页码
        currentPage = curr;
        //得到数据总量
        tableCounts = count;
        //获得每一页的条数
        tableLimit = $(".layui-laypage-limits").find("option:selected").val();
      }
    });


    //查询部门信息
    $("#search_btn").on("click", function () {
      var params = $("#searchForm").serialize();
      table.reload('logListTable', {
        url: '/log/selectLogs.do?' + params,
        page: {
          curr: 1 //从第一页开始
        },
      });
    });

    //头工具栏事件
    table.on('toolbar(logList)', function (obj) {
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
        case 'clearLogs'://日志清空
          clearLogs();
          break;
        case 'exportLogs':
          exportLogs();//日志导出
          break;
        case 'isAll':
          layer.msg(checkStatus.isAll ? '全选' : '未全选');
          break;
      }
    });

    // reset_btn,清空按钮后刷新部门信息列表
    $("#reset_btn").on("click", function () {
      form.render();
      table.reload('logListTable', {
        url: '/log/resetLogs.do',
        page: {
          curr: 1 //清空按钮点击后刷新整个列表界面，从第一页开始展示
        },
      });
    });

    //回车键进行搜索
    $('#searchForm').bind('keydown', function (event) {
      if (event.keyCode == "13") {
        var params = $("#searchForm").serialize();
        table.reload('logListTable', {
          url: '/log/selectLogs.do?' + params,
          page: {
            curr: 1 //从第一页开始
          },
        });
      }
    });


    //点击每行的编辑和删除按钮
    table.on('tool(logList)', function (obj) {
      var layEvent = obj.event,
          data = obj.data;
      switch (layEvent) {
        case 'log_restore'://还原
          upDateLog(data);
          break;
        case 'log_delete'://删除
          deleteLog(data);
          break;
        case 'log_report'://导出
          reportLog(data);
          break;
      }
    });

    //导出日志
    function exportLogs() {
      layui.layer.confirm('您确定要导出所有的日志吗？', {icon: 3, title: '提示信息'}, function (index) {
        layer.msg('正在导出日志...', {
          icon: 16,
          shade: 0.01,
          time: 3000
        });
        window.location.href = "${contextPath}/log/exportLogs.do";
        <%--$.post("/log/exportLogs.do", {}, function (data) {--%>
        <%--if (data.ret) {--%>
        <%--if (data.data.status == 200) {--%>
        <%--// layer.close(downLoading);--%>
        <%--layer.msg('日志导出成功'+data.data.message, {--%>
        <%--offset: '15px'--%>
        <%--, icon: 1--%>
        <%--, time: 1000--%>
        <%--, offset: '50%'--%>
        <%--, shift: 6--%>
        <%--}, function () {--%>
        <%--window.location.href="${contextPath}/log/exportLogs.do";--%>
        <%--tableIns.reload({--%>
        <%--page: {--%>
        <%--curr: 1--%>
        <%--}--%>
        <%--});--%>
        <%--layer.close(index);--%>
        <%--});--%>
        <%--} else {--%>
        <%--layer.msg(data.data.message, {--%>
        <%--// offset: '15px'--%>
        <%--offset: '50%'--%>
        <%--, icon: 2--%>
        <%--, time: 3000--%>
        <%--}, function () {--%>
        <%--relodaBtn();--%>
        <%--});--%>
        <%--}--%>
        <%--}--%>
        <%--})--%>
      });
    }

    //清空日志信息
    function clearLogs() {
      layui.layer.confirm('您确定要清空所有的日志吗？', {icon: 3, title: '提示信息'}, function (index) {
        $.post("/log/clearLogs.do", {}, function (data) {
          if (data.ret) {
            layer.msg('日志清空成功', {
              offset: '15px'
              , icon: 1
              , time: 1000
              , offset: '50%'
              , shift: 6
            }, function () {
              tableIns.reload({
                page: {
                  curr: 1
                }
              });
              layer.close(index);
            });
          }
        })
      });
    }

    //删除日志信息
    function deleteLog(log) {
      layui.layer.confirm('确定删除【' + log.title + '】吗?', {icon: 3, title: '提示信息'}, function (index) {
        $.post("/log/deleteLog.do", {
          logId: log.logId,//将需要删除的id作为参数传入
        }, function (data) {
          if (data.ret) {
            layer.msg('日志删除成功', {
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


    //打印日志信息
    function reportLog(log) {
      layui.layer.confirm('确定打印【' + log.title + '】吗?', {icon: 3, title: '提示信息'}, function (index) {
        // $.post("/log/report.do", {
        //   logId: log.logId,//将需要删除的id作为参数传入
        // }, function (data) {
        //
        // })


        // layer.close(index);
        // var params = {
        //   logId: log.logId
        // };
        // var win = window.open();   // 放在外面是因为浏览器可能会阻止新打开窗口，放在异步请求外面就ok ！！！
        // $.ajax({
        //   url: '/log/reportLog',
        //   type: 'post',
        //   data: params,
        //   asyn: false
        // }).done(function (data) {
        //   var doc = win.document;
        //   doc.write(data);    // !!! 关键，接收后端的数据并进行新窗口写入
        //   doc.close();
        // });

        window.open('/log/reportLog', '_blank')
      });
    }


    //批量删除
    $("#del_all_btn").click(function () {
      //得到当前表格里面的checkbox的选中对象集合
      var checkStatus = table.checkStatus('logListTable'),//选中状态
          data = checkStatus.data;//选中的对象集
      var ids = "a=1";
      if (data.length > 0) {
        for (var i in data) {
          ids += "&ids=" + data[i].logId;
        }
        layer.confirm('确定删除选中的日志吗?', {icon: 3, title: '提示信息'}, function (index) {
          parent.layer.msg('删除中...', {icon: 16, shade: 0.3});
          $.post("/log/batchDeleteLogs.do?" + ids, function (data) {
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
              //关闭提示框
              layer.close(index);
            }
          })
        })
      } else {
        layer.msg("请选择需要删除的日志!", {
          icon: 0
        });
      }
    });


  });


</script>
</body>
</html>

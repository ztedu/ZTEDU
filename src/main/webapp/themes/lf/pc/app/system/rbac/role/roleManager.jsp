<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/7/4
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>

<html>
<head>
  <meta charset="utf-8">
  <title>角色管理</title>
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
    <div class="layui-col-sm15 layui-col-md15 layui-col-lg15" id="rightTable">
      <div class="layui-card">
        <div class="layui-card-body">
          <form class="layui-form" id="searchForm" method="post" onsubmit="return false;">
            <blockquote class="layui-elem-quote layui-text">
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">角色名称:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="name" id="name" autocomplete="off" class="layui-input" placeholder="角色名称"/>
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">角色备注:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="remark" autocomplete="off" class="layui-input" placeholder="角色备注"/>
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
                <shiro:hasPermission name="role:create">
                  <a id="add_role_btn" class="layui-btn layui-btn-warm icon-btn">
                    <i class="layui-icon">&#xe654;</i>添加
                  </a>
                </shiro:hasPermission>
                <shiro:hasPermission name="role:batchdelete">
                  <a id="del_all_btn" class="layui-btn layui-btn-danger icon-btn">
                    <i class="layui-icon">&#xe640;</i>批量删除
                  </a>
                </shiro:hasPermission>
              </div>
            </blockquote>
          </form>
          <%--表格--%>
          <table class="layui-table" id="roleList" lay-filter="roleList"></table>
        </div>
      </div>
    </div>

  </div>
</div>

<!-- 表格操作列 -->
<script type="text/html" id="role-tool-bar">

  <shiro:hasPermission name="role:update">
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="role_edit">编辑</a>
  </shiro:hasPermission>

  <shiro:hasPermission name="role:delete">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="role_del">删除</a>
  </shiro:hasPermission>

  <shiro:hasPermission name="role:aigPers">
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="role_aigPers">分配权限</a>
  </shiro:hasPermission>
</script>

<script type="text/html" id="role-toolbar">
  <div class="layui-btn-container">
    <a class="layui-btn layui-btn-sm" id="open_up_btn" lay-event="openOrCloseForm">
      <i class="iconfont layui-extend-zhankai" id="turn_up_icon" style="color: white"/>
    </a>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
  </div>
</script>

<script src="/layuiadmin/layui/layui.js"></script>
<script src="/nprogress/nprogress.js"></script>

<script type="text/javascript">
  var tableIns;
  var tableCounts;//数据表格总的数据数
  var currentPage;//数据表格当前的页码值
  var tableLimit;//数据表格每页条数的限制条数
  var addSuccess;//添加角色是否成功


  layui.config({
    base: '../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index', //主入口模块
    "tablePlug": "../lib/extend/tablePlug/tablePlug"
  }).use(['index', 'common', 'laypage', 'layuiTableExtend', 'tablePlug'], function () {//需要显式use common模块

        var $ = layui.$,
            form = layui.form,
            admin = layui.admin,
            index = layer.load(2),//添加laoding,0-2两种方式
            layuiTableExtend = layui.layuiTableExtend,
            tablePlug = layui.tablePlug,
            table = layui.table;


        $(function () {
          NProgress.start();
          addSuccess = false;
        });


        //角色列表
        tableIns = table.render({
          elem: '#roleList',
          url: '/role/loadAllRoles.do',
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
            }, {
              field: 'orderNum', title: '排序码', minWidth: 80, align: 'center', sort: true
            }, {
              field: 'available', title: '是否可用', minWidth: 90, align: 'center', templet: function (d) {
                if (d.available == 1) {
                  return "<span  class='layui-badge layui-bg-green'>可用</span>";
                } else {
                  return "<span class='layui-badge layui-bg-red'>不可用</span>"
                }
              }
            }, {align: 'center', fixed: 'right', toolbar: '#role-tool-bar', title: '操作', minWidth: 170}
          ]],
          toolbar: true,
          toolbar: '#role-toolbar',
          done: function (res, curr, count) {   //返回数据执行回调函数
            NProgress.done();
            layer.close(index);    //返回数据关闭loading
            currentPage = curr;
            tableCounts = count;
            tableLimit = $(".layui-laypage-limits").find("option:selected").val();
          }
        });


        //查询角色信息
        $("#search_btn").on("click", function () {
          var params = $("#searchForm").serialize();
          table.reload('roleListTable', {
            url: '/role/loadAllRoles.do?' + params,
            page: {
              curr: 1  //从第一页开始
            },
          });
        });

        //头工具栏事件
        table.on('toolbar(roleList)', function (obj) {
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
            case 'getCheckData':
              var data = checkStatus.data;
              layer.alert(JSON.stringify(data));
              break;
            case 'getCheckLength':
              var data = checkStatus.data;
              layer.msg('选中了：' + data.length + ' 个');
              break;
            case 'isAll':
              layer.msg(checkStatus.isAll ? '全选' : '未全选');
              break;
          }
          ;
        });

        // reset_btn,清空按钮后刷新角色信息列表
        $("#reset_btn").on("click", function () {
          form.render();
          table.reload('roleListTable', {
            url: '/role/loadAllRoles.do',
            page: {
              curr: 1  //清空按钮点击后刷新整个列表界面，从第一页开始展示
            },
          });
        });

        //回车键进行搜索
        $('#searchForm').bind('keydown', function (event) {
          if (event.keyCode == "13") {
            var params = $("#searchForm").serialize();
            table.reload('roleListTable', {
              url: '/role/loadAllRoles.do?' + params,
              page: {
                curr: 1  //从第一页开始
              },
            });
          }
        });

        // 跳转到添加角色列表页面
        $("#add_role_btn").click(function () {
          addSuccess = false;
          var index = layui.layer.open({
            title: "添加角色",
            type: 2,//ifream层
            area: ['80%', '50%'],
            maxmin: true,
            content: '/role/toAddRole.do',
            success: function (layero, index) {
              setTimeout(function () {
                layui.layer.tips('点击此处返回角色列表', '.layui-layer-setwin .layui-layer-close', {
                  tips: 3
                });
              }, 500);
            },
            end: function () {//layer弹窗关闭的时候回调
              if (addSuccess) {//添加角色成功的时候才能进入该方法刷新右边列表
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
        table.on('tool(roleList)', function (obj) {
          var layEvent = obj.event,
              data = obj.data;
          switch (layEvent) {
            case 'role_edit'://编辑角色
              upDateRole(data);
              break;
            case 'role_del'://删除角色
              deleteRole(data);
              break;
            case 'role_aigPers':
              roleAigPers(data.id);
              break;
          }
        });

        //修改角色
        function upDateRole(role) {
          var index = layui.layer.open({
            title: "修改角色",
            type: 2,
            area: ['80%', '50%'],
            content: "/role/toUpdateRole.do?id=" + role.id,
            success: function (layero, index) {
              setTimeout(function () {
                layui.layer.tips('点击此处返回角色列表', '.layui-layer-setwin .layui-layer-close', {
                  tips: 3
                });
              }, 500);
            },
            end: function () {
              //刷新右边的table
              tableIns.reload({
                page: {
                  curr: currentPage//刷新当前页的信息
                }
              });
            }
          });

          // 改变窗口大小的时候，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
          $(window).on("resize", function () {
            layui.layer.full(index);
          });
        }


        //删除角色信息
        function deleteRole(role) {
          layui.layer.confirm('确定删除【' + role.name + '】角色吗?', {icon: 3, title: '提示信息'}, function (index) {
            $.post("/role/deleteRole.do", {
              id: role.id,//将需要删除的id作为参数传入
              pid: role.pid//将需要删除的pid作为参数传入
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
                layer.msg('角色删除成功', {
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

        // 跳转到分配权限弹出层
        function roleAigPers(roleId) {
          var index = layui.layer.open({
            title: "分配权限",
            type: 2,
            area: ['500px', '80%'],
            content: "/role/toSelectPermissions.do?id=" + roleId,
            success: function (layero, index) {
              setTimeout(function () {
                layui.layer.tips('点击此处返回角色列表', '.layui-layer-setwin .layui-layer-close', {
                  tips: 3
                });
              }, 500);
            }
          });
          // 改变窗口大小的时候，重置弹窗的高度，防止超出可视区域（如F12调出debug的操作）
          $(window).on("resize", function () {
            layui.layer.full(index);
          });
        }


        //批量删除
        $("#del_all_btn").click(function () {
          //得到当前表格里面的checkbox的选中对象集合
          var checkStatus = table.checkStatus('roleListTable'),//选中状态
              data = checkStatus.data;//选中的对象集
          var ids = "a=1";
          var roleIdArray = new Array();
          if (data.length > 0) {
            for (var i in data) {
              ids += "&ids=" + data[i].id;
              roleIdArray.push(data[i].id);
            }
            layer.confirm('确定删除选中的角色吗?', {icon: 3, title: '提示信息'}, function (index) {
              parent.layer.msg('删除中...', {icon: 16, shade: 0.3});
              $.post("/role/batchDeleteRole.do?" + ids, function (data) {
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
                    parent.layer.msg(data.msg, {icon: 2, time: 2000, shade: 0.2});
                    layer.close(index);
                  }
                  //关闭提示框
                  layer.close(index);
                }
              })
            })
          } else {
            layer.msg("请选择需要删除的角色!", {
              icon: 0
            });
          }
        });


      }
  );


</script>

</body>
</html>

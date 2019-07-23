<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/5/13
  Time: 21:13
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
<div class="layui-fluid">
  <div class="layui-row layui-col-space15">
    <%--<!-- 左树 -->--%>
    <div class="layui-col-sm12 layui-col-md4 layui-col-lg3" id="left_tree">
      <div class="layui-card">
        <div class="layui-card-body mini-bar">
          <blockquote class="layui-elem-quote layui-text">
            <button class="layui-btn icon-btn" id="">
              <i class="layui-icon">&#xe615;</i>搜索
            </button>
            <div class="layui-input-inline mr0">
              <input id="key" class="layui-input" type="search" placeholder="输入菜单名称" autocomplete="off"/>
            </div>
            <br/>
          </blockquote>
          <ul id="ltTree" class="ztree"></ul>
        </div>
      </div>
    </div>
    <%--<!-- 右表 -->--%>
    <div class="layui-col-sm12 layui-col-md8 layui-col-lg9" id="rightTable">
      <div class="layui-card">
        <div class="layui-card-body">
          <form class="layui-form" id="searchForm" method="post" onsubmit="return false;">
            <blockquote class="layui-elem-quote layui-text">
              <a class="layui-btn-sm" id="open_close_btn">
                <i class="layui-icon layui-icon-shrink-right" id="turn_icon" style="color: #00675d"></i>
              </a>
              <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">权限名称:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="name" id="name" autocomplete="off" class="layui-input" placeholder="权限名称"/>
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">权限code:</label>
                  <div class="layui-input-inline mr0">
                    <input type="text" name="percode" id="percode" autocomplete="off" class="layui-input" placeholder="权限code"/>
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
                <shiro:hasPermission name="permission:create">
                  <a id="add_permission_btn" class="layui-btn layui-btn-warm icon-btn">
                    <i class="layui-icon">&#xe654;</i>添加
                  </a>
                </shiro:hasPermission>
                <shiro:hasPermission name="permission:batchdelete">
                  <a id="del_all_btn" class="layui-btn layui-btn-danger icon-btn">
                    <i class="layui-icon">&#xe640;</i>批量删除
                  </a>
                </shiro:hasPermission>
              </div>
            </blockquote>
          </form>
          <%--表格--%>
          <table class="layui-table" id="permissionList" lay-filter="permissionList"></table>
        </div>
      </div>
    </div>
  </div>
</div>

<!-- 表格操作列 -->
<script type="text/html" id="permission-tool-bar">

  <shiro:hasPermission name="permission:update">
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="permission_edit">编辑</a>
  </shiro:hasPermission>

  <shiro:hasPermission name="permission:delete">
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="permission_del">删除</a>
  </shiro:hasPermission>
</script>

<script type="text/html" id="permission-toolbar">
  <div class="layui-btn-container">
    <%--<i class="fa fa-file-word text-primary">--%>
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
  var ztreeLeft;
  var tableCounts;//数据表格总的数据数
  var currentPage;//数据表格当前的页码值
  var tableLimit;//数据表格每页条数的限制条数
  var addSuccess;//添加权限是否成功

  // 点击左边权限树，对右边的权限信息进行刷新
  function zTreeOnClick(event, treeId, treeNode) {
    tableIns.reload({
      url: '/permission/clickTreeNodeLoadAllPermissions.do',
      where: {id: treeNode.id},
      page: {
        curr: 1  //从第一页开始
      },
    })
  }


  layui.config({
    base: '../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index', //主入口模块
    "tablePlug": "../lib/extend/tablePlug/tablePlug"
  }).use(['index', 'common', 'laypage', 'ztree', 'fuzzysearch', 'layuiTableExtend', 'tablePlug'], function () {//需要显式use common模块

    var $ = layui.$,
        fuzzysearch = layui.fuzzysearch,
        zTree = layui.ztree,
        form = layui.form,
        admin = layui.admin,
        index = layer.load(2),//添加laoding,0-2两种方式
        // layer =layui.layer,
        layuiTableExtend = layui.layuiTableExtend,
        tablePlug = layui.tablePlug,
        table = layui.table;

    var setting = {
      view: {
        dblClickExpand: false,
        showLine: true,
        selectedMulti: false
      },
      data: {
        simpleData: {
          enable: true
        }
      },
      callback: {
        onClick: zTreeOnClick
      }
    };


    $(function () {
      NProgress.start();
      addSuccess = false;
      initMenuTree();
    });


    // 加载左侧的菜单树
    function initMenuTree() {
      $.ajax({
        type: "POST",
        contentType: 'application/json; charset=utf8',
        dataType: "json",
        url: "<%=contextPath%>/menu/loadMenuLeftTree.do",
        success: function (json) {
          ztreeLeft = zTree.init($("#ltTree"), setting, json);
          fuzzysearch('ltTree', '#key', null, false); //初始化模糊搜索方法
        }
      });
    }

    //权限列表
    tableIns = table.render({
      elem: '#permissionList',//id="permissionList"
      url: '/permission/loadAllPermissions.do',
      cellMinWidth: 95,
      page: {
        groups: 5 //只显示 5 个连续页码
      },
      height: "full",
      limits: [10, 20, 50, 100],
      limit: 10,
      id: "permissionListTable",
      even: true,
      // loading: true, //翻页加loading
      // skin: 'line' //表格风格
      cols: [[
        {
          type: "checkbox", fixed: "left", width: 50
        }, {
          field: 'id', title: '权限ID', minWidth: 70, width: 80, align: 'center', sort: true
        }, {
          field: 'pid', title: '父级ID', minWidth: 70, align: 'center', sort: true
        }, {
          field: 'name', title: '权限名称', minWidth: 150, align: 'center'
        }, {
          field: 'percode', title: '权限编码', minWidth: 200, align: 'center'
        }, {
          field: 'available', title: '是否可用', minWidth: 50, align: 'center', templet: function (d) {
            if (d.available == 1) {
              return "<span  class='layui-badge layui-bg-green'>可用</span>";
            } else {
              return "<span class='layui-badge layui-bg-red'>不可用</span>"
            }
          }
        }, {
          field: 'orderNum', title: '排序码', minWidth: 50, align: 'center', sort: true
        },
        {align: 'center', fixed: 'right', toolbar: '#permission-tool-bar', title: '操作', minWidth: 170}
      ]],
      toolbar: true,
      toolbar: '#permission-toolbar',
      // defaultToolbar: ['filter', 'print', 'exports'],
      done: function (res, curr, count) {   //返回数据执行回调函数
        NProgress.done();
        layer.close(index);    //返回数据关闭loading
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

    //查询菜单信息
    $("#search_btn").on("click", function () {
      var params = $("#searchForm").serialize();
      table.reload('permissionListTable', {
        url: '/permission/loadAllPermissions.do?' + params,
        page: {
          curr: 1  //从第一页开始
        },
      });
    });


    // reset_btn,清空按钮后刷新菜单信息列表
    $("#reset_btn").on("click", function () {
      refreshTree("ltTree");
      form.render();
      table.reload('permissionListTable', {
        url: '/permission/loadAllPermissions.do',
        page: {
          curr: 1  //清空按钮点击后刷新整个列表界面，从第一页开始展示
        },
      });
    });

    //刷新整棵树
    function refreshTree(treeName) {
      var treeObj = zTree.getZTreeObj(treeName);//根据 treeId 获取 zTree 对象
      treeObj.expandAll(true);//折叠全部节点,参数为true时表示展开全部节点
      treeObj.refresh();
    }


    //回车键进行搜索
    $('#searchForm').bind('keydown', function (event) {
      if (event.keyCode == "13") {
        var params = $("#searchForm").serialize();
        table.reload('permissionListTable', {
          url: '/permission/loadAllPermissions.do?' + params,
          page: {
            curr: 1  //从第一页开始
          },
        });
      }
    });


    //点击每行的编辑和删除按钮
    table.on('tool(permissionList)', function (obj) {
      var layEvent = obj.event,
          data = obj.data;

      switch (layEvent) {
        case 'permission_edit'://编辑权限
          updatePermission(data);
          break;
        case 'permission_del'://删除权限
          deletePermission(data);
          break;
      }
    });

    //展开和关闭左边的树
    $("#open_close_btn").click(function () {
      if ($("#left_tree").is(":hidden")) {
        $("#left_tree").show(300);
        $("#rightTable").addClass("layui-col-sm12 layui-col-md8 layui-col-lg9");
        $("#turn_icon").removeClass("layui-icon layui-icon-spread-left")
        $("#turn_icon").addClass("layui-icon layui-icon-shrink-right")
      } else {
        $("#left_tree").hide(300);
        $("#rightTable").removeClass("layui-col-sm12 layui-col-md8 layui-col-lg9");
        $("#turn_icon").removeClass("layui-icon layui-icon-shrink-right")
        $("#turn_icon").addClass("layui-icon layui-icon-spread-left")
      }
    });

    //头工具栏事件
    table.on('toolbar(permissionList)', function (obj) {
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

    //批量删除
    $("#del_all_btn").click(function () {
      //得到当前表格里面的checkbox的选中对象集合
      var checkStatus = table.checkStatus('permissionListTable'),//选中状态
          data = checkStatus.data;//选中的对象集
      var ids = "a=1";
      var permissionIdArray = new Array();
      if (data.length > 0) {
        for (var i in data) {
          ids += "&ids=" + data[i].id;
          permissionIdArray.push(data[i].id);
        }
        layer.confirm('确定删除选中的权限吗?', {icon: 3, title: '提示信息'}, function (index) {
          parent.layer.msg('删除中...', {icon: 16, shade: 0.3});
          $.post("/permission/batchDeletePermission.do?" + ids, function (data) {
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
              //刷新左边的树
              var zTreeDelete = zTree.getZTreeObj("ltTree");
              for (var idPermission in permissionIdArray) {
                var deleteNode = zTreeDelete.getNodeByParam("id", permissionIdArray[idPermission]);
                zTreeDelete.removeNode(deleteNode);
              }
              parent.layer.msg('删除成功！', {icon: 1, time: 1500, shade: 0.2});
            } else {
              //关闭提示框
              layer.close(index);
            }
          })
        })
      } else {
        layer.msg("请选择需要删除的权限!", {
          icon: 0
        });
      }
    });


    //删除权限信息
    function deletePermission(permission) {
      layui.layer.confirm('确定删除【' + permission.name + '】权限吗?', {icon: 3, title: '提示信息'}, function (index) {
        $.post("/permission/deletePermission.do", {
          id: permission.id,//将需要删除的id作为参数传入
          pid: permission.pid//将需要删除的pid作为参数传入
        }, function (data) {
          if (data.ret) {
            layer.msg('权限删除成功', {
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
              var zTreeDelete = zTree.getZTreeObj("ltTree");
              var deleteNode = zTreeDelete.getNodeByParam("id", permission.id);
              zTreeDelete.removeNode(deleteNode);
            });
          }
        })
      });
    }

    //修改权限信息
    function updatePermission(permission) {
      var index = layui.layer.open({
        title: "修改权限",
        type: 2,
        area: ['80%', '50%'],
        content: "/permission/toUpdatePermission.do?id=" + permission.id,
        success: function () {
          setTimeout(function () {
            layui.layer.tips('点击此处返回菜单列表', '.layui-layer-setwin .layui-layer-close', {
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


    // 跳转到添加权限列表页面
    $("#add_permission_btn").click(function () {
      addSuccess = false;
      var index = layui.layer.open({
        title: "添加权限",
        type: 2,//ifream层
        area: ['80%', '50%'],
        maxmin: true,
        content: '/permission/toAddPermission.do',
        success: function () {
          setTimeout(function () {
            layui.layer.tips('点击此处返回权限列表', '.layui-layer-setwin .layui-layer-close', {
              tips: 3
            });
          }, 500);
        },
        end: function () {//layer弹窗关闭的时候回调
          if (addSuccess) {//添加菜单成功的时候才能进入该方法刷新树和右边列表
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


  });


</script>
</body>
</html>

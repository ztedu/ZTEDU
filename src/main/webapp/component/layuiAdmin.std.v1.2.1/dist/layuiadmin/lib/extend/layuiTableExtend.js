layui.define(['index', 'form', 'layer', 'table'], function (exports) {
  var $ = layui.jquery;

  var layuiTableExtend = {

    //当前是第几页
    // var current = $(".layui-laypagze-skip").find("input").val();
    //表格总的条数
    // alert("tableCounts" + tableCounts);
    //当前页的条数
    // var limit = $(".layui-laypage-limits").find("option:selected").val();
    //取出obj里面的tr里面的data-index
    // var dataIndex = $(obj.tr[0]).attr("data-index");
    //取得当前页
    // var curr = $(".layui-laypage-curr em:eq(1)").text();
    //删除部门的时候如果是最后一页的最后一条数据，则需要刷新至倒数第二页
    /*
      var tableCounts;//数据表格总的数据数
      var currentPage;//数据表格当前的页码值
      var tableLimit;//数据表格每页条数的限制条数

    tableIns = table.render({done: function (res, curr, count) {   //返回数据执行回调函数
        layer.close(index);    //返回数据关闭loading
        //如果是异步请求数据方式，res即为你接口返回的信息。
        //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
        // console.log(res);
        //得到当前页码
        currentPage = curr;
        //得到数据总量
        tableCounts = count;
        //获得每一页的条数
        tableLimit = $(".layui-laypage-limits").find("option:selected").val();
      }
    });
          */
    tableDel: function (limit, currentPage, tableCounts) {
      if (currentPage == 1) {
        return currentPage;
      } else {
        if ((tableCounts - limit * (currentPage - 1)) == 1) {//判断当前页里面的数据是不是只有一条
          return currentPage - 1;
        } else {
          return currentPage;
        }
      }
    },

    //批量删除
    tableBatchDel: function (checkStatus) {
      if (checkStatus.isAll) {
        currentPage = currentPage == 1 ? currentPage : currentPage - 1;
      }
      return currentPage;
    },

    // layui.table添加数据的时候跳转的页面
    tableAdd: function (tableLimit, currentPage, tableCounts) {
      if (tableLimit * currentPage < tableCounts) {
        // console.log("tableIns.config.limit * currentPage < tableCounts");
        var finallyPage = (tableCounts - (tableCounts % tableLimit)) / tableLimit + 1;
        currentPage = finallyPage;
        if (tableCounts == currentPage * tableLimit) {
          currentPage = currentPage + 1;
          return currentPage;
        } else {
          return currentPage;
        }
      } else if (tableLimit * currentPage == tableCounts) {
        if (addSuccess) {
          currentPage = currentPage + 1;
          return currentPage;
        } else {
          return currentPage;
        }
        // console.log("tableIns.config.limit * currentPage == tableCounts");
      } else if (tableLimit * currentPage > tableCounts) {
        // console.log("tableIns.config.limit * currentPage > tableCounts");
        if (tableCounts == currentPage * tableLimit) {
          currentPage = currentPage + 1;
          return currentPage;
        } else {
          return currentPage;
        }
      }
    }


  };

  exports('layuiTableExtend', layuiTableExtend);
});
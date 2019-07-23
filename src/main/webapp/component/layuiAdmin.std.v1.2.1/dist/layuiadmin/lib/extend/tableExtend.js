/**
 * @Title:        ZTEDU
 * @Description   TODO
 * @Company:      http://www.ztedu.online
 *
 * @Author        LYQ
 * @CreateDate    2019/1/21 20:39
 */
layui.define(['index', 'form', 'layer', 'table'], function (exports) {
  var layer = layui.layer,
      $ = layui.jquery,
      table = layui.table;

  var dataTableObj = {
    parentTableData: [],
    parentTableCols: [],
    parentTable: {
      compareKey: "",
      compareTitle: ""
    },

    renderParentTable: function (obj) {
      var _this = this;
      this.parentTable.compareKey = obj.compareKey;
      this.parentTableCols = obj.cols;
      var hideNum = [];
      for (var i = 0; i < obj.cols[0].length; i++) {
        if (obj.compareKey == obj.cols[0][i].field) {
          this.parentTable.compareTitle = obj.cols[0][i].title;
        }
        // 设置隐藏列（cols中设置style:'display:none;'）的表头同时被隐藏
        if (obj.cols[0][i].style) {
          hideNum.push(i);
        }
      }
      _this.parentTableData = obj.data.list;

      table.render({
        elem: obj.id,
        data: _this.parentTableData,
        height: obj.height,
        id: "parentTable",
        cols: obj.cols,
        page: obj.page,
        limits: obj.limits ? obj.limits : [10, 15, 20, 25],
        limit: obj.limit ? obj.limit : 10,
        done: function () {
          // 设置隐藏列（cols中设置style:'display:none;'）的表头同时被隐藏
          for (var i = 0; i < hideNum.length; i++) {
            $('.layui-table-box .layui-table-header table.layui-table thead tr th:eq(' + hideNum[i] + ')').addClass('layui-hide');
          }
        }
      });
    }
  };

  table.on('edit()', function (obj) { //注：edit是固定事件名，test是table原始容器的属性 lay-filter="对应的值"
    var cols = dataTableObj.parentTableCols;
    var format;
    for (var i = 0; i < cols[0].length; i++) {
      if (cols[0][i].field == obj.field) {
        format = cols[0][i].format;
        break;
      }
    }
    if (format == 'int' && !/^-?\d+$/.test(obj.value)) {
      layer.msg("只能输入整数类型！", {icon: 2, time: 1500});
      dataTableObj.parentTableData[obj.tr.data('index')][obj.field] = $(this).prev().text();
    }
    if (format == 'num' && !/^(-?\d+)(\.\d+)?$/.test(obj.value)) {
      layer.msg("只能输入数值类型！", {icon: 2, time: 1500});
      dataTableObj.parentTableData[obj.tr.data('index')][obj.field] = $(this).prev().text();
    } else if (format == 'tel' && !/^[1][3,4,5,7,8][0-9]{9}$/.test(obj.value)) {
      layer.msg("手机号码格式不正确！", {icon: 2, time: 1500});
      dataTableObj.parentTableData[obj.tr.data('index')][obj.field] = $(this).prev().text();
    } else if (format == 'money') {
      if (!/^(\d+)(\.\d+)?$/.test(obj.value)) {
        layer.msg("金额输入不合法！", {icon: 2, time: 1500});
        dataTableObj.parentTableData[obj.tr.data('index')][obj.field] = $(this).prev().text();
      } else {
        var str = (obj.value * 1).toFixed(2) + '';
        var intSum = str.substring(0, str.indexOf(".")).replace(/\B(?=(?:\d{3})+$)/g, ',');//取到整数部分
        var dot = str.substring(str.length, str.indexOf("."))//取到小数部分搜索
        var ret = intSum + dot;
        dataTableObj.parentTableData[obj.tr.data('index')][obj.field] = ret;
      }
    } else if (format == 'mail' && !/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/.test(obj.value)) {
      layer.msg("邮箱格式不合法！", {icon: 2, time: 1500});
      dataTableObj.parentTableData[obj.tr.data('index')][obj.field] = $(this).prev().text();
    }
  });
  exports('tableExtend', dataTableObj);
});

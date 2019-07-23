<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/1/25
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>

<html>
<style>
  .title_system_style {
    text-align: center;
    /*color: #F00;*/
    font-size: 13px;
    font-weight: bold;
  }

  .console {
    position: absolute;
    width: 100%;
    height: 100%;
    left: 0;
    top: 0;
    right: 0;
    bottom: 0
  }

</style>
<head>
  <meta charset="utf-8">
  <title>ZTEDU</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="/layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/style/admin.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/style/login.css" media="all">
  <link rel="stylesheet" href="/layuiadmin/layui/css/modules/layui-icon-extend/finance/iconfont.css" media="all">
  <script>
    if (window != top)
      top.location.replace(location.href);
  </script>
</head>
<body class="layui-layout-body">
<div id="LAY_app">
  <div class="layui-layout layui-layout-admin">
    <div class="layui-header">
      <!-- 头部区域 -->
      <ul class="layui-nav layui-layout-left">
        <li class="layui-nav-item layadmin-flexible" lay-unselect>
          <a href="javascript:;" layadmin-event="flexible" title="侧边伸缩">
            <i class="layui-icon layui-icon-shrink-right" id="LAY_app_flexible"></i>
          </a>
        </li>
        <li class="layui-nav-item layui-hide-xs" lay-unselect>
          <a href="http://119.23.253.57/" target="_blank" title="前台">
            <i class="layui-icon layui-icon-website"></i>
          </a>
        </li>
        <li class="layui-nav-item" lay-unselect>
          <a href="javascript:;" layadmin-event="refresh" title="刷新">
            <i class="layui-icon layui-icon-refresh-3"></i>
          </a>
        </li>
        <li class="layui-nav-item layui-hide-xs" lay-unselect>
          <input type="text" placeholder="搜索..." autocomplete="off" class="layui-input layui-input-search" layadmin-event="serach"
                 lay-action="/layuiview/template/search.html?keywords=">
        </li>
      </ul>
      <ul class="layui-nav layui-layout-right" lay-filter="layadmin-layout-right">

        <li class="layui-nav-item" lay-unselect>
          <a lay-href="/layuiview/app/message/index.html" layadmin-event="message" lay-text="消息中心">
            <%--<a lay-href="/layuiview/app/message/detail.html" layadmin-event="message" lay-text="消息中心">--%>
            <i class="layui-icon layui-icon-notice"></i>
            <!-- 如果有新消息，则显示小圆点 -->
            <span class="layui-badge-dot"></span>
          </a>
        </li>
        <li class="layui-nav-item layui-hide-xs" lay-unselect>
          <a href="javascript:;" layadmin-event="theme">
            <i class="layui-icon layui-icon-theme"></i>
          </a>
        </li>
        <%--<li class="layui-nav-item layui-hide-xs" lay-unselect>--%>
        <%--<a href="javascript:;" layadmin-event="note">--%>
        <%--<i class="layui-icon layui-icon-note"></i>--%>
        <%--</a>--%>
        <%--</li>--%>

        <li class="layui-nav-item layui-hide-xs" lay-unselect>
          <a href="javascript:;" layadmin-event="mynote">
            <i class="layui-icon layui-icon-note"></i>
          </a>
        </li>

        <li class="layui-nav-item layui-hide-xs" lay-unselect>
          <a href="javascript:;" layadmin-event="fullscreen">
            <i class="layui-icon layui-icon-screen-full"></i>
          </a>
        </li>
        <li class="layui-nav-item" lay-unselect>
          <a href="javascript:;">
            <img src="/layuiadmin/layui/images/head/xx.jpg" class="layui-nav-img">
            <cite>智途教育</cite>
          </a>
          <dl class="layui-nav-child">
            <dd><a lay-href="/login/personInfo.do">基本资料</a></dd>
            <dd><a lay-href="/layuiview/set/user/password.html">修改密码</a></dd>
            <hr>
            <dd style="text-align: center;"><a lay-href="<%=contextPath%>/login/loginOut.do">退出</a></dd>
          </dl>
        </li>

        <li class="layui-nav-item layui-hide-xs" lay-unselect>
          <a href="javascript:;" layadmin-event="about"><i class="layui-icon layui-icon-more-vertical"></i></a>
        </li>
        <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-unselect>
          <a href="javascript:;" layadmin-event="more"><i class="layui-icon layui-icon-more-vertical"></i></a>
        </li>
      </ul>
    </div>


    <!-- 侧边菜单 -->
    <div class="layui-side layui-side-menu">
      <div class="layui-side-scroll">
        <div class="layui-logo" lay-href="http://119.23.253.57/">
          <span style="font-size:19px" class="title_system_style">智途教育</span>
        </div>
        <ul class="layui-nav layui-nav-tree" lay-shrink="all" id="LAY-system-side-menu"
            lay-filter="layadmin-system-side-menu"></ul>
      </div>
    </div>

    <!-- 页面标签 -->
    <div class="layadmin-pagetabs" id="LAY_app_tabs">
      <div class="layui-icon layadmin-tabs-control layui-icon-prev" layadmin-event="leftPage"></div>
      <div class="layui-icon layadmin-tabs-control layui-icon-next" layadmin-event="rightPage"></div>
      <div class="layui-icon layadmin-tabs-control layui-icon-down">
        <ul class="layui-nav layadmin-tabs-select" lay-filter="layadmin-pagetabs-nav">
          <li class="layui-nav-item" lay-unselect>
            <a href="javascript:;"></a>
            <dl class="layui-nav-child layui-anim-fadein">
              <dd layadmin-event="closeThisTabs"><a href="javascript:;">关闭当前标签页</a></dd>
              <dd layadmin-event="closeOtherTabs"><a href="javascript:;">关闭其它标签页</a></dd>
              <dd layadmin-event="closeAllTabs"><a href="javascript:;">关闭全部标签页</a></dd>
            </dl>
          </li>
        </ul>
      </div>
      <div class="layui-tab" lay-unauto lay-allowClose="true" lay-filter="layadmin-layout-tabs">
        <ul class="layui-tab-title" id="LAY_app_tabsheader">
          <li lay-id="home/console.html" lay-attr="home/console.html" class="layui-this"><i
              class="layui-icon layui-icon-home"></i></li>
        </ul>
      </div>
    </div>


    <!-- 主体内容 -->
    <div class="layui-body" id="LAY_app_body">
      <div class="layadmin-tabsbody-item layui-show">
        <%--<iframe src="http://119.23.253.57/" frameborder="0" class="console"></iframe>--%>
        <iframe src="<%=contextPath%>/login/console.do" frameborder="0" class="console"></iframe>
        <%--<a href="<%=contextPath%>/login/console.do"/>--%>

      </div>
      <!-- 底部 -->
      <div class="layui-footer">
        <!-- 底部固定区域 -->
        © layui.com - 底部固定区域
      </div>
    </div>


    <!-- 辅助元素，一般用于移动设备下遮罩 -->
    <div class="layadmin-body-shade" layadmin-event="shade"></div>
  </div>
</div>

<script type="text/html" id="leftMenuTpl">
  {{#
  var dataName = layui.setter.response.dataName ? layui.setter.response.dataName : 'data';
  layui.each(d[dataName], function(index,item){
  }}
  <li data-name="{{ item.name || '' }}"
      class="layui-nav-item {{ item.spread ? typeof item.list === 'object' && item.list.length > 0 ? 'layui-nav-itemed' : 'layui-this': '' }}"
      myDir="1">
    {{# if(item.url){ }}
    <a lay-href="{{ item.url }}" lay-tips="{{ item.title }}" lay-direction="2">
      {{# }else{ }}
      <a href="javascript:;" lay-tips="{{ item.title }}" lay-direction="2">
        {{# } }}
        {{# if(item.icon){ }}
        <i class="layui-icon {{ item.icon }}"></i>
        {{# } }}
        <cite>{{ item.title }}</cite>
      </a>
      {{#
      var itemListFun = function(itemList, myDir){
      myDir = myDir || 2;
      if(typeof itemList === 'object' && itemList.length > 0){ }}
      <dl class="layui-nav-child">
        {{# layui.each(itemList, function(index2, item2){ }}
        <dd data-name="{{ item2.name || '' }}"
            class="{{ item2.spread ? (typeof item2.list === 'object' && item2.list.length > 0 ? 'layui-nav-itemed' : 'layui-this' ) : ''}}"
            myDir="{{ myDir }}">
          {{# if(item2.icon){ }}
          <i class="layui-icon {{ item.icon }}"></i>
          {{# } }}
          {{# if(item2.url){ }}
          <a lay-href="{{ item2.url }}">{{ item2.title }}</a>
          {{# }else{ }}
          <a href="javascript:;">{{ item2.title }}</a>
          {{# } }}
          {{# itemListFun(item2.list,myDir+1);}}
        </dd>
        {{# }) }}
      </dl>
      {{# } }}
      {{# };
      itemListFun(item.list); }}
  </li>
  {{# }) }}
</script>
<script src="/layuiadmin/layui/layui.js"></script>

<script>
  layui.config({
    base: '../layuiadmin/' //静态资源所在路径
  }).extend({
    index: 'lib/index' //主入口模块
  }).use(['index', 'common'], function () {//需要显式use common模块
    var $ = layui.$;
    var url = "<%=contextPath%>/permission/loadIndexTreeMenus.do";//这里是接口地址
    top.layui.admin.events.refreshLeftMenu(url);//如果在子页面想要刷新左侧菜单则使用top.layui.admin.events.refreshLeftMenu（前面加top.）
    // layui.admin.events.refreshLeftMenu(url,'home/homepage1.html');//第二个参数为默认打开的标签
  });
</script>


</body>
</html>

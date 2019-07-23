<%--
  Created by IntelliJ IDEA.
  User: liyqt
  Date: 2019/4/25
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String contextPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath(); %>

<html>
<head>
  <meta charset="utf-8">
  <title>文件上传</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
  <link rel="stylesheet" href="../../../layuiadmin/layui/css/layui.css" media="all">
  <link rel="stylesheet" href="../../../layuiadmin/style/admin.css" media="all">

  <link rel="stylesheet" href="../../../../../../bootstrap/css/bootstrap.min.css" crossorigin="anonymous">
  <link href="../../../../../../bootstrap/css/fileinput.css" media="all" rel="stylesheet" type="text/css"/>
  <link rel="stylesheet" href="../../../../../../fontawesome/css/all.css" crossorigin="anonymous">
  <link href="../../../../../../bootstrap/themes/explorer-fas/theme.css" media="all" rel="stylesheet" type="text/css"/>
  <script src="/jquery/jquery3.min.js" crossorigin="anonymous"></script>
  <script src="/nprogress/nprogress.js"></script>
  <!-- 如果你想在上传之前修改图片大小需要加入canvas-to-blob.min.js  它必须在fileinput.min.js之前引入 -->
  <script src="/kartik/js/canvas-to-blob.min.js" type="text/javascript"></script>
  <!-- 如果你想在HTML文件预览中净化HTML内容则要引入purify.min.js is   它必须在fileinput.min.js之前引入 -->
  <script src="/kartik/js/purify.min.js" type="text/javascript"></script>
  <script src="/bootstrap/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
  <script src="/kartik/js/piexif.js" type="text/javascript"></script>
  <script src="/kartik/js/sortable.js" type="text/javascript"></script>
  <script src="/kartik/js/fileinput.js" type="text/javascript"></script>
  <script src="/kartik/locales/zh.js" type="text/javascript"></script>
  <%--<script src="/kartik/locales/es.js" type="text/javascript"></script>--%>
  <script src="/bootstrap/themes/fas/theme.js" type="text/javascript"></script>
  <script src="/bootstrap/themes/explorer-fas/theme.js" type="text/javascript"></script>
</head>
<body>


<%--<form action="/file/queryFileData.do" method="post" enctype="multipart/form-data">--%>
<%--File:<input type="file" name="file">--%>
<%--Desc:<input type="text" name="desc">--%>
<%--<input type="submit" value="Submit">--%>
<%--</form>--%>

<div class="container my-4">
  <%--<h1>Bootstrap File Input Examples--%>
  <%--<small><a href="https://github.com/kartik-v/bootstrap-fileinput-samples"><i--%>
  <%--class="glyphicon glyphicon-download"></i> Download Sample Files</a></small>--%>
  <%--</h1>--%>
  <%--<hr>--%>
  <%--<h4>测试1</h4>--%>
  <%--<form enctype="multipart/form-data">--%>
  <%--<div class="file-loading">--%>
  <%--<input id="kv-explorer" name="fileLoad" class="file-loading" type="file" multiple data-show-upload="false"--%>
  <%--data-show-caption="true">--%>
  <%--</div>--%>
  <%--<button type="submit" class="btn btn-primary">提交</button>--%>
  <%--<button type="reset" class="btn btn-outline-secondary">重置</button>--%>
  <%--</form>--%>
  <%--<hr>--%>
  <form enctype="multipart/form-data">
    <div class="form-group">
      <div class="file-loading">
        <input id="kv-explorer" name="fileLoad" class="file-loading" type="file" multiple data-preview-file-type="any"
               data-theme="fas">
      </div>
    </div>
  </form>

</div>


<script type="text/javascript">

  $(document).ready(function () {

    $("#kv-explorer").fileinput({
      language: 'zh',
      uploadUrl: '<%=contextPath%>/file/queryFileData.do',
      uploadAsync: true,
      minFileCount: 1,    //最小上传文件数： 1
      maxFileCount: 10,
      msgFilesTooMany: "一次最多上传10个文件！",
      // allowedFileExtensions:['mp4'],
      preferIconicPreview: true, // 开启用图标替换预览效果
      previewFileIconSettings: { // configure your icon file extensions
        'doc': '<i class="fa fa-file-word text-primary"></i>',
        'xls': '<i class="fa fa-file-excel text-success"></i>',
        'ppt': '<i class="fa fa-file-powerpoint text-danger"></i>',
        'pdf': '<i class="fa fa-file-pdf text-danger"></i>',
        'txt': '<i class="fa fa-file text-info"></i>',
        'zip': '<i class="fa fa-file-archive text-muted"></i>',
        'htm': '<i class="fa fa-file-code text-info"></i>',
        'mov': '<i class="fa fa-file-video text-warning"></i>',
        'mp3': '<i class="fa fa-file-audio text-warning"></i>',
      },
      previewFileExtSettings: {
        'doc': function (ext) {
          return ext.match(/(doc|docx)$/i);
        },
        'xls': function (ext) {
          return ext.match(/(xls|xlsx)$/i);
        },
        'ppt': function (ext) {
          return ext.match(/(ppt|pptx)$/i);
        },
        'zip': function (ext) {
          return ext.match(/(zip|rar|tar|gzip|gz|7z)$/i);
        },
        'htm': function (ext) {
          return ext.match(/(htm|html)$/i);
        },
        'mov': function (ext) {
          return ext.match(/(avi|mpg|mkv|mov|mp4|3gp|webm|wmv)$/i);
        },
        'mp3': function (ext) {
          return ext.match(/(mp3|wav)$/i);
        },
        'txt': function (ext) {
          return ext.match(/(txt|ini|csv|java|php|js|css)$/i);
        }
      },
    }).on("fileuploaded", function (e, data) {
      var res = data.response;
      alert(res.msg);
      // $("#logo").attr("value", res.success);
    });


  });
</script>

</body>
</html>

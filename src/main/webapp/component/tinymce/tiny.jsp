<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/25
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <script src="/tinymce/tinymce.js"></script>
  <script src="/tinymce/themes/silver/theme.js"></script>
  <script src="/tinymce/plugins/advlist/plugin.min.js"></script>
  <script src="/tinymce/plugins/anchor/plugin.min.js"></script>
  <script src="/tinymce/plugins/autolink/plugin.min.js"></script>
  <script src="/tinymce/plugins/autoresize/plugin.min.js"></script>
  <script src="/tinymce/plugins/autosave/plugin.min.js"></script>
  <script src="/tinymce/plugins/bbcode/plugin.min.js"></script>
  <script src="/tinymce/plugins/charmap/plugin.min.js"></script>
  <script src="/tinymce/plugins/code/plugin.min.js"></script>
  <script src="/tinymce/plugins/codesample/plugin.min.js"></script>
  <script src="/tinymce/plugins/colorpicker/plugin.min.js"></script>
  <script src="/tinymce/plugins/contextmenu/plugin.min.js"></script>
  <script src="/tinymce/plugins/directionality/plugin.min.js"></script>
  <script src="/tinymce/plugins/emoticons/plugin.min.js"></script>
  <script src="/tinymce/plugins/fullpage/plugin.min.js"></script>
  <script src="/tinymce/plugins/fullscreen/plugin.min.js"></script>
  <script src="/tinymce/plugins/help/plugin.min.js"></script>
  <script src="/tinymce/plugins/hr/plugin.min.js"></script>
  <script src="/tinymce/plugins/image/plugin.min.js"></script>
  <script src="/tinymce/plugins/imagetools/plugin.min.js"></script>
  <script src="/tinymce/plugins/importcss/plugin.min.js"></script>
  <script src="/tinymce/plugins/insertdatetime/plugin.min.js"></script>
  <script src="/tinymce/plugins/legacyoutput/plugin.min.js"></script>
  <script src="/tinymce/plugins/link/plugin.min.js"></script>
  <script src="/tinymce/plugins/lists/plugin.min.js"></script>
  <script src="/tinymce/plugins/media/plugin.min.js"></script>
  <script src="/tinymce/plugins/nonbreaking/plugin.min.js"></script>
  <script src="/tinymce/plugins/noneditable/plugin.min.js"></script>
  <script src="/tinymce/plugins/pagebreak/plugin.min.js"></script>
  <script src="/tinymce/plugins/paste/plugin.min.js"></script>
  <script src="/tinymce/plugins/preview/plugin.min.js"></script>
  <script src="/tinymce/plugins/print/plugin.min.js"></script>
  <script src="/tinymce/plugins/quickbars/plugin.min.js"></script>
  <script src="/tinymce/plugins/save/plugin.min.js"></script>
  <script src="/tinymce/plugins/searchreplace/plugin.min.js"></script>
  <script src="/tinymce/plugins/spellchecker/plugin.min.js"></script>
  <script src="/tinymce/plugins/tabfocus/plugin.min.js"></script>
  <script src="/tinymce/plugins/table/plugin.min.js"></script>
  <script src="/tinymce/plugins/template/plugin.min.js"></script>
  <script src="/tinymce/plugins/textcolor/plugin.min.js"></script>
  <script src="/tinymce/plugins/textpattern/plugin.min.js"></script>
  <script src="/tinymce/plugins/toc/plugin.min.js"></script>
  <script src="/tinymce/plugins/visualblocks/plugin.min.js"></script>
  <script src="/tinymce/plugins/visualchars/plugin.min.js"></script>
  <script src="/tinymce/plugins/wordcount/plugin.min.js"></script>

  <script>
    tinymce.init({
      selector: 'textarea#tyh',
      language: 'zh_CN',
      skin: 'oxide-dark',
      font_formats: '宋体=宋体;' +
          '黑体=黑体;' +
          '微软雅黑=微软雅黑;' +
          'Andale Mono=andale mono,times;' +
          ' Arial=arial,helvetica,sans-serif;' +
          ' Arial Black=arial black,avant garde;' +
          ' Book Antiqua=book antiqua,palatino;' +
          ' Comic Sans MS=comic sans ms,sans-serif;' +
          ' Courier New=courier new,courier;' +
          ' Georgia=georgia,palatino; Helvetica=helvetica;' +
          ' Impact=impact,chicago; Symbol=symbol;' +
          ' Tahoma=tahoma,arial,helvetica,sans-serif;' +
          ' Terminal=terminal,monaco;' +
          ' Times New Roman=times new roman,times;' +
          ' Trebuchet MS=trebuchet ms,geneva;' +
          ' Verdana=verdana,geneva;' +
          ' Webdings=webdings;' +
          ' Wingdings=wingdings,zapf dingbats',
      plugins: 'advlist anchor autolink autoresize autosave bbcode charmap code codesample directionality emoticons fullpage ' +
          'fullscreen help hr image imagetools importcss insertdatetime legacyoutput link lists media nonbreaking noneditable pagebreak paste ' +
          'paste preview print quickbars save searchreplace spellchecker tabfocus table template textpattern toc visualblocks visualchars wordcount',
      content_css: '../../../../../tinymce/skins/content/default/content.min.css',
      toolbar: 'insertfile undo redo | formatselect | fontselect  | fontsizeselect |forecolor backcolor | bold italic underline strikethrough | fullscreen| ' +
          'print preview emoticons|bullist numlist | link unlink | uploadimg image media |alignleft aligncenter alignright alignjustify | outdent indent | removeformat|insertdatetime',
    });

    function custum_fontfamily($initArray) {
      $initArray['font_formats'] = "微软雅黑='微软雅黑';宋体='宋体';黑体='黑体';仿宋='仿宋';楷体='楷体';隶书='隶书';幼圆='幼圆';Andale Mono=andale mono,times;Arial=arial,helvetica,sans-serif;Arial Black=arial black,avant garde;Book Antiqua=book antiqua,palatino;Comic Sans MS=comic sans ms,sans-serif;Courier New=courier new,courier;Georgia=georgia,palatino;Helvetica=helvetica;Impact=impact,chicago;Symbol=symbol;Tahoma=tahoma,arial,helvetica,sans-serif;Terminal=terminal,monaco;Times New Roman=times new roman,times;Trebuchet MS=trebuchet ms,geneva;Verdana=verdana,geneva;Webdings=webdings;Wingdings=wingdings";
      return $initArray;
    }

    add_filter('tiny_mce_before_init', 'custum_fontfamily');
  </script>
</head>
<body>
<form method="post">
  <textarea id="tyh">你好，世界!</textarea>
</form>
</body>
</html>

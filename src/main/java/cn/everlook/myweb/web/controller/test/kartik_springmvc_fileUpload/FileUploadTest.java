package cn.everlook.myweb.web.controller.test.kartik_springmvc_fileUpload;

import cn.everlook.myweb.commons.common.SystemConfig;
import cn.everlook.myweb.commons.common.ZtFileUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 此处填写说明
 *
 * @author liyqt
 * @createDate 2019/4/25
 */
@Controller
@RequestMapping("/file")
public class FileUploadTest {

//  private String uploadDir;
  
  //@Value表示去beans.xml文件中找id="prop"的bean，它是通过注解的方式读取properties
  // 配置文件的，然后去相应的配置文件中读取key=uploadDir的对应的value值
//  @Value("#{prop.uploadDir}")
//  public void setUploadDir(String uploadDir) {
//    System.out.println("uploadDir+++++++++++++" + uploadDir);
//    this.uploadDir = uploadDir;
//  }
  
  /**
   * 跳转到文件上传页面界面
   */
  @RequestMapping("/tofileUpload.do")
  public String tofileUpload() {
    return "/common/file/fileUpload";
  }
  
  /**
   * 测试文件上传
   */
  @RequestMapping("/testFileUpload.do")
  public String testFileUpload(@RequestParam("desc") String desc, @RequestParam("file") MultipartFile file) {
    System.out.println("desc" + desc);
    System.out.println("getOriginalFilename" + file.getOriginalFilename());
    return "common/file/success";
  }
  
  @RequestMapping("/fileUpload.do")
  @ResponseBody
  public String fileUpload(@RequestParam("file") MultipartFile multipartFile, @RequestParam("desc") String desc, HttpServletRequest request, Model model) {
    System.out.println("getOriginalFilename+" + multipartFile.getOriginalFilename());
    if (multipartFile != null) {
      //设置文件的保存路径
      //filepath= Utils.format(filepath);SystemConfig.get("sys.upload.dir")
//      String filePath = request.getSession().getServletContext().getRealPath("/") + uploadDir + "/" + multipartFile.getOriginalFilename();
      String filePath = request.getSession().getServletContext().getRealPath("/") + SystemConfig.get("sys.upload.dir") + "/" + multipartFile.getOriginalFilename();
      File files = new File(filePath);
      System.out.println("打印文件保存位置：" + filePath);
      //转存文件
      try {
        multipartFile.transferTo(new File(filePath));
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return "common/file/success";
  }
  
  
  //单文件上传
  @RequestMapping(value = "/queryFileData.do")
  @ResponseBody
  public Map<String, Object> queryFileData(@RequestParam("fileLoad") CommonsMultipartFile file, HttpServletRequest request) {
    // MultipartFile是对当前上传的文件的封装，当要同时上传多个文件时，可以给定多个MultipartFile参数(数组)
    Map<String, Object> json = new HashMap<>();
    if (!file.isEmpty()) {
      String type = ZtFileUtils.getFileType(file.getOriginalFilename());
      String filename = System.currentTimeMillis() + type;// 取当前时间戳作为文件名
      String path = SystemConfig.get("sys.upload.dir") + ZtFileUtils.genDateRelaPath(null) + filename;// 存放位置
      File destFile = new File(path);
      try {
        // FileUtils.copyInputStreamToFile()这个方法里对IO进行了自动操作，不需要额外的再去关闭IO流
        FileUtils.copyInputStreamToFile(file.getInputStream(), destFile);// 复制临时文件到指定目录下
      } catch (IOException e) {
        e.printStackTrace();
      }
      json.put("msg", path);
      return json;
    } else {
      json.put("message", "图片上传失败");
      json.put("status", false);
      return json;
    }
  }
  
}

package com.leon.controller;

import com.leon.entity.User;
import com.leon.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Logger;

/**
 * Author: jianliangzhang
 * Date: 2017/12/13
 * Time: 16:41
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger log = Logger.getLogger(UserController.class.getName());
    @Resource
    private UserService userService;

    private static String UPLOADED_FOLDER = "";

    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    @ResponseBody
    public List<User> showUser(HttpServletRequest request, Model model) {

        return userService.selectAll();
    }

    @RequestMapping(value = "/demoGet", method = RequestMethod.GET)
    @ResponseBody
    public User demoGet(HttpServletRequest request, Model model) {
        User user = new User();
        user.setId(1);
        user.setName("leon");
        user.setPassword("123123");
        return user;
    }

    /**
     * 上传头像  @RequestParam("uuid")String uuid
     */
    @ResponseBody
    @RequestMapping(value = "/uploadAvatar", method = RequestMethod.POST)
    public void uploadAvatar(HttpServletRequest request) {
        // 获取路径
        if(UPLOADED_FOLDER.isEmpty()) UPLOADED_FOLDER = request.getServletContext().getRealPath("tmp");

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        // 获得文件：
        MultipartFile file = multipartRequest.getFile("file");
        //创建目录
        File dir = new File(UPLOADED_FOLDER);
        if(!dir.exists()) dir.mkdir();
        File fl = new File(UPLOADED_FOLDER, file.getOriginalFilename());
        InputStream input;
        try {
            input = file.getInputStream();
            OutputStream out = new FileOutputStream(fl);
            int length = 0;
            byte[] buf = new byte[1024];
            System.out.println("获取文件总量的容量:" + file.getSize());
            while ((length = input.read(buf)) != -1) {
                out.write(buf, 0, length);
            }
            input.close();
            out.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
//            log.error("上传头像失败", e);
        }
    }

}
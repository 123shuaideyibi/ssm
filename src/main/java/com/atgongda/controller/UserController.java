package com.atgongda.controller;

import com.atgongda.entity.User;
import com.atgongda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.modelmbean.ModelMBeanOperationInfo;
import javax.servlet.http.HttpServletRequest;

/**
 * @author sushuai
 * @date 2019/03/04/6:09
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, Model model){
        System.out.println(username+password);
        User user = userService.selectUserByUserName(username);
        if (user != null){
            if (user.getPassword().equals(password)){
                System.out.println("登录成功");
                return "success";
            }else {
                System.out.println("密码错误");
                return "error";
            }
        }else {
            System.out.println("用名不存在");
            return "error";
        }
    }

    @RequestMapping(value = "/login")
    public String login(@ModelAttribute User user){
        System.out.println("start......");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "msg";
    }


}

package com.atgongda.controller;

import com.atgongda.entity.User;
import com.atgongda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author sushuai
 * @date 2019/03/04/6:09
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 登录的控制层
     *
     * @param username
     * @param password
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletRequest request, Model model) {
        User user = userService.selectUserByUserName(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                System.out.println("登录成功");
                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                model.addAttribute("state","登录成功");
                return "loginSuccess";
            } else {
                System.out.println("用户名或密码错误");
                model.addAttribute("failure", "用户名或密码错误！");
                return "loginError";
            }
        } else {
            System.out.println("用名不存在");
            model.addAttribute("state", "failure");
            model.addAttribute("message", "该用户不存在");
            return "loginError";
        }
    }



    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestParam("username") String username, @RequestParam("password") String password,HttpServletRequest request, Model model) {
        System.out.println("输入的信息"+username+password);
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        boolean flag = userService.insertUser(user);
        System.out.println(flag);
        return "registerSuccess";
    }

}

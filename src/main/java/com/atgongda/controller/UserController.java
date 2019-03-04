package com.atgongda.controller;

import com.atgongda.entity.User;
import com.atgongda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author sushuai
 * @date 2019/03/04/6:09
 */
@Controller
@RequestMapping("/user")
public class UserController {

//    @Autowired
//    private UserService userService;


    @RequestMapping(value = "/login")
    public String login(@ModelAttribute User user){
        System.out.println("start......");
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "msg";
    }


}

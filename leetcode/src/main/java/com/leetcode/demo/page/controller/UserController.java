package com.leetcode.demo.page.controller;

import com.leetcode.demo.page.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/UserController")
public class UserController {
    @Autowired
    private UserServiceImpl UserService;

    @RequestMapping("/add")
    @ResponseBody
    public void addUser(String id,String username,String password,String email){
        UserService.addUserAll(id,username,password,email);
    }
}

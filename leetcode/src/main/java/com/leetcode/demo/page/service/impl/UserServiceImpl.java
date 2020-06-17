package com.leetcode.demo.page.service.impl;

import com.leetcode.demo.page.dao.datasources2.UsersMapper;
import com.leetcode.demo.page.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void addUserAll(String id, String username, String password, String email) {
        usersMapper.addUserAll(id,username,password,email);
    }
}

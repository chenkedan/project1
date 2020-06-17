package com.leetcode.demo.page.dao.datasources1;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {

    public void addUserAll(@Param("id") String id, @Param("username")String username, @Param("password")String password, @Param("email")String email);
}

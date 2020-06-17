package com.leetcode.demo.page.dao.datasources2;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface UsersMapper {

    public void addUserAll(@Param("id") String id, @Param("username") String username, @Param("password") String password, @Param("email") String email);
}

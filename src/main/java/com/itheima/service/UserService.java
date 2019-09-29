package com.itheima.service;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserService {
    public User findOne(String name, String password);
}

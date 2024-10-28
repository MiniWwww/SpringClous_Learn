package com.yili.userservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yili.model.entity.Users;

public interface UserService extends IService<Users> {

    Users login(String loginName, String password);

    boolean register(Users user);
}

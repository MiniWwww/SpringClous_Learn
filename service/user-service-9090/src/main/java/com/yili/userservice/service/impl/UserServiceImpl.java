package com.yili.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yili.model.entity.Users;
import com.yili.userservice.mapper.UserMapper;
import com.yili.userservice.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, Users> implements UserService {

    @Resource
    UserMapper userMapper;
    @Override
    public Users login(String loginName, String password) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", loginName).eq("password", password);
        return userMapper.selectOne(wrapper);
    }

    @Override
    public boolean register(Users user) {
        // 检查用户名是否已存在
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username", user.getUsername());
        int count = userMapper.selectCount(wrapper);
        if (count > 0) {
            return false; // 用户名已存在，注册失败
        }
        user.setRole("普通用户");
        // 执行用户注册逻辑
        int rows = userMapper.insert(user);
        return rows > 0; // 返回插入操作的结果
    }
}

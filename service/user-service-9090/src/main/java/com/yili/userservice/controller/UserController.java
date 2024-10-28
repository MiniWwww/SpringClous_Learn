package com.yili.userservice.controller;

import com.yili.common.result.Result;
import com.yili.model.entity.Users;
import com.yili.model.vo.LoginForm;
import com.yili.userservice.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserService userService;

    /**
     * 用户登录接口
     * @param loginForm 登录表单
     * @return 返回用户登录结果的 Result 对象
     */
    @PostMapping("/login")
    public Result<Users> login(@RequestBody LoginForm loginForm) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        Users user = userService.login(username, password);
        if (user != null) {
            return Result.ok("登录成功",user);
        }
        return Result.fail("用户名或密码错误");
    }

    /**
     * 用户注册接口
     * @param user 注册用户信息
     * @return 返回操作结果的 Result 对象
     */
    @PostMapping("/register")
    public Result<String> registerUser(@RequestBody Users user) {
        boolean success = userService.register(user);
        if (success) {
            return Result.ok("注册成功");
        }
        return Result.fail("注册失败");
    }

    /**
     * 添加用户接口
     * @param user 新用户信息
     * @return 返回操作结果的 Result 对象
     */
    @PostMapping("/add")
    public Result<Users> addUser(@RequestBody Users user) {
        boolean success = userService.save(user);
        if (success) {
            Users addedUser = userService.getById(user.getId());
            return Result.ok("用户添加成功", addedUser);
        } else {
            return Result.fail("用户添加失败");
        }
    }


    /**
     * 获取用户列表接口
     * @return 返回包含用户列表的 Result 对象
     */
    @GetMapping("/list")
    public Result<List<Users>> getUserList() {
        List<Users> userList = userService.list();
        return Result.ok(userList);
    }

    /**
     * 根据ID删除用户接口
     * @param id 用户ID
     * @return 返回操作结果的 Result 对象
     */
    @DeleteMapping("/{id}")
    public Result<String> deleteUserById(@PathVariable Integer id) {
        if (userService.removeById(id)) {
            return Result.ok("删除成功");
        }
        return Result.fail("删除失败");
    }

    /**
     * 根据ID获取用户信息接口
     * @param id 用户ID
     * @return 返回包含用户信息的 Result 对象
     */
    @GetMapping("/{id}")
    public Result<Users> getUserById(@PathVariable Integer id) {
        Users user = userService.getById(id);
        return Result.ok(user);
    }

    /**
     * 更新用户接口
     * @param user 用户信息
     * @return 返回操作结果的 Result 对象
     */
    @PutMapping("/update")
    public Result<String> updateUser(@RequestBody Users user) {
        boolean success = userService.updateById(user);
        if (success) {
            return Result.ok("更新成功");
        }
        return Result.fail("更新失败");
    }

}
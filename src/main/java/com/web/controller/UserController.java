package com.web.controller;


import com.web.domain.User;
import com.web.domain.UserLogin;
import com.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Result save(@RequestBody User user) {
        boolean flag = userService.save(user);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, null, null);
    }

    @PostMapping("/updateName/{id}/{name}")
    public Result updateName(@PathVariable Integer id, @PathVariable String name) {
        boolean flag = userService.updateName(id, name);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, null, null);
    }

    @PostMapping("/updatePwd")
    public Result updatePwd(@RequestBody User user) {
        boolean flag = userService.updatePwd(user.getId(),user.getPwd());
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, null, null);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = userService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, null, null);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        User user = userService.getById(id);
        Integer code = user != null ? Code.GET_OK : Code.GET_ERR;
        String msg = user != null ? "" : "数据查询失败,请重试!";
        return new Result(code, user, msg);
    }

    @GetMapping
    public Result getAll() {
        List<User> userList = userService.getAll();
        boolean flag = userList == null || userList.isEmpty();
        Integer code = flag ? Code.GET_ERR : Code.GET_OK;
        String msg = flag ? "数据查询失败,请重试!" : "";
        return new Result(code, userList, msg);
    }


    @PostMapping("/login")
    public Result login(@RequestBody UserLogin userLogin) {
        String UserPwd = userService.login(userLogin.getName(), userLogin.getPwd());
        boolean flag = UserPwd.equals(userLogin.getPwd()) ? true : false;
        String msg = flag ? "登录成功" : "用户名或密码错误";
        return new Result(flag ? Code.LOGIN_OK : Code.LOGIN_ERR, null, msg);
    }


}

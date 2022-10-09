package com.jxd.order.controller;

import com.jxd.order.model.User;
import com.jxd.order.service.IUserService;
import com.jxd.order.vo.EmpUserDeptVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author hujiaoxiang
 * @Date 2022/9/24
 * @Version 1.0
 */
@RestController
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public Map<String, Object> login(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        Map<String, Object> map = new HashMap<>();
        EmpUserDeptVO login = userService.login(username, password);
        if (login != null) {
            map.put("msg", "success");
            map.put("data", login);
        } else {
            map.put("msg", "fail");
        }
        return map;
    }

    @RequestMapping("/register")
    public String register(@RequestBody User user) {
        if (userService.register(user)) {
            return "success";
        } else {
            return "fail";
        }
    }
}

package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("{}", emp);

        Emp emp1 = empService.login(emp);
        if (emp1 != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", emp1.getId());
            claims.put("username", emp1.getUsername());
            claims.put("name", emp1.getName());

            String jwt = JwtUtils.generateJWT(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或者密码错误");
        // return emp1 != null ? Result.success() : Result.error("用户名或者密码错误");
    }
}

package com.itheima.controller;

import com.itheima.projo.Address;
import com.itheima.projo.User;
import com.itheima.resp.Result;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

@RestController
@RequestMapping("/users")
public class RequestController {

    @GetMapping("/01")
    public String simpleParam1(HttpServletRequest request) {
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");
        int age = Integer.parseInt(ageStr);
        System.out.println(name + ":" + age);
        return name + "-" + ageStr;
    }

    @GetMapping("/02")
    public String simpleParam2(String name, Integer age){
        return name + ":" + age;
    }

    @GetMapping("/03")
    public String simpleParam3(User user){
        System.out.println(user);
        return "";
    }

    @GetMapping("/04")
    public String simpleParam4(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "OK";
    }

    @GetMapping("/05")
    public String simpleParam5(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "OK";
    }

    @GetMapping("/06")
    public String simpleParam6(@RequestBody User user){
        System.out.println(user);
        return "OK";
    }

    @GetMapping("/07/{num}")
    public Integer simpleParam7(@PathVariable Integer num){
        System.out.println(num);
        return num;
    }

    @GetMapping("/08")
    public User simpleParam8(){
        User user = new User();
        user.setName("张三");
        user.setAge(18);
        Address address = new Address();
        address.setProvince("浙江省");
        address.setCity("杭州市");
        user.setAddress(address);
        return user;
    }

    @GetMapping("/09")
    public Result simpleParam9() {
//        User user = new User();
//        user.setName("张三");
//        user.setAge(18);
//        Address address = new Address();
//        address.setProvince("浙江省");
//        address.setCity("杭州市");
//        user.setAddress(address);
        return Result.getReturn();
    }
}

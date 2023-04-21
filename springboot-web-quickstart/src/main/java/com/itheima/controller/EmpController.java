package com.itheima.controller;

import com.itheima.projo.Emp;
import com.itheima.resp.Result;
import com.itheima.service.EmpService;
import com.itheima.service.impl.EmpServiceLoop;
import com.itheima.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmpController {

    // private EmpService empService = new EmpServiceLoop();

    @Autowired // 运行时, IOC容器会提供该类型的 bean对象,并赋值给改变量, 也称之为: 依赖注入
    private EmpService empService;
    @GetMapping
    public Result emp() {
        List<Emp> empList = empService.listEmp();
        return Result.getReturn(empList);
    }
}

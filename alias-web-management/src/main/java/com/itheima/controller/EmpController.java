package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping
    public Result list() {
        List<Emp> empList = empService.list();
        return Result.success(empList);
    }

    @GetMapping("/page")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        PageBean pageBean = empService.page((page-1)*pageSize, pageSize);
        return Result.success(pageBean);
    }

    @GetMapping("/page2")
    public Result page2(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pageSize) {
        PageBean pageBean = empService.page2(page, pageSize);
        return Result.success(pageBean);
    }

    @GetMapping("/page3")
    public Result page3(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        String name, Short gender,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                        @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end
                        )
    {
        PageBean pageBean = empService.page3(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @GetMapping("/page4")
    public Result page4(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer pageSize,
                        String name, Short gender,
                        @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                        @DateTimeFormat(pattern = "yyyy-MM-dd")LocalDate end){
        PageBean pageBean = empService.page4(page, pageSize, name, gender, begin, end);
        return Result.success(pageBean);
    }

    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("ids: {}", ids);
        Integer res = empService.delete(ids);
        return Result.success(res);
    }

    @PostMapping
    public Result create(@RequestBody Emp emp) {
        log.info("{}", emp);
        Emp emp1 = empService.create(emp);
        return Result.success(emp1);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Emp emp = empService.getById(id);
        return Result.success(emp);
    }

    @PutMapping
    public Result update(@RequestBody Emp emp) {
        Emp emp1 = empService.update(emp);
        return Result.success(emp1);
    }
}

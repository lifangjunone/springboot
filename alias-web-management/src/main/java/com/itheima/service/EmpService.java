package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    List<Emp> list();

    PageBean page(Integer page, Integer pageSize);

    PageBean page2(Integer page, Integer pageSize);

    PageBean page3(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    PageBean page4(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    Integer delete(List<Integer> ids);

    Emp create(Emp emp);
}

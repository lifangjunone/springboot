package com.itheima.service;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;

import java.util.List;

public interface EmpService {

    List<Emp> list();

    PageBean page(Integer page, Integer pageSize);
}

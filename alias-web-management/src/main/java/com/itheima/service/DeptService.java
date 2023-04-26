package com.itheima.service;

import com.itheima.pojo.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> list();

    Dept get(Integer id);

    Boolean delete(Integer id);

    Dept create(Dept dept);
}

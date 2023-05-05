package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    public List<Emp> list() {
        return empMapper.list();
    }

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        List<Emp> empList = empMapper.page(page, pageSize);
        Long count = empMapper.count();
        PageBean pageBean = new PageBean();
        pageBean.setTotal(count);
        pageBean.setRows(empList);
        return pageBean;
    }

    @Override
    public PageBean page2(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.page2();
        Page<Emp> p = (Page<Emp>) empList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public PageBean page3(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.page3(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public PageBean page4(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        PageHelper.startPage(page, pageSize);
        List<Emp> empList = empMapper.page4(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;
    }

    @Override
    public Integer delete(List<Integer> ids){
        return empMapper.delete(ids);
    }

    @Override
    public Emp create(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        if (null == emp.getPassword()) {
            emp.setPassword("123456");
        } else if (Objects.equals(emp.getPassword(), "")) {
            emp.setPassword("123456");
        }
        empMapper.create(emp);
        return emp;
    }

    @Override
    public Emp getById(Integer id) {
        Emp emp = empMapper.getById(id);
        return emp;
    }

    @Override
    public Emp update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
        Emp emp1 = empMapper.getById(emp.getId());
        return emp1;
    }

    @Override
    public Emp login(Emp emp) {
        Emp emp1 = empMapper.getByUsernameAndPassword(emp);
        return emp1;
    }
}

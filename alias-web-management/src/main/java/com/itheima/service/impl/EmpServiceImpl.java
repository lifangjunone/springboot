package com.itheima.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}

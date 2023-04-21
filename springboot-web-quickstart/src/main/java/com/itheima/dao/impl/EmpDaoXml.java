package com.itheima.dao.impl;

import com.itheima.dao.EmpDao;
import com.itheima.projo.Emp;
import com.itheima.utils.XmlParserUtils;

import java.util.List;

public class EmpDaoXml implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> emplist = XmlParserUtils.parse(file, Emp.class);
        return emplist;
    }
}

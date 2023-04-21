package com.itheima.dao.impl;

import com.itheima.dao.EmpDao;
import com.itheima.projo.Emp;
import com.itheima.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Component  // 将当前类交给IOC容器管理,成为IOC容器中的bean
@Repository
public class EmpDaoXml implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> emplist = XmlParserUtils.parse(file, Emp.class);
        return emplist;
    }
}

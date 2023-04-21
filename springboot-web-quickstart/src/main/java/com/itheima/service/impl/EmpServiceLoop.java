package com.itheima.service.impl;

import com.itheima.dao.EmpDao;
import com.itheima.dao.impl.EmpDaoXml;
import com.itheima.projo.Emp;
import com.itheima.service.EmpService;

import java.util.List;

public class EmpServiceLoop implements EmpService {
    private EmpDao empDao = new EmpDaoXml();
    @Override
    public List<Emp> listEmp() {
        List<Emp> empList = empDao.listEmp();
        empList.stream().forEach(emp -> {
            String gender = emp.getGender();
            if ("1".equals(gender)){
                emp.setGender("男");
            }else if ("2".equals(gender)){
                emp.setGender("女");
            }

            String job = emp.getJob();
            if ("1".equals(job)){
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else if ("3".equals(job)) {
                emp.setJob("就业指导");
            }
        });
        return empList;
    }
}

package com.itheima.service.impl;

import com.itheima.mapper.ActionLogMapper;
import com.itheima.mapper.DeptMapper;
import com.itheima.mapper.EmpMapper;
import com.itheima.pojo.ActionLog;
import com.itheima.pojo.Dept;
import com.itheima.service.ActionLogService;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private ActionLogService actionLogService;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Override
    public Dept get(Integer id) {
        return deptMapper.get(id);
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED) // springboot 事物使用，　此注解可以加到类上，　方法上
    @Override
    public Boolean delete(Integer id) {
        Exception ex = new Exception();
        try {
            deptMapper.delete(id);
            empMapper.deleteByDeptId(id);
        } catch (Exception e) {
            ex = e;
        } finally {
            ActionLog actionLog = new ActionLog();
            actionLog.setMsg("部门id:" + id  + "失败原因：" + ex.toString());
            actionLog.setCreateTime(LocalDateTime.now());
            actionLogService.insertLog(actionLog);
            System.out.println("记录日志到日志表中");
        }
        return true;
    }

    @Override
    public Dept create(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        try {
            deptMapper.create(dept);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return dept;
    }
}

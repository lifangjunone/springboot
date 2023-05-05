package com.itheima.service.impl;

import com.itheima.mapper.ActionLogMapper;
import com.itheima.pojo.ActionLog;
import com.itheima.service.ActionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActionLogServiceImpl implements ActionLogService {

    @Autowired
    private ActionLogMapper actionLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insertLog(ActionLog actionLog) {
        actionLogMapper.insertLog(actionLog);
    }
}

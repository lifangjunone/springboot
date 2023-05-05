package com.itheima.mapper;

import com.itheima.pojo.ActionLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ActionLogMapper {

    @Insert("insert into action_log(msg, create_time) values (#{msg}, #{createTime})")
    public void insertLog(ActionLog actionLog);
}

package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp")
    List<Emp> list();

    @Select("select count(*) from emp")
    Long count();

    @Select("select * from emp limit #{page}, #{pageSize}")
    List<Emp> page(Integer page, Integer pageSize);
}

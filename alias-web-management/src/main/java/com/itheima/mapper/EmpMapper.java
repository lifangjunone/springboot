package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp")
    List<Emp> list();

    @Select("select count(*) from emp")
    Long count();

    @Select("select * from emp limit #{page}, #{pageSize}")
    List<Emp> page(Integer page, Integer pageSize);

    @Select("select * from emp")
    List<Emp> page2();

    @Select("select * from emp where name like concat('%', #{name}, '%') and gender=#{gender} and" +
            " update_time between #{begin} and #{end}")
    List<Emp> page3(String name, Short gender, LocalDate begin, LocalDate end);

    List<Emp> page4(String name, Short gender, LocalDate begin, LocalDate end);

    Integer delete(List<Integer> ids);

    Integer create(Emp emp);

    @Select("select * from emp where id=#{id}")
    Emp getById(Integer id);

    Integer update(Emp emp);
}

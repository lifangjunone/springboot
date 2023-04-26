package com.itheima.mapper;

import com.itheima.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    @Select("select id, name, create_time, update_time from dept")
    List<Dept> list();

    @Select("select id, name, create_time, update_time from dept where id=#{id}")
    Dept get(Integer id);

    @Delete("delete from dept where id=#{id}")
    Boolean delete(Integer id);


    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    @Insert("insert into dept values (null, #{name}, #{createTime}, #{updateTime})")
    void create(Dept dept);
}

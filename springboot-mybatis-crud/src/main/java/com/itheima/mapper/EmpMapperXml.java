package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapperXml {
    // 通过条件查询
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
    public void update(Emp emp);
    public void deleteIds(List<Integer> ids);
}














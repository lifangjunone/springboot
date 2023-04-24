package com.itheima.mapper;

import com.itheima.projo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //　运行时，自动生成该接口的实现类对象，　并且将该对象交给 IOC 容器管理
public interface UserMapper {

    @Select("select * from user")
    public List<User> list();
}

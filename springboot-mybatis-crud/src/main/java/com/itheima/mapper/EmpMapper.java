package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

//@Mapper
public interface EmpMapper {
    // 根据id删除员工
    @Delete("delete from emp where id = #{id}")
    public void delete(Integer id);

    // 新增员工
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            " values (#{username}, #{name}, #{gender}, #{image}, #{job}, " +
            "#{entryDate}, #{deptId}, #{createTime}, #{updateTime})")
    public void insert(Emp emp);

    // 更新员工
    @Update("update emp set username=#{username}, name=#{name}, gender=#{gender}, image=#{image}, job=#{job}, " +
            "entrydate=#{entryDate}, dept_id=#{deptId}, update_time=#{updateTime} where id=#{id}")
    public void update(Emp emp);

    // 通过ID查询
    @Select("select * from emp where id = #{id}")
    public Emp getById(Integer id);

    // 通过条件查询
    @Select("select * from emp where name like concat('%', #{name}, '%') and gender = #{gender} and entrydate" +
            " between #{begin} and #{end} order by update_time desc")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);
}














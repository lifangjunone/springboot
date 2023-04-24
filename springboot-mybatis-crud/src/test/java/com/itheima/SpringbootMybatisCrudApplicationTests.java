package com.itheima;

import com.itheima.mapper.EmpMapper;
import com.itheima.mapper.EmpMapperXml;
import com.itheima.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {


//	@Autowired
//	private EmpMapper empMapper;

	@Autowired
	private EmpMapperXml empMapperXml;

//	@Test
//	public void testDelete() {
//		empMapper.delete(17);
//	}
//
//	@Test
//	public void testInsert() {
//		Emp emp = new Emp();
//		emp.setUsername("liritian2");
//		emp.setName("牛逼");
//		emp.setImage("2.png");
//		emp.setGender((short)1);
//		emp.setEntryDate(LocalDate.of(2023, 2, 23));
//		emp.setCreateTime(LocalDate.now());
//		emp.setUpdateTime(LocalDate.now());
//		emp.setDeptId(1);
//		empMapper.insert(emp);
//	}
//
//	@Test
//	public void testUpdate() {
//		Emp emp = new Emp();
//		emp.setId(25);
//		emp.setUsername("liritian432");
//		emp.setName("牛逼得很");
//		emp.setImage("3333.png");
//		emp.setJob((short)2);
//		emp.setGender((short)0);
//		emp.setEntryDate(LocalDate.of(2022, 3, 23));
//		emp.setUpdateTime(LocalDate.now());
//		emp.setDeptId(2);
//		empMapper.update(emp);
//	}
//
//	@Test
//	public void testGetById(){
//		Emp emp = empMapper.getById(25);
//		System.out.println(emp);
//	}
//
//	@Test
//	public void testList() {
//		List<Emp> empList = empMapper.list("牛", (short) 1,
//				LocalDate.of(2010, 1, 1),
//				LocalDate.of(2023, 4,  24));
//		System.out.println(empList);
//	}

	@Test
	public void testListXml() {
		List<Emp> empList = empMapperXml.list("牛", (short) 1,
				LocalDate.of(2010, 1, 1),
				LocalDate.of(2023, 4,  24));
		System.out.println(empList);
	}

}

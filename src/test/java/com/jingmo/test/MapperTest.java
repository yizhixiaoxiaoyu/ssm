package com.jingmo.test;


import com.jingmo.dao.DepartmentMapper;
import com.jingmo.dao.EmployeeMapper;
import com.jingmo.pojo.Department;
import com.jingmo.pojo.Employee;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author 白金刚
 * @create 2019/5/23-2019
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springconfig/applicationContext.xml"})
public class MapperTest {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    SqlSession sqlSession;

    @Test
    public void test() {
      /* ApplicationContext  context = new ClassPathXmlApplicationContext("springconfig/applicationContext.xml");
        DepartmentMapper departmentMapper=context.getBean(DepartmentMapper.class);*/
//        System.out.println(departmentMapper);
//        departmentMapper.insertSelective(new Department(null,"开发部"));
//        departmentMapper.insertSelective(new Department(null,"测试部"));
//        departmentMapper.deleteByPrimaryKey(2)
//        employeeMapper.insertSelective(new Employee(null, "jimi", "M", "15646879@qq.com", 1));
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 1; i <= 1000; i++) {
            String uid=UUID.randomUUID().toString().substring(0,5);
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@qq.com",1));

        }
    }

}

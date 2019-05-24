package com.jingmo.service;

import com.jingmo.dao.EmployeeMapper;
import com.jingmo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 白金刚
 * @create 2019/5/23-2019
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
public List<Employee> getAll(){
    return employeeMapper.selectByExampleWithDept(null);
}
}

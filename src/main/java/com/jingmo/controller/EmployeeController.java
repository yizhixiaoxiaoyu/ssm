package com.jingmo.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jingmo.pojo.Employee;
import com.jingmo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 处理员工的crud操作
 *
 * @author 白金刚
 * @create 2019/5/23-2019
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    public String getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
//        这不是一个分页查询，分页查询使用pageHelper实现
        PageHelper.startPage(pn, 5);
        List<Employee> emps = employeeService.getAll();
        //使用pageInfo包装数据,可以配置需要显示的页数
        PageInfo page = new PageInfo(emps,6);
        model.addAttribute("pageInfo",page);
        return "list";
    }
}

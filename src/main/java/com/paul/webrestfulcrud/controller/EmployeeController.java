package com.paul.webrestfulcrud.controller;

import com.paul.webrestfulcrud.dao.EmployeeDao;
import com.paul.webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/5 11:11
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(ModelMap model){

        Collection<Employee> employees = employeeDao.getAll();
        if(employees == null){
            return "emp/list";
        }
        //放在请求域中
        model.addAttribute("emps",employees);
        //thymeleaf默认会拼串
        //classpath:/templates/xxx.html
        return "emp/list";
    }
}

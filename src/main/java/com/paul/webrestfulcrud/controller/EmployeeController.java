package com.paul.webrestfulcrud.controller;

import com.paul.webrestfulcrud.dao.DepartmentDao;
import com.paul.webrestfulcrud.dao.EmployeeDao;
import com.paul.webrestfulcrud.entities.Department;
import com.paul.webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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
    
    @Autowired
    DepartmentDao departmentDao;

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

    @GetMapping("/emp")
    public String toAddPage(ModelMap model){
        //来到添加页面，查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //springmvc自动将请求参数和入参对象进行一一绑定；要求请求参数的名字和javabean入参的对象里面的属性名一致
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        //来到员工列表页面

        //System.out.println("保存的员工信息" + employee);
        //保存员工
        employeeDao.save(employee);
        //redirect:重定向到一个地址 forward:转发到一个地址 /代表当前项目路径
        return "redirect:/emps";
    }

    //来到修改页面。查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,ModelMap model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //页面要显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        //回到修改页面(修改添加二合一)
        return "emp/add";
    }

    //员工修改,需要提交员工id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        //System.out.println("修改的员工数据" + employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}

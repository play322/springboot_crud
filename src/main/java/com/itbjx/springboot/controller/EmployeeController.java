package com.itbjx.springboot.controller;

import com.itbjx.springboot.dao.DepartmentDao;
import com.itbjx.springboot.dao.EmployeeDao;
import com.itbjx.springboot.entities.Department;
import com.itbjx.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    //查询所有员工
    @GetMapping(value = "/emps")
    public String list(Model model){
        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "emp/list";
    }

    //到添加员工的页面
    @GetMapping(value = "/emp")
    public String toAddPage(Model model){
        //到页面之前查出所有部门在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //添加员工
    @PostMapping(value = "/emp")
    public  String addEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //到修改页面
    @GetMapping(value = "/emp/{id}")
    public String toEditPage(@PathVariable("id")Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //到页面之前查出所有部门在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //修改员工
    @PutMapping(value = "/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @DeleteMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }




}

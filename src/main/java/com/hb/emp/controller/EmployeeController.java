package com.hb.emp.controller;

import com.hb.emp.bean.Employee;
import com.hb.emp.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-01 14:40
 */

@Controller
@RequestMapping("/emp")
public class EmployeeController {
    @Resource
    private  EmployeeService employeeService;
    @RequestMapping("login")
    public String login(String name,String pass){
        System.out.println(name);
        Employee employee = employeeService.login(name, pass);
        System.out.println(employee);
        if (employee!=null){
            return "redirect:/index.jsp";
        }else {
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("showManagerInfo")
    @ResponseBody
    public List<Employee> showManagerInfo(Integer pFk){
        List<Employee> employees = employeeService.queryAllmana(pFk);
        return employees;
    }

    @RequestMapping("getOtherInfo")
    @ResponseBody
    public List<Employee> getOtherInfo(@RequestParam(value = "id") Integer pid){
        List<Employee> employees = employeeService.getOthers(pid);
        return employees;
    }
    @RequestMapping("showEmp")
    @ResponseBody
    public List<Employee> showEmp(){
        List<Employee> employees=employeeService.showEmp();
        return employees;
    }
}

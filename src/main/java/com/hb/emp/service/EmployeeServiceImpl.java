package com.hb.emp.service;

import com.hb.emp.bean.Employee;
import com.hb.emp.mapper.EmployeeMapper;
import com.hb.pro.service.ProjectService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hb
 * @create 2020-07-01 15:22
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Resource
    private EmployeeMapper employeeMapper;

    @Override
    public Employee login(String name, String pass) {
        Employee employee = employeeMapper.login(name, pass);
        return employee;
    }

    @Override
    public List<Employee> queryAllmana(Integer pFk) {
        List<Employee> employees = employeeMapper.queryAllmana(pFk);
        return employees;
    }


    @Resource
    ProjectService projectService;
    @Override
    public List<Employee> getOthers(Integer pid) {
        int eid = projectService.getEmpfk(pid);
        List<Employee> employees = employeeMapper.getOthers(eid);
        return employees;
    }

    @Override
    public List<Employee> showEmp() {
        List<Employee> employees=employeeMapper.showEmp();
        return employees;
    }
}

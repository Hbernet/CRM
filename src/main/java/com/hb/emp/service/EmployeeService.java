package com.hb.emp.service;

import com.hb.emp.bean.Employee;

import java.util.List;

/**
 * @author hb
 * @create 2020-07-01 14:51
 */
public interface EmployeeService {
    Employee login(String name,String pass);

    List<Employee> queryAllmana(Integer pFk);

    List<Employee> getOthers(Integer pid);

    List<Employee> showEmp();
}

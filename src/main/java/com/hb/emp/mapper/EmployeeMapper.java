package com.hb.emp.mapper;

import com.hb.emp.bean.Employee;
import org.apache.ibatis.annotations.Param;


import java.util.List;
public interface EmployeeMapper {
   Employee login(@Param("name" )String name,@Param("pass")String pass);

   List<Employee> queryAllmana(Integer pFk);

   List<Employee> getOthers(int eid);

    List<Employee> showEmp();
}
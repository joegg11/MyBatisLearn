package com.joe.mybatis.dao;

import com.joe.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapperDynamicSQL {

    public List<Employee> getEmpByConditionIf(Employee employee);

    public List<Employee> getEmpByConditionChoose(Employee employee);

    public void updateEmp(Employee employee);

    public List<Employee> getEmpsByConditionForeach(@Param("ids")List<Integer> ids);

    public void addEmps(@Param("emps")List<Employee> emps);
}

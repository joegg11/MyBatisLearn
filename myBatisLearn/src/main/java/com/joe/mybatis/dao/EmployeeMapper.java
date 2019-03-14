package com.joe.mybatis.dao;

import com.joe.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface EmployeeMapper {

    public List<Employee> getAllEmps();

    public List<Employee> getEmpsByLastNameLike(String lastName);

    public Employee getEmpById(Integer id);

    public Employee getEmpByIdAndLastName(@Param("id")Integer id, @Param("lastName")String lastName);

    public Employee getEmpByMap(Map<String, Object> map);

    public void addEmp(Employee employee);

    public void updateEmp(Employee employee);

    public void deleteEmpById(Integer id);
}

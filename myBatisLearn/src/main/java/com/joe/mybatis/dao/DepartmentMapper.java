package com.joe.mybatis.dao;

import com.joe.mybatis.bean.Department;

public interface DepartmentMapper {
    public Department getDeptById(Integer id);

    public Department getDeptByIdPlus(Integer id);

    public Department getDeptByIdPlusStep(Integer id);
}

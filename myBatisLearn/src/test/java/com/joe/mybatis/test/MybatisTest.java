package com.joe.mybatis.test;

import com.joe.mybatis.bean.Department;
import com.joe.mybatis.bean.Employee;
import com.joe.mybatis.dao.*;
import com.sun.org.glassfish.gmbal.Description;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class MybatisTest {

    public SqlSessionFactory getSqlSessionFactory() throws IOException{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

/*    @Test
    public void test() throws IOException {
        *//*String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);*//*
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            Employee employee = openSession.selectOne("com.joe.mybatis.EmployeeMapper.selectEmp", 1);
            System.out.println(employee);
        }finally {
            openSession.close();
        }
    }*/

    @Test
    public void test01() throws IOException{

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            Employee employee = mapper.getEmpById(1);

            System.out.println(employee);
        }finally {
            openSession.close();
        }

    }

    @Test
    public void test02() throws IOException{

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapperAnnotation mapper = openSession.getMapper(EmployeeMapperAnnotation.class);

            Employee employee = mapper.getEmpById(1);

            System.out.println(employee);
        }finally {
            openSession.close();
        }

    }

    @Test
    public void test03() throws IOException{

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);

            /*测试添加
            Employee employee = new Employee(null, "smart", "111@qq.com", "1");
            mapper.addEmp(employee);*/


            /*Employee employee = new Employee(1, "smaj", "smaj@qq.com", "1");
            mapper.updateEmp(employee);*/

            /*mapper.deleteEmpById(6);*/

            openSession.commit();
        }finally {
            openSession.close();
        }
    }


    @Test
    public void test04() throws IOException{

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            /*Employee employee = mapper.getEmpByIdAndLastName(1, "smaj");*/
            Map<String, Object> map = new HashMap<>();
            map.put("id", 1);
            map.put("lastName", "smaj");
            Employee employee = mapper.getEmpByMap(map);
            System.out.println(employee);

            openSession.commit();
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test05() throws IOException{

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            /*Employee employee = mapper.getEmpByIdAndLastName(1, "smaj");*/
            /*Map<String, Object> map = new HashMap<>();
            map.put("id", 1);
            map.put("lastName", "smaj");
            Employee employee = mapper.getEmpByMap(map);
            System.out.println(employee);*/

            /*List<Employee> like = mapper.getEmpsByLastNameLike("%j%");
            for (Employee employee : like){
                System.out.println(employee);
            }*/

            List<Employee> employees = mapper.getAllEmps();

            for (Employee employee : employees){
                System.out.println(employee);
            }

            openSession.commit();
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test06() throws IOException{

        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();

        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapperPlus mapper = openSession.getMapper(EmployeeMapperPlus.class);

           /* Employee employee = mapper.getEmpById(1);

            System.out.println(employee);*/

           /*Employee empAndDept = mapper.getEmpAndDept(1);
           System.out.println(empAndDept);
           System.out.println(empAndDept.getDepartment());*/
           Employee employee = mapper.getEmpByIdStep(1);
           System.out.println(employee.getLastName());
        }finally {
            openSession.close();
        }
    }

    @Test
    public void test07() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            DepartmentMapper mapper = openSession.getMapper(DepartmentMapper.class);
            /*Department department = mapper.getDeptByIdPlus(2);
            System.out.println(department);
            System.out.println(department.getEmps());*/
            Department deptByIdStep = mapper.getDeptByIdPlusStep(1);
            System.out.println(deptByIdStep);
            System.out.println(deptByIdStep.getEmps());
        }finally {
            openSession.close();
        }
    }

    @Test
    public void testDynamicSql() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();
        try{
            EmployeeMapperDynamicSQL mapperDynamicSQL = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            /*Employee employee = new Employee(1, "David", null, null);*/
            /*List<Employee> emps = mapperDynamicSQL.getEmpByConditionIf(employee);
            for (Employee emp : emps){
                System.out.println(emp);
            }*/
            /*List<Employee> list = mapperDynamicSQL.getEmpByConditionChoose(employee);
            for (Employee emp : list){
                System.out.println(list);*/
            /*mapperDynamicSQL.updateEmp(employee);*/

            List<Employee> list = mapperDynamicSQL.getEmpsByConditionForeach(Arrays.asList(1,2,3,4,5));
            for (Employee emp : list){
                System.out.println(emp);
            }
            openSession.commit();

        }finally {
            openSession.close();
        }
    }

    @Test
    public void testBatchSave() throws IOException{
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession openSession = sqlSessionFactory.openSession();

        try {
            EmployeeMapperDynamicSQL mapperDynamicSQL = openSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> emps = new ArrayList<>();
            emps.add(new Employee(null, "jjj", "jjj@qq.com", "1", new Department(1)));
            emps.add(new Employee(null, "ddd", "ddd@qq.com", "0", new Department(2)));
            mapperDynamicSQL.addEmps(emps);
            openSession.commit();

        }finally {
            openSession.close();
        }
    }
}

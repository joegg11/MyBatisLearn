package com.joe.mybatis.test;

import com.joe.mybatis.bean.Employee;
import com.joe.mybatis.dao.EmployeeMapper;
import com.joe.mybatis.dao.EmployeeMapperAnnotation;
import com.joe.mybatis.dao.EmployeeMapperPlus;
import com.sun.org.glassfish.gmbal.Description;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
}

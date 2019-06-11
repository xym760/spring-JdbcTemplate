package com.xym.spring.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xym760
 * @Date: 2019/6/11 11:19
 * @Description:
 */
public class JDBCTest {
    private ApplicationContext applicationContext;
    private JdbcTemplate jdbcTemplate;

    {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
    }

    /**
     * 从数据库中获取一条记录，实际返回一个对象
     * 使用SQL中列的别名完成数据库字段名到对象属性名的映射。如last_name映射为对象属性名lastName
     */
    @Test
    public void testQueryForObject() {
        String sql = "select id,last_name lastName,email from employees where id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee= jdbcTemplate.queryForObject(sql,rowMapper,1);
        System.out.println(employee);
    }

    /**
     * 查询实体类的集合
     * 注意调用的不是queryForList方法
     */
    @Test
    public void testQueryForList(){
        String sql="select id,last_name lastName,email from employees where id > ?";
        RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<>(Employee.class);
        List<Employee> employees=jdbcTemplate.query(sql,rowMapper,3);
        System.out.println(employees);
    }

    /**
     * 查询单个列的值，或做统计分析等
     */
    @Test
    public void testQueryForObjectOther(){
        String sql="select count(id) from employees";
        long amount=jdbcTemplate.queryForObject(sql,Long.class);
        System.out.println(amount);
    }

    /**
     * 执行Insert,update,delete
     */
    @Test
    public void testUpdate() {
        String sql = "UPDATE employees set last_name = ? where id = ?";
        jdbcTemplate.update(sql, "Rose", 1);
    }

    /**
     * 执行批量更新：insert，update，delete
     * 最后一个参数是Object[]类型的List，因为一条记录对应一个Object[]，多条记录就对应一个Object数组类型的List
     */
    @Test
    public void testBatchUpdate() {
        String sql = "insert into employees(last_name,email,dept_id) values (?,?,?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{"刘华", "ifsif@nxist.com", 5});
        batchArgs.add(new Object[]{"赵丽", "ifsif@nxist.com", 6});
        batchArgs.add(new Object[]{"机电室计分", "dsf@nxist.com", 7});
        batchArgs.add(new Object[]{"十九大", "dsd@nxist.com", 8});
        batchArgs.add(new Object[]{"降低", "ad@nxist.com", 9});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = applicationContext.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}

package com.kainos.ea;

import com.kainos.ea.employee_stuff.Employee;
import com.kainos.ea.employee_stuff.EmployeeResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class EmployeesDBTest {

    @Test
    public void getConnection() {
    }

    @Test
    public void getEmployeesTest() {

        List<EmployeeResponse> emps1 = new ArrayList<>();
        List<EmployeeResponse> newEmps1= new ArrayList<>();

        emps1 = EmployeesDB.getEmployees();
        newEmps1 = EmployeesDB.getEmployees();

        assertEquals(emps1,newEmps1);


    }

    @Test
    public void insertEmployees() {
    }

    @Test
    public void insertESalesEmployees() {
    }
}
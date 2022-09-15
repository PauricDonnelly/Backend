package com.kainos.ea;

import com.kainos.ea.employee_stuff.Employee;
import com.kainos.ea.employee_stuff.EmployeeRequest;
import com.kainos.ea.employee_stuff.SalesEmployee;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EmployeesDB {

    private static Connection conn;

    static Connection getConnection() {
        String user;
        String password;
        String host;

        if (conn != null) {
            return conn;
        }

        try {
            // Bad practice alert!
            FileInputStream propsStream =
                    new FileInputStream("employeesdb.properties");

            Properties props = new Properties();
            props.load(propsStream);

            user            = props.getProperty("user");
            password        = props.getProperty("password");
            host            = props.getProperty("host");

            if (user == null || password == null || host == null)
                throw new IllegalArgumentException(
                        "Properties file must exist and must contain "
                                + "user, password, and host properties.");
            conn = DriverManager.getConnection("jdbc:mysql://"
                    + host + "/GroupWeek2_ConorMcG?useSSL=false", user, password);
            return conn;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static List<Employee> getEmployees() {
        List<Employee> emps = new ArrayList<>();
        try {
            Connection con = EmployeesDB.getConnection();  // Bad practices alert!
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT DISTINCT * FROM Employee e, SalesEmployee s WHERE e.emp_id = s.se_id;");
            while (rs.next()) {
                Employee resp = new Employee(
                        rs.getDouble("salary"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("bankAccountNumber"),
                        rs.getString("NIN"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"));
                emps.add(resp);
            }
            rs = st.executeQuery("SELECT DISTINCT * FROM Employee e, DeliveryEmployee d WHERE e.emp_id = d.de_id;");
            while (rs.next()) {
                Employee resp = new Employee(
                        rs.getDouble("salary"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("bankAccountNumber"),
                        rs.getString("NIN"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"));
                emps.add(resp);
            }
            rs = st.executeQuery("SELECT DISTINCT * FROM Employee e WHERE e.emp_id NOT IN " +
                    "(SELECT d.de_id FROM DeliveryEmployee d) AND e.emp_id NOT IN" +
                    "(SELECT s.se_id FROM SalesEmployee s)");
            while (rs.next()) {
                Employee resp = new Employee(
                        rs.getDouble("salary"),
                        rs.getString("fname"),
                        rs.getString("lname"),
                        rs.getString("bankAccountNumber"),
                        rs.getString("NIN"),
                        rs.getString("phoneNumber"),
                        rs.getString("email"));
                emps.add(resp);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); // Bad practice alert!
        }
        return emps;
    }

    public static String insertEmployees(EmployeeRequest employee) {
        try {
            Connection con = EmployeesDB.getConnection();  // Bad practices alert!
            Statement st = con.createStatement();
            st.executeUpdate(
                    "INSERT INTO Employee (fname, lname, salary, bankAccountNumber, NIN, phoneNumber, email)"

                            + " VALUES ('" + employee.getFirstName() + "', '" + employee.getLastName() + "', " +
                            employee.getSalary() + ", '" + employee.getBankAccountNumber() + "', '" +
                            employee.getNiNumber() + "', '" + employee.getPhoneNumber() + "', '" +
                            employee.getEmail()+"')");

        } catch (SQLException ex) {
            ex.printStackTrace(); // Bad practice alert!
        }
        return "Employee:"+employee.getFirstName()+" "+employee.getLastName()+" added!";
    }
    //INSERT INTO SalesEmployee (se_id,Commision, salesThisMonth) VALUES (7,0.010, 40000.50);
    public static String insertESalesEmployees(SalesEmployee employee) {
        int i=0;
        try {
            Connection con = EmployeesDB.getConnection();  // Bad practices alert!
            Statement st = con.createStatement();
            st.executeUpdate(
                    "INSERT INTO Employee (fname, lname, salary, bankAccountNumber, NIN, phoneNumber, email)"

                            + " VALUES ('" + employee.getFirstName() + "', '" + employee.getLastName() + "', " +
                            employee.getSalary() + ", '" + employee.getBankAccountNumber() + "', '" +
                            employee.getNiNumber() + "', '" + employee.getPhoneNumber() + "', '" +
                            employee.getEmail()+"')");
            ResultSet rs = st.executeQuery("SELECT max(emp_id) FROM Employee");
            while (rs.next()) {
                i = rs.getInt(1);


            }
            st.executeUpdate("INSERT INTO SalesEmployee (se_id,Commision, salesThisMonth) VALUES ('" + i + "', '"+
                    employee.getCommissionRate() + "', '" + employee.getSalesTotal() + "')" );
        } catch (SQLException ex) {
            ex.printStackTrace(); // Bad practice alert!
        }
        return "Employee:"+employee.getFirstName()+" "+employee.getLastName()+" added!";
    }



}

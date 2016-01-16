/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.training.usecase.dao;

import edu.techseekers.training.usecase.domain.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author myhome
 */
public class EmployeeDAO {

    DBManager conManager;

    public EmployeeDAO(DBManager conManager) {
        this.conManager = conManager;
    }

    public void insertEmployee(Employee emp) throws SQLException {
        Connection con = conManager.getDBConnection();

        String query = "insert into employees(emp_no, birth_date, first_name, last_name, gender, hire_date) values(?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1, emp.getEmpNo());
        stmt.setDate(2, new Date(1985, 8, 22));
        stmt.setString(3, emp.getFirstName());
        stmt.setString(4, emp.getLastName());
        stmt.setString(5, "M");
        stmt.setDate(6, new Date(2003, 5, 10));
        stmt.execute();
    }

    public Employee getEmployee(int empNo) {
        Connection con = conManager.getDBConnection();
        try {
            Statement stmt = con.createStatement();

            ResultSet result = stmt.executeQuery("select emp_no, birth_date, first_name, last_name, gender, hire_date from employees where emp_no=" + empNo);
            if (result.next()) {
                int employeeNo = result.getInt(1);
                Date birthDate = result.getDate(2);
                String firstName = result.getString(3);
                String lastName = result.getString(4);
                String gender = result.getString(5);
                Date hireDate = result.getDate(6);
                
                Employee emp = new Employee();
                
                emp.setEmpNo(employeeNo);
                emp.setBirthDate(birthDate.toString());
                emp.setFirstName(firstName);
                emp.setLastName(lastName);
                emp.setGender(gender);
                emp.setHireDate(hireDate.toString());
                
                return emp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String ap[]) throws Exception {
        DBManager conManager = new DBManager();
        EmployeeDAO empDAO = new EmployeeDAO(conManager);
        Employee emp = empDAO.getEmployee(202999);
        if (emp != null) {
            System.out.println(emp.getFirstName());
            System.out.println(emp.getBirthDate());
        }

        Employee employee = new Employee();
        employee.setEmpNo(3221021);
        employee.setFirstName("laxmikanth");
        employee.setLastName("samudrala");
        empDAO.insertEmployee(employee);

        emp = empDAO.getEmployee(3221021);
        if (emp != null) {
            System.out.println(emp.getFirstName());
            System.out.println(emp.getBirthDate());
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.training.usecase.wsdl;

import edu.techseekers.training.usecase.dao.DBManager;
import edu.techseekers.training.usecase.dao.EmployeeDAO;
import edu.techseekers.training.usecase.domain.Employee;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;

/**
 *
 * @author myhome
 */

@WebService(endpointInterface = "edu.techseekers.training.usecase.wsdl.EmployeeService")
public class EmployeeServiceImpl implements EmployeeService {

    DBManager conManager = new DBManager();
    EmployeeDAO empDAO = new EmployeeDAO(conManager);

    @Override
    public void addEmployee(Employee emp) {
        try {
            empDAO.insertEmployee(emp);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Employee getEmployee(int empNo) {
        return empDAO.getEmployee(empNo);
    }

}

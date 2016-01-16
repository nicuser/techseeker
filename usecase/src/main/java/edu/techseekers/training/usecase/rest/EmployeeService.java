package edu.techseekers.training.usecase.rest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author myhome
 */
import edu.techseekers.training.usecase.dao.DBManager;
import edu.techseekers.training.usecase.dao.EmployeeDAO;
import edu.techseekers.training.usecase.domain.Employee;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/customerservice/")
@Produces("text/xml")
public class EmployeeService {

    DBManager conManager = new DBManager();
    EmployeeDAO empDAO = new EmployeeDAO(conManager);

    /**
     * @param args the command line arguments
     */
    @GET
    @Path("/employees/{id}/")
    public Employee getEmployee(@PathParam("id") int id) {
        return empDAO.getEmployee(id);
    }

}

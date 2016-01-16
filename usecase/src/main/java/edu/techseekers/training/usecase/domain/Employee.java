/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.techseekers.training.usecase.domain;

/**
 *
 * @author myhome
 */

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Employee")
public class Employee {
    private int empNo;
    private String birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private String hireDate;
    
//    public Employee(int empNo, String birthDate, String firstName, String lastName, String gender, String hireDate) {
//        this.empNo = empNo;
//        this.birthDate = birthDate;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.gender = gender;
//        this.hireDate = hireDate;
//    }
//    
//    public Employee(int empNo, String firstName, String lastName) {
//        this.empNo = empNo;
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }
}

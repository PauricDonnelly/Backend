package com.kainos.ea.employee_stuff;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeResponse {
    private int emp_id;
    protected double salary;   // employee salary in pence
    private String firstName;  // employee first name
    private String lastName; //employee last name
    private String bankAccountNumber; // employee Bank Account number
    private String niNumber; // National Insurance
    private String phoneNumber; // Phone Number
    private String email; //email

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getNiNumber() {
        return niNumber;
    }

    public void setNiNumber(String niNumber) {
        this.niNumber = niNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonCreator
    public EmployeeResponse(@JsonProperty("emp_id")int emp_id,@JsonProperty("salary") double salary,
                           @JsonProperty("firstName") String firstName, @JsonProperty("lastName") String lastName,
                           @JsonProperty("bankAccountNumber") String bankAccountNumber, @JsonProperty("niNumber") String niNumber,
                           @JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("email") String email) {
        this.emp_id = emp_id;
        this.salary = salary;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bankAccountNumber = bankAccountNumber;
        this.niNumber = niNumber;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}

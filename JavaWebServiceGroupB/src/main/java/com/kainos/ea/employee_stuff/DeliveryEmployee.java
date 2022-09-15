package com.kainos.ea.employee_stuff;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DeliveryEmployee extends Employee{
    private String cv;
    private String image;
    private String favTech;

    public DeliveryEmployee(@JsonProperty("emp_id")int emp_id, @JsonProperty("salary") double salary,
                            @JsonProperty("firstname") String firstName, @JsonProperty("lastname") String lastName,
                            @JsonProperty("bankAccountNumber") String bankAccountNumber, @JsonProperty("niNumber") String niNumber,
                            @JsonProperty("phoneNumber") String phoneNumber, @JsonProperty("email") String email , @JsonProperty("Commision") float commissionRate, @JsonProperty("salesThisMonth") int salesTotal) {
        super(emp_id, salary, firstName, lastName, bankAccountNumber, niNumber, phoneNumber, email);
        this.cv = cv;
        this.image = image;
        this.favTech = favTech;
    }

    public DeliveryEmployee(String cv, String image, String favTech) {
        this.cv = cv;
        this.image = image;
        this.favTech = favTech;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFavTech() {
        return favTech;
    }

    public void setFavTech(String favTech) {
        this.favTech = favTech;
    }
}

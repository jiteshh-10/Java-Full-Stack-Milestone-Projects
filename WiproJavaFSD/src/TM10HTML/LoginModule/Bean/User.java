package TM10HTML.LoginModule.Bean;

// In package: com.example.bean
package com.example.bean;

import java.sql.Date;

public class User {
    private String userid;
    private String password;
    private Date dob;
    private String gender;
    private String state;
    private String contact;
    private String address;

    // Getters and Setters for all fields...
    public String getUserid() { return userid; }
    public void setUserid(String userid) { this.userid = userid; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
    public String getState() { return state; }
    public void setState(String state) { this.state = state; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}

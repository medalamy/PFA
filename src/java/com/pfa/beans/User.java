/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfa.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author medEl
 */
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "username", unique = true)
    private String userName; //login
    private String pass;

    @Column(name = "first_name")
    private String fName; //prenom
    @Column(name = "last_name")
    private String lName; //nom
    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;
    //@Column(name = "is_activaed")
    //private boolean isActivated;

    @OneToMany(mappedBy = "user")
    private List<UserRoles> userRoles;

    public User() {
    }

    public User(String userName, String pass, String fName, String lName, String phone, String email) {
        this.userName = userName;
        this.pass = pass;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserRoles> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoles> userRoles) {
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "User{" + "Id=" + Id + ", userName=" + userName + ", pass=" + pass + ", fName=" + fName + ", lName=" + lName + ", phone=" + phone + ", email=" + email + ", userRoles=" + userRoles + '}' + "\n";
    }

}

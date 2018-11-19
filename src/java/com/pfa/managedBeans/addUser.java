/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfa.managedBeans;

import com.pfa.beans.User;
import com.pfa.dal.IGenericDao;
import com.pfa.ioc.dependencyInject;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author medEl
 */
@Named(value = "addUser")
@Dependent
public class addUser {
    
    private User user;
    private final IGenericDao dao = dependencyInject.instance.getDao();

    /**
     * Creates a new instance of addUser
     */
    public addUser() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void save(){
        dao.add(user);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfa.managedBeans;

import com.pfa.beans.Region;
import com.pfa.beans.User;
import com.pfa.dal.IGenericDao;
import com.pfa.ioc.dependencyInject;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author medEl
 */
@ManagedBean(name = "User")
@RequestScoped
public class UserManagedBean {

    private User user, u;
    private List<User> users = new ArrayList<>();
    private final IGenericDao<User> dao;
    private String str;
    
    private Region reg;
    private List<Region> regions;
    private final IGenericDao<Region> daoR;

    /**
     * Creates a new instance of addUser
     */
    public UserManagedBean() {
        dao = dependencyInject.instance.getDao();
        user = new User();
        users = dao.getAll(User.class);
        daoR = dependencyInject.instance.getDao();
        regions = daoR.getAll(Region.class);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
    
    

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Region getReg() {
        return reg;
    }

    public void setReg(Region reg) {
        this.reg = reg;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    
    
    
    

    public String save() {
        System.out.println("com.pfa.managedBeans.UserManagedBean.save()");
        System.out.println(user);
        System.out.println(str);
        user.setRegion(daoR.findById(Region.class, Integer.parseInt(str)));
        dao.add(user);
        users = dao.getAll(User.class);
        return "index";
    }

    public String delete(User u) {
        System.out.print(u);
        dao.delete(u, u.getId());
        users = dao.getAll(User.class);
        return "index";
    }

    public String update(User u) {
        System.out.println(u);
        this.user = u;
        return "update";
    }

    public String doUpdate() {
        System.out.println(user);
        dao.update(user);
        return "index";
    }

    public String login() {
        User u1 = dao.findByKeyword(User.class, "userName", user.getUserName());
        if ((u1) != null) {
            return "index";
        } else {
            return "login";
        }

    }

}

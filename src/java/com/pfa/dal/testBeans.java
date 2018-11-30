/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfa.dal;

import com.pfa.beans.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author medEl
 */
public class testBeans {

    public static void main(String[] args) {

        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("PFAPU"); //suffisant pour créer les tableaux dans la base
        
        GenericDaoJpaImpl<User> dao = new GenericDaoJpaImpl<>();

        //User u = new User();
        //dao.add(u);
        //--
        User u2 = new User();
        u2 = dao.findById(User.class, 30);
        u2.setUserName("login");
        dao.update(u2);
        //--
        User u3 = new User();
        u3.setId(5);
        dao.delete(u3);
        //--
//        List users = new ArrayList<>();
//        users = dao.getAll(User.class);
//        System.out.println(users);
        

    }

}

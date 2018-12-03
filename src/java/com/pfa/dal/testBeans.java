/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfa.dal;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.pfa.beans.Region;
import com.pfa.beans.User;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author medEl
 */
public class testBeans {


    public static void createDB(String db) throws SQLException {
        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/?user=", "root", "");
        Statement stmt = (Statement) connection.createStatement();
        stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS " + db);
    }

    public static void main(String[] args) throws Exception {
        //createDB("hib");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PFAPU"); //suffisant pour créer les tableaux dans la base

        
//        GenericDaoJpaImpl<User> dao = new GenericDaoJpaImpl<>();
//        GenericDaoJpaImpl<Region> dao2 = new GenericDaoJpaImpl<>();
        
//        //--
//        Region r2 = new Region();
//        r2.setId(12);
//        dao2.delete(r2);
//        r2.setName("re1222");
//        dao2.add(r2);
//        //--
//        Region r1 = new Region();
//        r1.setName("re555");
//        User u = new User();
//        u.setUserName("user001");
//        u.setRegion(r1);
//        dao2.add(r1);
//        dao.add(u);
        //--
//        User u2 = new User();
//        u2 = dao.findById(User.class, 30);
//        u2.setUserName("login");
//        dao.update(u2);
//        //--
//        User u3 = new User();
//        u3.setId(5);
//        dao.delete(u3);
//        //--
//        List users = new ArrayList<>();
//        users = dao.getAll(User.class);
//        System.out.println(users);

    }

}

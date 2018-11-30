/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfa.ioc;

import com.pfa.beans.User;
import com.pfa.dal.IGenericDao;
import java.util.logging.Level;
import java.util.logging.Logger;
//import java.util.ServiceLoader;

/**
 *
 * @author medEl
 */
public enum dependencyInject {
    instance;

    private IGenericDao idao;

    private dependencyInject() {
    }

    public IGenericDao<User> getDao() {
        //idao = new GenericDaoJpaImpl(); //change dependency here
        //idao = (IGenericDao) IGenericDao.class.getClassLoader().loadClass(ConfigReader.getConfigClassName()).newInstance(); working too
        
        try {
            idao = (IGenericDao) Class.forName(ConfigReader.getConfigClassName()).newInstance();
        } catch (Exception ex) {
            Logger.getLogger(dependencyInject.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idao;
    }

//    for testing    
    
//    public static void main(String[] args) throws Exception {
//        dependencyInject.instance.getDao().add(new User());
//    }

}

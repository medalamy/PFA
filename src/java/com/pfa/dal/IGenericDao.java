/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfa.dal;

import java.util.List;

/**
 *
 * @author medEl
 * @param <T>
 */
public interface IGenericDao<T> {

    public void add(T o); //create

    public T findById(Class c, int id); //read
    
    public T findByUsername(Class c, String s);

    public void update(T o);

    public void delete(T o);
    
     public void delete(T o,int id);
    
    public List<T> getAll(Class c);

}

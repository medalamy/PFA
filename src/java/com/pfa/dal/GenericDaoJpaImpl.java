/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfa.dal;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author medEl
 */
public class GenericDaoJpaImpl<T> implements IGenericDao<T> {

    private EntityManagerFactory emf;
    private EntityManager em;
    private EntityTransaction et;

    public GenericDaoJpaImpl() {
        emf = Persistence.createEntityManagerFactory("PFAPU");
        em = emf.createEntityManager();
    }

    @Override
    public void add(T o) {
        openTrx();
        em.persist(o);
        commitAndClose();
    }

    @Override
    public T findById(Class c, int id) {
        openTrx();
        Object o = (T) em.find(c, id);
        commitAndClose();
        return (T) o;
    }

    @Override
    public void update(T o) {
        openTrx();
        em.merge(o);
        commitAndClose();

    }

    @Override
    public void delete(T o) {
        openTrx();
        em.remove(em.contains(o) ? o : em.merge(o)); //?
        commitAndClose();
    }

    @Override
    public List<T> getAll(Class c) {
        Query q = em.createQuery("select object(o) from " + c.getName() + " as o");
        return q.getResultList();
    }

    private void openTrx() {
        et = em.getTransaction();
        et.begin();
    }

    private void commitAndClose() {
        et.commit();
        //em.close();
    }

}

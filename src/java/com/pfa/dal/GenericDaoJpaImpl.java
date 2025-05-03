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

    private final EntityManagerFactory emf;
    private final EntityManager em;
    private final EntityTransaction et;

    public GenericDaoJpaImpl() {
        emf = Persistence.createEntityManagerFactory("PFAPU");
        em = emf.createEntityManager();
        et = em.getTransaction();
    }

    @Override
    public void add(T o) {
        et.begin();
        em.persist(o);
        et.commit();
    }

    @Override
    public T findById(Class c, int id) {
        et.begin();
        Object o = (T) em.find(c, id);
        et.commit();
        return (T) o;
    }

    @Override
    public T findByKeyword(Class c, String param, String value) {
        et.begin();
        Query q = em.createQuery("select o from " + c.getName() + " as o where o." + param + " LIKE '" + value + "'");
//        q.setParameter("class", c.getName());
//        q.setParameter("param", param);
//        q.setParameter("val", value);
        List l = q.getResultList();
        try {
            return (T) q.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void update(T o) {
        et.begin();
        em.merge(o);
        et.commit();
    }

    public void update(T o, int id) {
//        et.begin();
//        et.commit();
    }

    @Override
    public void delete(T o) {
        et.begin();
        em.remove(em.contains(o) ? o : em.merge(o));
        et.commit();
    }

    @Override
    public void delete(T o, int id) {
        et.begin();
        Object f = em.find(o.getClass(), id);
        em.remove(f);
        et.commit();
    }

    @Override
    public List<T> getAll(Class c) {
        Query q = em.createQuery("select o from " + c.getName() + " as o");
        return q.getResultList();
    }

}

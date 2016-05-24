/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hibernate;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public abstract class Dao<T> {
    protected final Class<T> clazz;

	public Dao(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public T insert(T t) {
		try (Session s = JpaUtils.getSessionFactory().openSession()) {
			Transaction tr = s.beginTransaction();
			s.save(t);
			tr.commit();
			return t;
		}
	}

	public void update(T t) {
		try (Session s = JpaUtils.getSessionFactory().openSession()) {
			Transaction tr = s.beginTransaction();
			s.update(t);
			tr.commit();
		}
	}

	public void delete(T t) {
		try (Session s = JpaUtils.getSessionFactory().openSession()) {
			Transaction tr = s.beginTransaction();
			s.delete(t);
			tr.commit();
		}
	}

	public T findOne(int id) {
		try (Session s = JpaUtils.getSessionFactory().openSession()) {
			T t = (T) s.createCriteria(clazz).add(Restrictions.idEq(id)).uniqueResult();
			return t;
		}
	}

	public List<T> findAll() {
		try (Session s = JpaUtils.getSessionFactory().openSession()) {
			List<T> list = s.createCriteria(clazz).list();
			return list;
		}
	}

}

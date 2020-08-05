package com.example.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.pojo.Address;
import com.example.pojo.Employee;

public class TestEmployee {

	public static void main(String[] args) {
		Employee emp = new Employee();
		emp.setUserName("Ramesh RadhaKrishnan");
		
		Address add = new Address();
		add.setStreet("1st cross mail road.");
		add.setCity("Bangalore");
		add.setState("KA");
		add.setPinCode(456123);
		
		emp.setHomeAddress(add);
		
		Address addr = new Address();
		
		addr.setStreet("93/2 Embassy Tech Village");
		addr.setCity("Bangalore");
		addr.setState("KA");
		addr.setPinCode(456321);
		
		
		
		emp.setOfficeAddress(addr);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			session.save(emp);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			if(session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		} finally {
			session.close();
		}
		
	}

}

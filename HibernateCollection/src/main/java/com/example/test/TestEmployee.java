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
		emp.setUserName("Abhishekh Trivedi");
		
		Address add1 = new Address();
		
		add1.setStreet("Fulera");
		add1.setCity("Baliya");
		add1.setState("Uttar Pradesh");
		add1.setPinCode(124575);
		
		Address add2 = new Address();
		
		add2.setStreet("Dhuliya");
		add2.setCity("Kanpur");
		add2.setState("Uttar radesh");
		add2.setPinCode(124784);
		
		emp.getListOfAddress().add(add1);
		emp.getListOfAddress().add(add2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		try {
			session.beginTransaction();
			session.save(emp);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}

	}

}

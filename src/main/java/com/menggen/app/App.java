package com.menggen.app;

import org.hibernate.Session;

import java.math.BigInteger;

public class App {
    public static void main(String[] args) {
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();

	    // Check database version
	    String sql = "select count(1) from TASK_DETAILS;";

	    BigInteger result = (BigInteger) session.createNativeQuery(sql).getSingleResult();
	    System.out.println(result);

	    session.getTransaction().commit();
	    session.close();

	    HibernateUtil.shutdown();
    }
}

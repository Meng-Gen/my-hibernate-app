package com.menggen.app;

import org.hibernate.Session;

import java.math.BigInteger;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<TaskDetails> taskDetailsList = (List<TaskDetails>)session.createQuery("from TaskDetails").list();
        for (TaskDetails taskDetails : taskDetailsList) {
            System.out.println(taskDetails.getId());
            System.out.println(taskDetails.getKey());
            System.out.println(taskDetails.getValue());
        }

        session.getTransaction().commit();
        session.close();

        HibernateUtil.shutdown();
    }
}

package dao;

import entity.Customer;
import entity.Expert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CustomerDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public void addCustomer(Customer customer){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }
}

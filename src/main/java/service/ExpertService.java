package service;

import entity.Expert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
public class ExpertService {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public void addUser(Expert expert){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(expert);
        transaction.commit();
        session.close();
    }
}

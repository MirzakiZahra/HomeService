package data.repository;

import data.model.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TransactionDao {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void addTransaction(Transaction transaction){
        Session session = sessionFactory.openSession();
        org.hibernate.Transaction transaction1=  session.beginTransaction();
        session.save(transaction);
        transaction1.commit();
        session.close();
    }
}

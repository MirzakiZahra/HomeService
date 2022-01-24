package dao;

import model.user.Expert;
import model.user.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AdminDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void addAdmin(Manager manager) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(manager);
        transaction.commit();
        session.close();
    }
}

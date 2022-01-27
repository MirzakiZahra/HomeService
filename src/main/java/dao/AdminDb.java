package dao;

import model.user.Manager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class AdminDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void addAdmin(Manager manager) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(manager);
        transaction.commit();
        session.close();
    }
    public List<Manager> findManagerByEmail(String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Manager m where m.email = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        List<Manager> managerList = query.getResultList();
        transaction.commit();
        session.close();
        return managerList;
    }
}

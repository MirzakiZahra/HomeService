package dao;

import model.services.SubService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class SubServiceDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public List<SubService> getAllSubService(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from SubService";
        Query query = session.createQuery(hql);
        List<SubService> subServices = query.getResultList();
        transaction.commit();
        session.close();
        return subServices;
    }
}

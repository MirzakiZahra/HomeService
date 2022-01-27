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

    public List<SubService> getAllSubService() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from SubService";
        Query query = session.createQuery(hql);
        List<SubService> subServices = query.getResultList();
        transaction.commit();
        session.close();
        return subServices;
    }

    public SubService checkExistOfSubServiceById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from SubService s where s.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<SubService> subServices = query.getResultList();
        transaction.commit();
        session.close();
        return subServices.get(0);
    }
    public SubService findSubServiceByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from SubService s where s.name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        List<SubService>subServices = query.getResultList();
        transaction.commit();
        session.close();
        return subServices.get(0);
    }

    public void deleteSubService(SubService subService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(subService);
        transaction.commit();
        session.close();
    }
    public void addSubService(SubService subService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(subService);
        transaction.commit();
        session.close();
    }

    public List<SubService> findSubServiceByNameReturnList(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from MainService s where s.name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        List<SubService> subServices = query.getResultList();
        transaction.commit();
        session.close();
        return subServices;
    }
    public void updateSubService(SubService subService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(subService);
        transaction.commit();
        session.close();
    }

}

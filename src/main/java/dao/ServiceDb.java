package dao;

import model.services.MainService;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class ServiceDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public List<MainService> findServiceByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from MainService s where s.name = :name";
        Query query = session.createQuery(hql);
        query.setParameter("name", name);
        List<MainService> mainServices = query.getResultList();
        transaction.commit();
        session.close();
        return mainServices;
    }
    public void updateMainService(MainService mainService){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(mainService);
        transaction.commit();
        session.close();
    }

    public void deleteMainService(MainService mainService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(mainService);
        transaction.commit();
        session.close();
    }

    public List<MainService> showServiceForSpeceficExpert(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from person where name =name";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(MainService.class);
        List<MainService> homeServices = query.list();
        return homeServices;
    }
    public void addMainService(MainService mainService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(mainService);
        transaction.commit();
        session.close();
    }

}

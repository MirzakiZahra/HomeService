package dao;

import model.services.MainService;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ServiceDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public MainService findServiceByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from HomeService where name = :name ";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(MainService.class);
        query.setParameter("name", name);
        MainService mainService = (MainService) query.list().get(0);
        session.close();
        return mainService;
    }

    public void deleteServicewithService(MainService mainService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(mainService);
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


}

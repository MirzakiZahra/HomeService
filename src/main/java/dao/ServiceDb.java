package dao;

import model.services.HomeServices;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ServiceDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public HomeServices findServiceByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from HomeService where name = :name ";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(HomeServices.class);
        query.setParameter("name", name);
        HomeServices homeServices= (HomeServices) query.list().get(0);
        session.close();
        return homeServices;
    }
    public void deleteServicewithService(HomeServices homeServices){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(homeServices);
        transaction.commit();
        session.close();
    }
    public List<HomeServices> showServiceForSpeceficExpert(String name){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from person where name =name";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(HomeServices.class);
        List<HomeServices>homeServices=query.list();
        return homeServices;
    }



}

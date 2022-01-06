package dao;

import model.people.Customer;
import model.people.Expert;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ExpertDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void addExpert(Expert expert) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(expert);
        transaction.commit();
        session.close();
    }
    public void deleteExpert(Expert expert){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(expert);
        transaction.commit();
        session.close();
    }

    public Expert findExpertByEmail(String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from expert where email = :email";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Expert.class);
        query.setParameter("email", email);
        Expert expert = (Expert) query.list().get(0);
        session.close();
        return expert;
    }

    public void updateExpertCredit(Expert expert) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(expert);
        transaction.commit();
        session.close();

    }
    public void updateExpertScore(Expert expert) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(expert);
        transaction.commit();
        session.close();

    }

    public List<Expert>showExpert() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from person where DTYPE =Expert";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Expert.class);
        List<Expert> expertList = query.list();
        return expertList;
    }
    public void deleteExpertWithService(Expert expert){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(expert);
        transaction.commit();
        session.close();
    }
    public void newScore(Expert expert){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(expert);
        transaction.commit();
        session.close();
    }

}

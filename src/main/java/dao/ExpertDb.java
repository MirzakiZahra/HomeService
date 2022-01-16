package dao;

import model.user.Expert;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
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

    public void deleteExpert(Expert expert) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(expert);
        transaction.commit();
        session.close();
    }

    public Expert findExpertByEmail(String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Expert s where s.email = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        List<Expert> expertList = query.getResultList();
        transaction.commit();
        session.close();
        return expertList.get(0);
    }

    public void updateExpert(Expert expert) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(expert);
        transaction.commit();
        session.close();

    }

    public List<Expert> showExpert() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from person where DTYPE =Expert";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Expert.class);
        List<Expert> expertList = query.list();
        return expertList;
    }

    public void deleteExpertWithService(Expert expert) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(expert);
        transaction.commit();
        session.close();
    }

    public void newScore(Expert expert) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(expert);
        transaction.commit();
        session.close();
    }

}

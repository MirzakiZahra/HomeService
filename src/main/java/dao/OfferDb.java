package dao;

import model.Offer;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class OfferDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void addOffer(Offer offer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(offer);
        transaction.commit();
        session.close();
    }

    public List<Offer> showOffer() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from offer ";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Offer.class);
        List<Offer> offerList = query.list();
        return offerList;
    }
}
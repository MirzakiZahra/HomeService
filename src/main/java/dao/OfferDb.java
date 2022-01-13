package dao;

import model.Offer;
import model.Order;
import model.enums.TypeOfOrder;
import model.user.Customer;
import model.user.Expert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class OfferDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void addOffer(Offer offer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(offer);
        transaction.commit();
        session.close();
    }
}
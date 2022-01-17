package dao;

import model.Offer;
import model.services.SubService;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
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
        String hql = "from Offer ";
        Query query = session.createQuery(hql);
        List<Offer> offerList = query.getResultList();
        transaction.commit();
        session.close();
        return offerList;
    }
    public Offer findOfferById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Offer o where o.id = :id ";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<Offer> offerList = query.getResultList();
        transaction.commit();
        session.close();
        return offerList.get(0);
    }
}
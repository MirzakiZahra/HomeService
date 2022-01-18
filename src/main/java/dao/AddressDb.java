package dao;

import model.Address;
import model.user.Expert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddressDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    public void AddAddress(Address address){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(address);
        transaction.commit();
        session.close();
    }
    public void updateAddress(Address address) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(address);
        transaction.commit();
        session.close();
    }
}

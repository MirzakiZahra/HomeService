package data.repository;

import data.model.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

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
    public Address findAddressById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Address a where a.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<Address> addressList = query.getResultList();
        transaction.commit();
        session.close();
        return addressList.get(0);
    }
}

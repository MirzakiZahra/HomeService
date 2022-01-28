package data.repository;

import data.model.user.Customer;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;


public class CustomerDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void addCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    public void deleteCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        session.close();
    }

    public int checkExistOfCustomer(String username) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Customer s where s.username = :username";
        Query query = session.createQuery(hql);
        query.setParameter("username", username);
        List<Customer> customerList = query.getResultList();
        transaction.commit();
        session.close();
        return customerList.size();
    }

    public int checkExistOfPassword(String password) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Customer s where s.password = :password";
        Query query = session.createQuery(hql);
        query.setParameter("password", password);
        List<Customer> customerList = query.getResultList();
        transaction.commit();
        session.close();
        return customerList.size();
    }

    public List<Customer> findCustomerByEmail(String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Customer s where s.email = :email";
        Query query = session.createQuery(hql);
        query.setParameter("email", email);
        List<Customer> customerList = query.getResultList();
        transaction.commit();
        session.close();
        return customerList;
    }

    public void updateCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
    }


    public List<Customer> showCustomer() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from person where DTYPE =customer";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Customer.class);
        List<Customer> customerList = query.list();
        return customerList;
    }
}

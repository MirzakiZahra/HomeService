package dao;

import model.people.Customer;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import service.CustomerService;


public class CustomerDb {
    CustomerService customerService = new CustomerService();
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void addCustomer(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    public int checkExistOfCustomer(int username) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from customer where username = :username";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Customer.class);
        query.setParameter("username", username);
        int output = (Integer) query.list().size();
        session.close();
        return output;
    }

    public int checkExistOfEmail(String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from customer where email = :email";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Customer.class);
        query.setParameter("email", email);
        int output = query.list().size();
        session.close();
        return output;
    }

    public Customer findCustomerByEmail(String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from customer where email = :email";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Customer.class);
        query.setParameter("email", email);
        Customer customer = (Customer) query.list().get(0);
        session.close();
        return customer;
    }

    public void updateCustomerPassword(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
    }
}

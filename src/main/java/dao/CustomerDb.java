package dao;

import model.user.Customer;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import service.CustomerService;

import java.util.List;


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
        String sql = "select * from customer where username = :username";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Customer.class);
        query.setParameter("username", username);
        int output = (Integer) query.list().size();
        session.close();
        return output;
    }

    public int checkExistOfPassword(String password) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from customer where password = :password";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Customer.class);
        query.setParameter("password", password);
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

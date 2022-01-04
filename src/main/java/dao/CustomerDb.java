package dao;

import entity.Customer;
import entity.Expert;
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

    public int checkExitOfCustomer(int username) {
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

    public Customer findCustomer(int username) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from customer where username= :username";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Customer.class);
        query.setParameter("username", username);
        Customer customer = (Customer) query.list().get(0);
        transaction.commit();
        session.close();
        return customer;


    }

    //  public void changePassword(String password,int username){
    //    Session session = sessionFactory.openSession();
    //  Transaction transaction = session.beginTransaction();
    // customerService.changePassword(password,username);

    //  }
}

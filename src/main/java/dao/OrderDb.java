package dao;

import model.Order;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OrderDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public Order findOrder(int uniqeCode) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String sql = "select * from order where uniqeCode = :uniqeCode";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Order.class);
        query.setParameter("uniqeCode", uniqeCode);
        Order order = (Order) query.list().get(0);
        session.close();
        return order;
    }
    public void addCOrder(Order order) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
    }
}

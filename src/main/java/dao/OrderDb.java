package dao;

import model.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class OrderDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public Order findOrder(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Order s where s.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<Order> orderList = query.getResultList();
        transaction.commit();
        session.close();
        return orderList.get(0);
    }

    public void addCOrder(Order order) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(order);
        transaction.commit();
        session.close();
    }

    public Order findOrderById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Order order = session.load(Order.class, id);
        transaction.commit();
        session.close();
        return order;
    }

    public List<Order> showAllOrder() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Order";
        Query query = session.createQuery(hql);
        List<Order> orderList = query.getResultList();
        transaction.commit();
        session.close();
        return orderList;
    }
    public void updateOrder(Order order){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(order);
        transaction.commit();
        session.close();
    }
}

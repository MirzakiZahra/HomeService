package dao;

import model.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class OrderDb {
    static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public Orders findOrder(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Orders s where s.id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<Orders> ordersList = query.getResultList();
        transaction.commit();
        session.close();
        return ordersList.get(0);
    }

    public void addCOrder(Orders orders) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(orders);
        transaction.commit();
        session.close();
    }

    public Orders findOrderById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Orders orders = session.load(Orders.class, id);
        transaction.commit();
        session.close();
        return orders;
    }

    public List<Orders> showAllOrder() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Orders";
        Query query = session.createQuery(hql);
        List<Orders> ordersList = query.getResultList();
        transaction.commit();
        session.close();
        return ordersList;
    }
    public void updateOrder(Orders orders){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(orders);
        transaction.commit();
        session.close();
    }
    public List<Orders> returnCustomerDoneOrder(int customerId){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Orders o where o.customer = : customerId and o.orderStatus = 'Done'";
        Query query = session.createQuery(hql);
        query.setParameter("customerId", customerId);
        List<Orders> ordersList = query.getResultList();
        transaction.commit();
        session.close();
        return ordersList;
    }
    public List<Orders>allOrdersWithStatusWAITINGFOREXPERTSUGGESTION(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "from Orders o where  o.orderStatus = 'WAITING_FOR_EXPERT_SUGGESTION'";
        Query query = session.createQuery(hql);
        List<Orders> ordersList = query.getResultList();
        transaction.commit();
        session.close();
        return ordersList;
    }
}

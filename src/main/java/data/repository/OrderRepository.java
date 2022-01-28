package data.repository;

import data.model.Orders;
import data.model.services.SubService;
import data.model.user.Expert;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
@Repository
public interface OrderRepository extends CrudRepository<Orders, Integer> {
    Orders findById(int id);
    @Query(value = "select * from Orders", nativeQuery = true)
    List<Orders> findAllOrders();
    @Query(value = "select * from orders where customer_id= :customerId and orderStatus= :Done",nativeQuery = true)
    List<Orders> findOrdersByOrderStatusAndCustomer(@Param("customer_id") int customerId);
    @Query(value = "select * from orders where orderStatus= :WAITING_FOR_EXPERT_SUGGESTION",nativeQuery = true)
    List<Orders> findAllByOrderStatusAndCustomer();
}

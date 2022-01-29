package ir.data.repository;

import ir.data.model.Orders;
import org.springframework.data.jpa.repository.Modifying;
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
    @Query(value = "select * from orders where customer_id= :customerId and orderStatus= 'Done'",nativeQuery = true)
    List<Orders> findOrdersByOrderStatusAndCustomer(@Param("customerId") int customerId);
    @Query(value = "select * from orders where orderStatus= 'WAITING_FOR_EXPERT_SUGGESTION'",nativeQuery = true)
    List<Orders> findAllByOrderStatusAndCustomer();
}

package service;

import dao.CustomerDb;
import dao.OrderDb;
import model.Order;
import model.enums.TypeOfOrder;
import model.user.Customer;

import java.util.Date;

public class OrderService {
    OrderDb orderDb=new OrderDb();
    CustomerDb customerDb = new CustomerDb();
    public void createOrder(int uniqueCode, float cost, String explanation,
                             Date beggingDate, Date endingTime, String address, String email){
        Order order=new Order(uniqueCode,cost,explanation,beggingDate,endingTime,address);
        Customer customer = customerDb.findCustomerByEmail(email);
        order.setCustomer(customer);
        order.setTypeOfOrder(TypeOfOrder.WAITINGFOREXPERTSUGGESTION);
        orderDb.addCOrder(order);
        customer.getOrders().add(order);
        customerDb.updateCustomerCredit(customer);
    }
}

package service;

import dao.CustomerDb;
import dao.OrderDb;
import model.Order;
import model.enums.OrderStatus;
import model.services.SubService;
import model.user.Customer;

import java.util.Date;

public class OrderService {
    OrderDb orderDb = new OrderDb();
    CustomerDb customerDb = new CustomerDb();
    SubServiceService subServiceService = new SubServiceService();

    public void createOrder(float cost, String explanation, Date beggingDate,
                            Date endingTime, String address, String email,int subServiceId) {
        Order order = new Order(cost, explanation, beggingDate, endingTime, address);
        Customer customer = customerDb.findCustomerByEmail(email);
        SubService subService = subServiceService.checkExistOfSubServiceById(subServiceId);
        order.setCustomer(customer);
        order.setSubService(subService);
        order.setOrderStatus(OrderStatus.WAITINGFOREXPERTSUGGESTION);
        orderDb.addCOrder(order);
        customer.getOrders().add(order);
        customerDb.updateCustomerCredit(customer);
    }
}

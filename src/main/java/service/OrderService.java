package service;

import dao.CustomerDb;
import dao.OrderDb;
import dto.OrderDto;
import model.Order;
import model.enums.OrderStatus;
import model.services.SubService;
import model.user.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderService {
    OrderDb orderDb = new OrderDb();
    CustomerDb customerDb = new CustomerDb();
    SubServiceService subServiceService = new SubServiceService();

    public void createOrder(float cost, String explanation, Date beggingDate,
                            Date endingTime, String address, String email, int subServiceId) {
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

    public List<OrderDto> showAllOrder() {
        List<Order> orderList = orderDb.showAllOrder();
        List<OrderDto> orderDtoList = new ArrayList<>();
        for (Order order : orderList) {
            OrderDto orderDto = new OrderDto(order.getId(), order.getPrice(),
                    order.getSubService(), order.getExplanation(), order.getBeggingDate(),
                    order.getEndingTime(), order.getAddress());
            orderDtoList.add(orderDto);
        }
        return orderDtoList;
    }
}

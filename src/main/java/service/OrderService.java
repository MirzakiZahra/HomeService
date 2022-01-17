package service;

import dao.CustomerDb;
import dao.OrderDb;
import dto.OrderDto;
import model.Offer;
import service.mapper.OrderMapper;
import model.Order;
import model.enums.OrderStatus;
import model.services.SubService;
import model.user.Customer;

import java.util.Date;
import java.util.List;

public class OrderService {
    OrderDb orderDb = new OrderDb();
    CustomerDb customerDb = new CustomerDb();
    SubServiceService subServiceService = new SubServiceService();
    OrderMapper orderMapper = new OrderMapper();
    OfferService offerService = new OfferService();

    public void createOrder(float cost, String explanation, Date beggingDate,
                            Date endingTime, String address, String email, int subServiceId) {
        Order order = new Order(cost, explanation, beggingDate, endingTime, address);
        Customer customer = customerDb.findCustomerByEmail(email);
        SubService subService = subServiceService.checkExistOfSubServiceById(subServiceId);
        order.setCustomer(customer);
        order.setSubService(subService);
        order.setOrderStatus(OrderStatus.WAITING_FOR_EXPERT_SUGGESTION);
        orderDb.addCOrder(order);
        customer.getOrders().add(order);
        customerDb.updateCustomer(customer);
    }

    public List<OrderDto> showAllOrder() {
        List<Order> orderList = orderDb.showAllOrder();
        List<OrderDto> orderDtoList = orderMapper.convertOrderToOrderDto(orderList);
        return orderDtoList;
    }
    public OrderDto findOrderById(int id){
        Order order = orderDb.findOrderById(id);
        OrderDto orderDto = orderMapper.convertOrderToOrderDto(order);
        return orderDto;
    }
    public void setOfferForSpecificOrder(int offerId){
        Offer offer = offerService.findOfferById(offerId);
        Order order = offer.getOrder();
        order.setPreferredOffer(offer);
        order.setOrderStatus(OrderStatus.WAITING_FOR_THE_SPECIALIST_TO_ARRIVE);
        orderDb.
    }
}

package service;

import dao.CustomerDb;
import dao.ExpertDb;
import dao.OrderDb;
import dto.OrderDto;
import exception.EnoughCredit;
import model.Offer;
import model.Orders;
import model.enums.OrderStatus;
import model.services.SubService;
import model.user.Customer;
import model.user.Expert;
import service.mapper.OrderMapper;

import java.util.Date;
import java.util.List;

public class OrderService {
    OrderDb orderDb = new OrderDb();
    CustomerDb customerDb = new CustomerDb();
    SubServiceService subServiceService = new SubServiceService();
    OrderMapper orderMapper = new OrderMapper();
    OfferService offerService = new OfferService();
    CustomerService customerService = new CustomerService();
    ExpertDb expertDb = new ExpertDb();
    //  ExpertService expertService=new ExpertService();

    public void createOrder(float cost, String explanation, Date beggingDate,
                            Date endingTime, String address, String email, int subServiceId) {
        Orders orders = new Orders(cost, explanation, beggingDate, endingTime, address);
        Customer customer = customerDb.findCustomerByEmail(email).get(0);
        SubService subService = subServiceService.checkExistOfSubServiceById(subServiceId);
        orders.setCustomer(customer);
        orders.setSubService(subService);
        orders.setOrderStatus(OrderStatus.WAITING_FOR_EXPERT_SUGGESTION);
        orderDb.addCOrder(orders);
        customer.getOrders().add(orders);
        customerDb.updateCustomer(customer);
    }

    public List<OrderDto> showAllOrder() {
        List<Orders> ordersList = orderDb.showAllOrder();
        List<OrderDto> orderDtoList = orderMapper.convertOrderToOrderDto(ordersList);
        return orderDtoList;
    }

    public OrderDto findOrderById(int id) {
        Orders orders = orderDb.findOrderById(id);
        OrderDto orderDto = orderMapper.convertOrderToOrderDto(orders);
        return orderDto;
    }

    public void setOfferForSpecificOrder(int offerId) {
        Offer offer = offerService.findOfferById(offerId);
        Orders orders = offer.getOrders();
        orders.setPreferredOffer(offer);
        orders.setOrderStatus(OrderStatus.WAITING_FOR_THE_SPECIALIST_TO_ARRIVE);
        orderDb.updateOrder(orders);
    }

    public List<OrderDto> customerDoneOrder(int customerId) {
        List<Orders> ordersList = orderDb.returnCustomerDoneOrder(customerId);
        List<OrderDto> orderDtoList = orderMapper.convertOrderToOrderDto(ordersList);
        return orderDtoList;
    }

    public Orders findOrderByIdReturnOrder(int id) {
        return orderDb.findOrderById(id);
    }

    public void changeOrderStatus(OrderStatus orderStatus, int orderId) {
        Orders orders = findOrderByIdReturnOrder(orderId);
        orders.setOrderStatus(orderStatus);
        orderDb.updateOrder(orders);
    }

    public void transferMoney(int orderId, String expertEmail) {
        Orders orders = findOrderByIdReturnOrder(orderId);
        Customer customer = orders.getCustomer();
        if (customer.getCredit() >= orders.getPrice()) {
            customerService.withdrawCreditOfCustomer(customer.getEmail(), orders.getPrice());
            Expert expert = expertDb.findExpertByEmail(expertEmail).get(0);
            float temp = expert.getCreditExpert() + orders.getPrice();
            expert.setCreditExpert(temp);
            expertDb.updateExpert(expert);
        } else {
            throw new EnoughCredit("Not Enough Money");
        }
    }
}

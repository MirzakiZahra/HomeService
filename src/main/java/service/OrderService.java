package service;

import dao.CustomerDb;
import dao.OrderDb;
import dto.OrderDto;
import exception.EnoughCredit;
import model.Offer;
import model.Order;
import model.enums.OrderStatus;
import model.services.SubService;
import model.user.Customer;
import service.mapper.OrderMapper;

import java.util.Date;
import java.util.List;

public class OrderService {
    OrderDb orderDb = new OrderDb();
    CustomerDb customerDb = new CustomerDb();
    SubServiceService subServiceService = new SubServiceService();
    OrderMapper orderMapper = new OrderMapper();
    OfferService offerService = new OfferService();
    CustomerService customerService=new CustomerService();
    ExpertService expertService=new ExpertService();

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

    public OrderDto findOrderById(int id) {
        Order order = orderDb.findOrderById(id);
        OrderDto orderDto = orderMapper.convertOrderToOrderDto(order);
        return orderDto;
    }

    public void setOfferForSpecificOrder(int offerId) {
        Offer offer = offerService.findOfferById(offerId);
        Order order = offer.getOrder();
        order.setPreferredOffer(offer);
        order.setOrderStatus(OrderStatus.WAITING_FOR_THE_SPECIALIST_TO_ARRIVE);
        orderDb.updateOrder(order);
    }

    public List<OrderDto> customerDoneOrder(int customerId) {
        List<Order> orderList = orderDb.returnCustomerDoneOrder(customerId);
        List<OrderDto> orderDtoList = orderMapper.convertOrderToOrderDto(orderList);
        return orderDtoList;
    }

    public Order findOrderByIdReturnOrder(int id) {
        return orderDb.findOrderById(id);
    }

    public void changeOrderStatus(OrderStatus orderStatus, int orderId) {
        Order order = findOrderByIdReturnOrder(orderId);
        order.setOrderStatus(orderStatus);
        orderDb.updateOrder(order);
    }
    public void transferMoney(int orderId,String expertEmail,float money){
        Order order = findOrderByIdReturnOrder(orderId);
      Customer customer=  order.getCustomer();
      if(customer.getCredit()<=money){
          customerService.withdrawCreditOfCustomer(customer.getEmail(),money);
          expertService.addMoneyForExpert(expertEmail,money);

      }
      else {
          throw new EnoughCredit("Not Enough Money");
      }
    }
}

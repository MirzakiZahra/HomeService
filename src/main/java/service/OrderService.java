package service;

import data.repository.CustomerRepository;
import data.repository.ExpertRepository;
import data.repository.OrderRepository;
import data.dto.OrderDto;
import exception.EnoughCredit;
import data.model.Offer;
import data.model.Orders;
import data.model.enums.OrderStatus;
import data.model.enums.TypeOfTransaction;
import data.model.services.SubService;
import data.model.user.Customer;
import data.model.user.Expert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.mapper.OrderMapper;

import java.util.Date;
import java.util.List;
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository = new OrderRepository();
    CustomerRepository customerRepository;
    SubServiceService subServiceService = new SubServiceService();
    OrderMapper orderMapper = new OrderMapper();
    OfferService offerService = new OfferService();
    CustomerService customerService = new CustomerService();
    ExpertRepository expertRepository;
    TransactionService transactionService = new TransactionService();

    public void createOrder(float cost, String explanation, Date beggingDate,
                            Date endingTime, String address, String email, int subServiceId) {
        Orders orders = new Orders(cost, explanation, beggingDate, endingTime, address);
        Customer customer = customerRepository.findAllByEmail(email).get(0);
        SubService subService = subServiceService.checkExistOfSubServiceById(subServiceId);
        orders.setCustomer(customer);
        orders.setSubService(subService);
        orders.setOrderStatus(OrderStatus.WAITING_FOR_EXPERT_SUGGESTION);
        orderRepository.addCOrder(orders);
        customer.getOrders().add(orders);
        customerRepository.save(customer);
    }

    public List<OrderDto> showAllOrder() {
        List<Orders> ordersList = orderRepository.showAllOrder();
        List<OrderDto> orderDtoList = orderMapper.convertOrderToOrderDto(ordersList);
        return orderDtoList;
    }

    public OrderDto findOrderById(int id) {
        Orders orders = orderRepository.findOrderById(id);
        OrderDto orderDto = orderMapper.convertOrderToOrderDto(orders);
        return orderDto;
    }

    public void setOfferForSpecificOrder(int offerId) {
        Offer offer = offerService.findOfferById(offerId);
        Orders orders = offer.getOrders();
        orders.setPreferredOffer(offer);
        orders.setOrderStatus(OrderStatus.WAITING_FOR_THE_SPECIALIST_TO_ARRIVE);
        orderRepository.updateOrder(orders);
    }

    public List<OrderDto> customerDoneOrder(int customerId) {
        List<Orders> ordersList = orderRepository.returnCustomerDoneOrder(customerId);
        List<OrderDto> orderDtoList = orderMapper.convertOrderToOrderDto(ordersList);
        return orderDtoList;
    }

    public Orders findOrderByIdReturnOrder(int id) {
        return orderRepository.findOrderById(id);
    }

    public void changeOrderStatus(OrderStatus orderStatus, int orderId) {
        Orders orders = findOrderByIdReturnOrder(orderId);
        orders.setOrderStatus(orderStatus);
        orderRepository.updateOrder(orders);
    }

    public void transferMoney(int orderId, String expertEmail) {
        Orders orders = findOrderByIdReturnOrder(orderId);
        Customer customer = orders.getCustomer();
        if (customer.getCredit() >= orders.getPrice()) {
            customerService.withdrawCreditOfCustomer(customer.getEmail(), orders.getPrice());
            Expert expert = expertRepository.findAllByEmail(expertEmail).get(0);
            float temp = expert.getCreditExpert() + orders.getPrice();
            expert.setCreditExpert(temp);
            expertRepository.save(expert);
            transactionService.createTransaction(orders, TypeOfTransaction.DEPOSIT);
            transactionService.createTransaction(orders,TypeOfTransaction.WITHDRAW);
        } else {
            throw new EnoughCredit("Not Enough Money");
        }
    }
}

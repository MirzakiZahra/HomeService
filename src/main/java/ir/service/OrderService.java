package ir.service;

import ir.data.repository.CustomerRepository;
import ir.data.repository.ExpertRepository;
import ir.data.repository.OrderRepository;
import ir.data.dto.OrderDto;
import ir.exception.EnoughCredit;
import ir.data.model.Offer;
import ir.data.model.Orders;
import ir.data.model.enums.OrderStatus;
import ir.data.model.enums.TypeOfTransaction;
import ir.data.model.services.SubService;
import ir.data.model.user.Customer;
import ir.data.model.user.Expert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ir.service.mapper.OrderMapper;

import java.util.Date;
import java.util.List;
@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository ;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    SubServiceService subServiceService;
    OrderMapper orderMapper = new OrderMapper();
    @Autowired
    OfferService offerService ;
    CustomerService customerService ;
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
        orderRepository.save(orders);
        customer.getOrders().add(orders);
        customerRepository.save(customer);
    }

    public List<OrderDto> showAllOrder() {
        List<Orders> ordersList = orderRepository.findAllOrders();
        List<OrderDto> orderDtoList = orderMapper.convertOrderToOrderDto(ordersList);
        return orderDtoList;
    }

    public OrderDto findOrderById(int id) {
        Orders orders = orderRepository.findById(id);
        OrderDto orderDto = orderMapper.convertOrderToOrderDto(orders);
        return orderDto;
    }

    public void setOfferForSpecificOrder(int offerId) {
        Offer offer = offerService.findOfferById(offerId);
        Orders orders = offer.getOrders();
        orders.setPreferredOffer(offer);
        orders.setOrderStatus(OrderStatus.WAITING_FOR_THE_SPECIALIST_TO_ARRIVE);
        orderRepository.save(orders);
    }

    public List<OrderDto> customerDoneOrder(int customerId) {
        List<Orders> ordersList = orderRepository.findOrdersByOrderStatusAndCustomer(customerId);
        List<OrderDto> orderDtoList = orderMapper.convertOrderToOrderDto(ordersList);
        return orderDtoList;
    }

    public Orders findOrderByIdReturnOrder(int id) {
        return orderRepository.findById(id);
    }

    public void changeOrderStatus(OrderStatus orderStatus, int orderId) {
        Orders orders = findOrderByIdReturnOrder(orderId);
        orders.setOrderStatus(orderStatus);
        orderRepository.save(orders);
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

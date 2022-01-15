package model.builder;

import model.Offer;
import model.Order;
import model.Transaction;
import model.enums.OrderStatus;
import model.services.SubService;
import model.user.Customer;

import java.util.Date;
import java.util.List;

public class OrderBuilder {
    private Order order = new Order();

    public static OrderBuilder getBuilder() {
        return new OrderBuilder();
    }

    public Order build() {
        return order;
    }

    public OrderBuilder withPrice(float price) {
        order.setPrice(price);
        return this;
    }

    public OrderBuilder withCustomer(Customer customer) {
        order.setCustomer(customer);
        return this;
    }

    public OrderBuilder withSubService(SubService subService) {
        order.setSubService(subService);
        return this;
    }

    public OrderBuilder withTransactionList(List<Transaction> transactionList) {
        order.setTransactionList(transactionList);
        return this;
    }

    public OrderBuilder withOrderStatus(OrderStatus orderStatus) {
        order.setOrderStatus(orderStatus);
        return this;
    }

    public OrderBuilder withExplanation(String explanation) {
        order.setExplanation(explanation);
        return this;
    }

    public OrderBuilder withBeggingDate(Date beggingDate) {
        order.setBeggingDate(beggingDate);
        return this;
    }

    public OrderBuilder withEndingTime(Date endingTime) {
        order.setEndingTime(endingTime);
        return this;
    }

    public OrderBuilder withAddress(String address) {
        order.setAddress(address);
        return this;
    }

    public OrderBuilder withOfferList(List<Offer> offerList) {
        order.setOfferList(offerList);
        return this;
    }
}

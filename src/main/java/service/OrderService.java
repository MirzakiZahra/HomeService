package service;

import dao.OrderDb;
import model.Order;

import java.util.Date;

public class OrderService {
    OrderDb orderDb=new OrderDb();
    public void createOrder(int uniqeCode, float cost, String explaintion,
                             Date beggingDate, Date endingTime, String address){
        Order order=new Order(uniqeCode,cost,explaintion,beggingDate,endingTime,address);
        orderDb.addCOrder(order);

    }
}

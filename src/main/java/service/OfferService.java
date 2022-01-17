package service;

import dao.ExpertDb;
import dao.OfferDb;
import dao.OrderDb;
import model.Offer;
import model.Order;
import model.enums.OrderStatus;
import model.user.Expert;

import java.util.Date;

public class OfferService {
    ExpertDb expertDb = new ExpertDb();
    OfferDb offerDb = new OfferDb();
    OrderDb orderDb = new OrderDb();

    public void createOffer(float price, int orderId, float basePrice,
                            Date creationDate, Date startDate, String email) {
        Expert expert = expertDb.findExpertByEmail(email);
        Order order = orderDb.findOrderById(orderId);
        order.setOrderStatus(OrderStatus.WAITING_FOR_SPECIALIST_SELECTION);
        Offer offer = new Offer(price, expert, order, creationDate, startDate);
        offerDb.addOffer(offer);
    }
}

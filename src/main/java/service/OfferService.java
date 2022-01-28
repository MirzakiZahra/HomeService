package service;

import data.repository.ExpertDb;
import data.repository.OfferDb;
import data.repository.OrderDb;
import data.model.Offer;
import data.model.Orders;
import data.model.enums.OrderStatus;
import data.model.user.Expert;

import java.util.Date;

public class OfferService {
    ExpertDb expertDb = new ExpertDb();
    OfferDb offerDb = new OfferDb();
    OrderDb orderDb = new OrderDb();

    public void createOffer(float price, int orderId, float basePrice,
                            Date creationDate, Date startDate, String email) {
        Expert expert = expertDb.findExpertByEmail(email).get(0);
        Orders orders = orderDb.findOrderById(orderId);
        orders.setOrderStatus(OrderStatus.WAITING_FOR_SPECIALIST_SELECTION);
        Offer offer = new Offer(price, expert, orders, creationDate, startDate);
        offerDb.addOffer(offer);

    }
    public Offer findOfferById(int id){
        return offerDb.findOfferById(id);
    }
}

package service;

import data.repository.ExpertRepository;
import data.repository.OfferRepository;
import data.repository.OrderRepository;
import data.model.Offer;
import data.model.Orders;
import data.model.enums.OrderStatus;
import data.model.user.Expert;

import java.util.Date;

public class OfferService {
    ExpertRepository expertRepository = new ExpertRepository();
    OfferRepository offerRepository = new OfferRepository();
    OrderRepository orderRepository = new OrderRepository();

    public void createOffer(float price, int orderId, float basePrice,
                            Date creationDate, Date startDate, String email) {
        Expert expert = expertRepository.findExpertByEmail(email).get(0);
        Orders orders = orderRepository.findOrderById(orderId);
        orders.setOrderStatus(OrderStatus.WAITING_FOR_SPECIALIST_SELECTION);
        Offer offer = new Offer(price, expert, orders, creationDate, startDate);
        offerRepository.addOffer(offer);

    }
    public Offer findOfferById(int id){
        return offerRepository.findOfferById(id);
    }
}

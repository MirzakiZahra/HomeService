package service;

import data.repository.ExpertRepository;
import data.repository.OfferRepository;
import data.repository.OrderRepository;
import data.model.Offer;
import data.model.Orders;
import data.model.enums.OrderStatus;
import data.model.user.Expert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class OfferService {
    @Autowired
    ExpertRepository expertRepository;
    OfferRepository offerRepository;
    OrderRepository orderRepository = new OrderRepository();

    public void createOffer(float price, int orderId, float basePrice,
                            Date creationDate, Date startDate, String email) {
        Expert expert = expertRepository.findAllByEmail(email).get(0);
        Orders orders = orderRepository.findOrderById(orderId);
        orders.setOrderStatus(OrderStatus.WAITING_FOR_SPECIALIST_SELECTION);
        Offer offer = new Offer(price, expert, orders, creationDate, startDate);
        offerRepository.save(offer);

    }
    public Offer findOfferById(int id){
        return offerRepository.findOfferById(id);
    }
}

package ir.service;

import ir.data.dto.OfferDto;
import ir.data.model.Offer;
import ir.data.model.Orders;
import ir.data.model.enums.OrderStatus;
import ir.data.model.user.Expert;
import ir.data.repository.ExpertRepository;
import ir.data.repository.OfferRepository;
import ir.data.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OfferService {

    private OfferRepository offerRepository;

    @Autowired
    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Autowired
    ExpertRepository expertRepository;
    @Autowired
    OrderRepository orderRepository;

    public void createOffer(float price, int orderId, float basePrice,
                            Date creationDate, Date startDate, String email) {
        Expert expert = expertRepository.findAllByEmail(email).get(0);
        Orders orders = orderRepository.findById(orderId);
        orders.setOrderStatus(OrderStatus.WAITING_FOR_SPECIALIST_SELECTION);
        Offer offer = new Offer(price, expert, orders, creationDate, startDate);
        offerRepository.save(offer);

    }

    public Offer findOfferById(int id) {
        return offerRepository.findOfferById(id);
    }
}

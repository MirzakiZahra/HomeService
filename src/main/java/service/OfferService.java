package service;

import dao.ExpertDb;
import model.Offer;
import model.Order;
import model.user.Expert;

import java.util.Date;

public class OfferService {
    ExpertDb expertDb = new ExpertDb();
    public void createOffer(float price, Expert expert, Order order,
                            Date creationDate, Date startDate, String email){
        expert = expertDb.findExpertByEmail(email);
        Offer offer =new Offer(price expert,order,creationDate,startDate);


    }
}

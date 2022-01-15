package model;

import lombok.Builder;
import lombok.Data;
import model.enums.OrderStatus;
import model.services.SubService;
import model.user.Customer;

import javax.management.ConstructorParameters;
import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float price;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private SubService subService;
    @OneToMany(mappedBy = "order")
    private List<Transaction> transactionList;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;
    private String explanation;
    private Date beggingDate;
    private Date endingTime;
    private String address;
    @OneToMany(mappedBy = "order")
    private List<Offer> offerList;

    public Order() {
    }

    public Order(float cost, String explanation, Date beggingDate, Date endingTime, String address) {
        this.price = cost;
        this.explanation = explanation;
        this.beggingDate = beggingDate;
        this.endingTime = endingTime;
        this.address = address;
    }
}

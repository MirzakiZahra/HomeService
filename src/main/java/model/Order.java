package model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.enums.OrderStatus;
import model.services.SubService;
import model.user.Customer;
import org.hibernate.annotations.CreationTimestamp;

import javax.management.ConstructorParameters;
import javax.persistence.*;
import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
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
    private List<Transaction> transactionList = new ArrayList<>();
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;
    private String explanation;
    @CreationTimestamp
    private Date beggingDate;
    @CreationTimestamp
    private Date endingTime;
    private String address;
    @OneToMany(mappedBy = "order")
    private List<Offer> offerList= new ArrayList<>();
    @OneToOne
    private Offer preferredOffer;

    public Order(float cost, String explanation, Date beggingDate, Date endingTime, String address) {
        this.price = cost;
        this.explanation = explanation;
        this.beggingDate = beggingDate;
        this.endingTime = endingTime;
        this.address = address;
    }
}

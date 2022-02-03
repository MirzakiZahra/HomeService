package ir.data.model;

import ir.data.model.enums.OrderStatus;
import ir.data.model.services.SubService;
import ir.data.model.user.Customer;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float price;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private SubService subService;
    @OneToMany(mappedBy = "orders", fetch = FetchType.LAZY)
    private List<Transaction> transactionList = new ArrayList<>();
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;
    private String explanation;
    @Temporal(TemporalType.TIMESTAMP)
    private Date beggingDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date endingTime;
    private String address;
    @OneToMany(mappedBy = "orders", fetch = FetchType.EAGER)
    private List<Offer> offerList = new ArrayList<>();
    @OneToOne
    private Offer preferredOffer;
    private boolean getScore = false;

    @Builder
    public Orders(float cost, String explanation, Date beggingDate, Date endingTime, String address) {
        this.price = cost;
        this.explanation = explanation;
        this.beggingDate = beggingDate;
        this.endingTime = endingTime;
        this.address = address;
    }
}

package model;

import lombok.Data;
import model.services.SubService;
import model.user.Customer;
import model.user.Expert;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private int uniqueCode;
    private float price;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Expert expert;
    @ManyToOne
    private SubService subService;
    @OneToMany(mappedBy = "order")
    private List<Transaction> transactionList;
    private String explaintion;
    private Date beggingDate;
    private Date endingTime;
    private String address;
    public Order() {
    }

    public Order(int uniqeCode, float cost, String explaintion, Date beggingDate, Date endingTime, String address) {
        this.uniqueCode = uniqeCode;
        this.price = cost;
        this.explaintion = explaintion;
        this.beggingDate = beggingDate;
        this.endingTime = endingTime;
        this.address = address;
    }
}

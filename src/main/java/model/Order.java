package model;

import lombok.Data;
import model.user.Customer;
import model.user.Expert;

import javax.persistence.*;
import java.util.Date;
@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private int uniqueCode;
    private float cost;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Expert expert;
    private String explaintion;
    private Date beggingDate;
    private Date endingTime;
    private String address;

    public Order() {
    }

    public Order(int uniqeCode, float cost, String explaintion, Date beggingDate, Date endingTime, String address) {
        this.uniqueCode = uniqeCode;
        this.cost = cost;
        this.explaintion = explaintion;
        this.beggingDate = beggingDate;
        this.endingTime = endingTime;
        this.address = address;
    }
}

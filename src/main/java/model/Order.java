package model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int uniqeCode;
    private float cost;
    private String explaintion;
    private Date beggingDate;
    private Date endingTime;
    private String address;

    public Order() {
    }

    public Order(int uniqeCode, float cost, String explaintion, Date beggingDate, Date endingTime, String address) {
        this.uniqeCode = uniqeCode;
        this.cost = cost;
        this.explaintion = explaintion;
        this.beggingDate = beggingDate;
        this.endingTime = endingTime;
        this.address = address;
    }
}

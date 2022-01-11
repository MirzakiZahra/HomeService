package model.user;


import lombok.Data;
import model.Order;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

import model.enums.UserStatue;
@Entity
@Data
public class Customer extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String address;
    private String email;
    @Temporal(TemporalType.TIME)
    @CreationTimestamp
    private Date beginningTime;
    private String password;
    private int username;
    private float credit;
    @Enumerated(EnumType.STRING)
    UserStatue userStatue;
    @OneToMany
    private List<Order>orders;


    public Customer(String address, String email, String password) {
        this.address = address;
        this.email = email;
        this.password = password;
    }
    public Customer(){}

    public Customer(String firstName, String lastName, String address, String email, String password) {
        super(firstName, lastName);
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public Customer(String firstName, String lastName, String address, String email, Date beginningTime, String password, int username) {
        super(firstName, lastName);
        this.address = address;
        this.email = email;
        this.beginningTime = beginningTime;
        this.password = password;
        this.username = username;
    }
}

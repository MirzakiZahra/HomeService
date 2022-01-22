package model.user;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Address;
import model.Order;
import model.enums.UserStatus;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor

public class Customer extends Person {
    @OneToMany
    private List<Address>  address;
    @Temporal(TemporalType.TIME)
    @CreationTimestamp
    private Date registerTime;
    private float credit;
    @Enumerated(EnumType.STRING)
    UserStatus userStatue;
    @OneToMany
    private List<Order> orders = new ArrayList<>();
    public Customer(String firstName, String lastName, String email, String password, List<Address> address) {
        super(firstName, lastName, email, password);
        this.address = address;
    }
    @Builder
    public Customer(Date registerTime,float credit) {
        this.credit=credit;
        this.registerTime=registerTime;
    }


}

package model.user;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Address;
import model.Orders;
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
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Address>  address;
    @Temporal(TemporalType.TIME)
    @CreationTimestamp
    private Date registerTime;
    private float credit;
    @Enumerated(EnumType.STRING)
    UserStatus userStatue;
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<Orders> orders = new ArrayList<>();
    @Builder
    public Customer(String firstName, String lastName, String email, String password, List<Address> address) {
        super(firstName, lastName, email, password);
        this.address = address;
    }
    public Customer(Date registerTime,float credit) {
        this.credit=credit;
        this.registerTime=registerTime;
    }


}

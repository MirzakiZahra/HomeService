package model.user;


import lombok.Data;
import lombok.NoArgsConstructor;
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
    private String address;
    @Temporal(TemporalType.TIME)
    @CreationTimestamp
    private Date beginningTime;
    private float credit;
    @Enumerated(EnumType.STRING)
    UserStatus userStatue;
    @OneToMany
    private List<Order> orders = new ArrayList<>();
    public Customer( String firstName, String lastName, String email, String password,  String address) {
        super( firstName, lastName, email, password);
        this.address = address;

    }

}

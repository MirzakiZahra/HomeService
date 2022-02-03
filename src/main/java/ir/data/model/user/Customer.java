package ir.data.model.user;


import ir.data.model.Address;
import ir.data.model.Orders;
import ir.data.model.enums.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class Customer extends Person {
    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Address> address;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date registerTime;
    private float credit;
    @Enumerated(EnumType.STRING)
    UserStatus userStatue;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@Fetch(value = FetchMode.SUBSELECT)
    private Set<Orders> orders = new HashSet<>();

    @Builder
    public Customer(String firstName, String lastName, String email, String password, List<Address> address) {
        super(firstName, lastName, email, password);
        this.address = address;
    }

    public Customer(Date registerTime, float credit) {
        this.credit = credit;
        this.registerTime = registerTime;
    }


}

package model.user;

import lombok.Data;
import model.Order;
import model.services.MainService;
import model.services.SubService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Expert extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String email;
    private int score;
    @ManyToMany
    private List<SubService> subServiceList ;
    @OneToMany(mappedBy = "expert")
    private List<Order> orderList;
    private float creditExpert;
    private int countOfOrder;

    public Expert() {

    }

    public Expert(String firstName, String lastName, String email) {
        super(firstName, lastName);
        this.email = email;

    }

}

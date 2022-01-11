package model.services;

import lombok.Data;
import model.Order;
import model.user.Expert;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class SubService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    private String description;
    private float price;
    @ManyToOne
    private MainService mainService;
    @ManyToMany
    private Set<Expert> expertSet;
    @OneToMany(mappedBy = "subService")
    private Set<Order> orderSet;
}

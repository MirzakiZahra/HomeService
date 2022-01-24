package model.services;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Orders;
import model.user.Expert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class SubService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@Column(unique = true)
    private String name;
    private String description;
    private float price;
    @ManyToOne
    private MainService mainService;
    @ManyToMany
    private Set<Expert> expertSet = new HashSet<>();
    @OneToMany(mappedBy = "subService" ,fetch = FetchType.LAZY)
    private Set<Orders> ordersSet = new HashSet<>();
    @Builder
    public SubService(String name, String description, float price, MainService mainService) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.mainService = mainService;
    }
}

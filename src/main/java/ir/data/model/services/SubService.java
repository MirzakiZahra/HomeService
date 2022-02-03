package ir.data.model.services;

import ir.data.model.Orders;
import ir.data.model.user.Expert;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class SubService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //@Column(unique = true)
    private String name;
    private String description;
    private float basePrice;
    @ManyToOne
    private MainService mainService;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Expert> expertSet = new HashSet<>();
    @OneToMany(mappedBy = "subService", fetch = FetchType.LAZY)
    private Set<Orders> ordersSet = new HashSet<>();

    @Builder
    public SubService(String name, String description, float price, MainService mainService) {
        this.name = name;
        this.description = description;
        this.basePrice = price;
        this.mainService = mainService;
    }
}

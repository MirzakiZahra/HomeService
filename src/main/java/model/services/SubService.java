package model.services;

import lombok.Data;

import javax.persistence.*;

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
}

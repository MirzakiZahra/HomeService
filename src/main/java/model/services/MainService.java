package model.services;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class MainService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private float price;


}

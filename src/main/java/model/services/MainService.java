package model.services;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class MainService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mainService")
    private Set<SubService> subServiceSet;


}

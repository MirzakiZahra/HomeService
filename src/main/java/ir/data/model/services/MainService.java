package ir.data.model.services;


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
public class MainService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String name;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "mainService")
    private Set<SubService> subServiceSet = new HashSet<>();

    public MainService(String name) {
        this.name = name;
    }
}

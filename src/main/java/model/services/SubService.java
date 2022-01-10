package model.services;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SubService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private MainService mainService;
}

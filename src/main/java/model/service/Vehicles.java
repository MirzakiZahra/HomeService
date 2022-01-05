package model.service;

import enums.TypeOfService;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vehicles extends HomeServices{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    TypeOfService typeOfService;
}

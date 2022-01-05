package model.service;

import enums.TypeOfService;
import lombok.Data;
import model.people.Expert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Vehicles extends HomeServices{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    TypeOfService typeOfService;
    @Transient
    private static List<TypeOfService> type=new ArrayList<>();
    @ManyToMany
    private List<Expert> expertList=new ArrayList<>();
}

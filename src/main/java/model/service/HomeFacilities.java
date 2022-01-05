package model.service;

import enums.TypeOfService;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class HomeFacilities extends HomeServices{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    TypeOfService typeOfService;
    @Transient
    private static List<TypeOfService>type=new ArrayList<>();
}

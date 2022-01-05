package model.services;

import enums.TypeOfServices;
import lombok.Data;
import model.people.Expert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
public class HomeAppliances extends HomeServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    TypeOfServices typeOfService;
    @Transient
    private static List<TypeOfServices> type = Arrays.asList(TypeOfServices.WASHING,
            TypeOfServices.AUDIOACCESSORIES, TypeOfServices.KITCHENAPPLIANCE);
    @ManyToMany
    private List<Expert> expertList=new ArrayList<>();
}

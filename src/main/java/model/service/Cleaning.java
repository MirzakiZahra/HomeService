package model.service;

import enums.TypeOfService;
import lombok.Data;
import model.people.Expert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
public class Cleaning extends HomeServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    TypeOfService typeOfService;
    @Transient
    private static List<TypeOfService> type = Arrays.asList(TypeOfService.CLEAN, TypeOfService.LAUNDRY,
            TypeOfService.HOMESPRAYIN, TypeOfService.CARPETCLEANING, TypeOfService.WASHINGTHESOFA);
    @ManyToMany
    private List<Expert> expertList=new ArrayList<>();
}

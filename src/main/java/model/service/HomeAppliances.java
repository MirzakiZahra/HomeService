package model.service;

import enums.TypeOfService;
import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

@Entity
@Data
public class HomeAppliances extends HomeServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    TypeOfService typeOfService;
    @Transient
    private static List<TypeOfService> type = Arrays.asList(TypeOfService.WASHING,
            TypeOfService.AUDIOACCESSORIES, TypeOfService.KITCHENAPPLIANCE);
}

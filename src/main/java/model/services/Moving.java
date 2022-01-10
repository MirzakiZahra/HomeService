package model.services;

import enums.TypeOfServices;
import lombok.Data;
import model.user.Expert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Moving extends HomeServices{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    TypeOfServices typeOfService;
    @Transient
    private static List<TypeOfServices> type=new ArrayList<>();
    @ManyToMany
    private List<Expert> expertList=new ArrayList<>();
}

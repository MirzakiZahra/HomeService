package model.service;


import lombok.Data;

import model.people.Expert;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class HomeServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;


}

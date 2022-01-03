package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class HomeServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    List<Expert>experts=new ArrayList<>();

}

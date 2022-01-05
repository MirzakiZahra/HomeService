package model.people;

import lombok.Data;
import model.service.HomeServices;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Expert extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private int score;
    @ManyToMany
    List<HomeServices> homeServices = new ArrayList<>();

    public Expert() {

    }

    public Expert(String firstName, String lastName, String email) {
        super(firstName, lastName);
        this.email = email;

    }

}

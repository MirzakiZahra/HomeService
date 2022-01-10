package model.user;

import lombok.Data;
import model.services.HomeServices;

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
    private float creditExpert;
    private int countOfOrder;

    public Expert() {

    }

    public Expert(String firstName, String lastName, String email) {
        super(firstName, lastName);
        this.email = email;

    }

}

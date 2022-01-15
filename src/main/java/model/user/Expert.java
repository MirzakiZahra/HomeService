package model.user;

import lombok.Data;
import model.Offer;
import model.services.SubService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Expert extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Lob
    @Column(name = "photo", columnDefinition = "BLOB", length = 300000)
    private byte[] photo;
    @Column(unique = true)
    private String email;
    private float score;
    @ManyToMany
    private List<SubService> subServiceList = new ArrayList<>();
    @OneToMany
    private List<Offer> offerList = new ArrayList<>();
    private float creditExpert;
    private int countOfOrder = 0;

    public Expert() {

    }

    public Expert(String firstName, String lastName, String email) {
        super(firstName, lastName);
        this.email = email;

    }

}

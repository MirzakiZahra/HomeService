package model.user;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Offer;
import model.services.SubService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
public class Expert extends Person {
    @Lob
    @Column(name = "photo", columnDefinition = "BLOB", length = 300000)
    private byte[] photo;
    private float score;
    @ManyToMany
    private List<SubService> subServiceList = new ArrayList<>();
    @OneToMany
    private List<Offer> offerList = new ArrayList<>();
    private float creditExpert;
    private int countOfOrder = 0;
    public Expert(String firstName, String lastName, String email) {
        super(firstName, lastName);
    }

}

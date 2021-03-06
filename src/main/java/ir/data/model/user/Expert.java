package ir.data.model.user;

import ir.data.model.Offer;
import ir.data.model.services.SubService;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor

public class Expert extends Person {
    @Lob
    @Column(name = "photo", columnDefinition = "BLOB", length = 300000)
    private byte[] photo;
    private float score;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<SubService> subServiceList = new ArrayList<>();
    @OneToMany(mappedBy = "expert", fetch = FetchType.LAZY)
    private List<Offer> offerList = new ArrayList<>();
    private float creditExpert;
    private int countOfOrder = 0;

    @Builder
    public Expert(String firstName, String lastName, String email, float score,
                  float creditExpert, List<SubService> subServiceList) {
        super(firstName, lastName);
        this.creditExpert = creditExpert;
        this.subServiceList = subServiceList;
    }

    public Expert(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }
}

package model;

import lombok.Data;
import model.user.Expert;

import javax.persistence.*;

@Entity
@Data
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float price;
    @ManyToOne
    private Expert expert;
    @OneToOne
    private Order order;


}

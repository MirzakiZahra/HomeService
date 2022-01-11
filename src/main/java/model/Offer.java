package model;

import lombok.Data;
import model.user.Expert;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float price;
    @ManyToOne
    private Expert expert;
    @ManyToOne
    private Order order;
    @CreationTimestamp
    private Date creationDate;
    @CreationTimestamp
    private Date startDate;


}

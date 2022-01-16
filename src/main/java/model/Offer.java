package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.user.Expert;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
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
    @Temporal(TemporalType.TIME)
    private Date startDate;
    private String explanation;
    @CreationTimestamp
    private Date durationOfWork;
    public Offer(float price, Expert expert, Order order, Date creationDate, Date startDate) {
        this.price = price;
        this.expert = expert;
        this.order = order;
        this.creationDate = creationDate;
        this.startDate = startDate;
    }
}

package model;

import lombok.Builder;
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
    private Orders orders;
    @CreationTimestamp
    private Date creationDate;
    @Temporal(TemporalType.TIME)
    private Date startDate;
    private String explanation;
    @CreationTimestamp
    private Date durationOfWork;
    @Builder
    public Offer(float price, Expert expert, Orders orders, Date creationDate, Date startDate) {
        this.price = price;
        this.expert = expert;
        this.orders = orders;
        this.creationDate = creationDate;
        this.startDate = startDate;
    }
}

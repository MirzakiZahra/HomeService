package ir.data.model;

import lombok.*;
import ir.data.model.user.Expert;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    private String explanation;
    @Temporal(TemporalType.TIME)
    private Date durationOfWork;
    @Builder
    public Offer(float price, Expert expert, Orders orders, Date creationDate, Date startDate) {
        this.price = price;
        this.expert = expert;
        this.orders = orders;
        this.creationDate = creationDate;
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", price=" + price +
                ", creationDate=" + creationDate +
                ", startDate=" + startDate +
                ", explanation='" + explanation + '\'' +
                ", durationOfWork=" + durationOfWork +
                '}';
    }
}

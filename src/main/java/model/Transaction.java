package model;

import lombok.Data;
import model.enums.TypeOfTransaction;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @CreationTimestamp
    private Date date;
    private float fee;
    @Enumerated(value = EnumType.STRING)
    private TypeOfTransaction typeOfTransaction;


}

package model;

import lombok.Data;
import lombok.NoArgsConstructor;
import model.user.Customer;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String city;
    private String country;
    private String plaque;
    private String street;
    @ManyToOne
    private Customer customer;

}

package ir.data.model;

import ir.data.model.user.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String city;
    private String country;
    private String plaque;
    private String street;
    @ManyToOne(cascade = CascadeType.ALL)
    private Customer customer;

}

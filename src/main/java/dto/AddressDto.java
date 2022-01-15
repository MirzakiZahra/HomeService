package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.user.Customer;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
    private int id;
    private String city;
    private String country;
    private int plaque;
    private String street;
}

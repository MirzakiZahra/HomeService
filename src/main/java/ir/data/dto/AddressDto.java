package ir.data.dto;

import ir.data.model.user.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
    private int id;
    private String city;
    private String country;
    private String plaque;
    private String street;
    private Customer customer;
}

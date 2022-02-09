package ir.data.dto;

import ir.data.model.user.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class AddressDto {
    private int id;
    private String city;
    private String country;
    private String plaque;
    private String street;
    private Customer customer;
}

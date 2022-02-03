package ir.data.dto;

import ir.data.model.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
    private List<Address> address;
    private Date registerTime;
    private float credit;
}

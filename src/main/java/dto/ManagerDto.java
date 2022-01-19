package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ManagerDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String username;
}
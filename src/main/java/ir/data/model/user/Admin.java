package ir.data.model.user;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
@Builder
@Entity
@Data
@NoArgsConstructor
public class Admin extends Person {
    public Admin(String firstName, String lastName, String email, String password, String username) {
        super(firstName, lastName, email, password, username);
    }
}

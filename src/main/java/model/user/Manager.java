package model.user;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Manager extends Person {
    private final int username = 123;
    private final String password = "z123";

}

package model.user;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
@Builder
@Entity
@Data
@NoArgsConstructor
public class Manager extends Person {


}

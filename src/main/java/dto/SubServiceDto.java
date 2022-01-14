package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;

@Data
@AllArgsConstructor
public class SubServiceDto {
    @Column(unique = true)
    private int id;
    private String name;
    private String description;
    private float price;
}

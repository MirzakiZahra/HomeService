package dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class SubServiceDto {
    @Column(unique = true)
    private int id;
    private String name;
    private String description;
    private float price;
}

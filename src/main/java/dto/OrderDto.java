package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.services.SubService;

import javax.persistence.Column;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private int id;
    private float price;
    private SubService subService;
    private String explanation;
    private Date beggingDate;
    private Date endingTime;
    private String address;
}

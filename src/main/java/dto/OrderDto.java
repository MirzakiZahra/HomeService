package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Offer;
import model.Transaction;
import model.enums.OrderStatus;
import model.services.SubService;
import model.user.Customer;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    @Column(unique = true)
    private int id;
    private float price;
    private SubService subService;
    private String explanation;
    private Date beggingDate;
    private Date endingTime;
    private String address;

}

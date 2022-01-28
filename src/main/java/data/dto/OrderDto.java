package data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import data.model.Offer;
import data.model.services.SubService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private int id;
    private float price;
    private SubService subService;
    private String explanation;
    private Date beggingDate;
    private Date endingTime;
    private String address;
    private List<Offer> offerList= new ArrayList<>();
}

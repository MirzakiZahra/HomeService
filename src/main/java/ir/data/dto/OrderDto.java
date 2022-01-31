package ir.data.dto;

import ir.data.model.Offer;
import ir.data.model.services.SubService;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
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
    private List<Offer> offerList = new ArrayList<>();

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", price=" + price +
                ", explanation='" + explanation + '\'' +
                ", beggingDate=" + beggingDate +
                ", endingTime=" + endingTime +
                ", address='" + address + '\'' +
                '}';
    }
}

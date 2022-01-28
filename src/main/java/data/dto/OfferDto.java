package data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfferDto {
    private int id;
    private float price;
    private Date creationDate;
    private Date startDate;
    private String explanation;
    private Date durationOfWork;
}

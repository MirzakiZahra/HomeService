package data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import data.model.Orders;
import data.model.enums.TypeOfTransaction;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionDto {
    private int id;
    private Date date;
    private TypeOfTransaction typeOfTransaction;
    private Orders orders;
}
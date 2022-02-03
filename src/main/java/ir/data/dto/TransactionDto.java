package ir.data.dto;

import ir.data.model.Orders;
import ir.data.model.enums.TypeOfTransaction;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

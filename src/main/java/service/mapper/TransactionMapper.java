package service.mapper;

import dto.OrderDto;
import dto.TransactionDto;
import model.Order;
import model.Transaction;

public class TransactionMapper {
    public TransactionDto convertTransactionToTransactionDto(Transaction transaction){
        TransactionDto transactionDto=TransactionDto.builder()
                .id(transaction.getId())
                .date(transaction.getDate())
                .typeOfTransaction(transaction.getTypeOfTransaction())
                .build();
        return transactionDto;
    }
}

package service.mapper;

import dto.TransactionDto;
import model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionMapper {
    public TransactionDto convertTransactionToTransactionDto(Transaction transaction) {
        TransactionDto transactionDto = TransactionDto.builder()
                .id(transaction.getId())
                .date(transaction.getDate())
                .typeOfTransaction(transaction.getTypeOfTransaction())
                .build();
        return transactionDto;
    }

    public List<TransactionDto> convertTransactionToTransactionDto(List<Transaction>
                                                                           transactionList) {
        List<TransactionDto> transactionDtos = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            TransactionDto transactionDto = convertTransactionToTransactionDto(transaction);
            transactionDtos.add(transactionDto);
        }
        return transactionDtos;
    }

    public List<Transaction> convertTransactionDtoToTransaction(List<TransactionDto>
                                                                        transactionDtoList) {
        List<Transaction> transactionList = new ArrayList<>();
        for (TransactionDto transactionDto : transactionDtoList) {
            Transaction transaction = Transaction.builder()
                    .date(transactionDto.getDate())
                    .typeOfTransaction(transactionDto.getTypeOfTransaction())
                    .build();
            transactionList.add(transaction);
        }
        return transactionList;
    }
}

package ir.service;

import ir.data.repository.TransactionRepository;
import ir.data.model.Orders;
import ir.data.model.Transaction;
import ir.data.model.enums.TypeOfTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository ;
    public void createTransaction(Orders orders, TypeOfTransaction typeOfTransaction){
        Transaction transaction = new Transaction();
        transaction.setOrders(orders);
        transaction.setTypeOfTransaction(typeOfTransaction);
        transactionRepository.save(transaction);
    }
}

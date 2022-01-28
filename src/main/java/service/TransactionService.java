package service;

import data.repository.TransactionRepository;
import data.model.Orders;
import data.model.Transaction;
import data.model.enums.TypeOfTransaction;
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

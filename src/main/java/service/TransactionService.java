package service;

import data.repository.TransactionRepository;
import data.model.Orders;
import data.model.Transaction;
import data.model.enums.TypeOfTransaction;

public class TransactionService {
    TransactionRepository transactionRepository = new TransactionRepository();
    public void createTransaction(Orders orders, TypeOfTransaction typeOfTransaction){
        Transaction transaction = new Transaction();
        transaction.setOrders(orders);
        transaction.setTypeOfTransaction(typeOfTransaction);
        transactionRepository.addTransaction(transaction);
    }
}

package service;

import data.dao.TransactionDao;
import data.model.Orders;
import data.model.Transaction;
import data.model.enums.TypeOfTransaction;

public class TransactionService {
    TransactionDao transactionDao = new TransactionDao();
    public void createTransaction(Orders orders, TypeOfTransaction typeOfTransaction){
        Transaction transaction = new Transaction();
        transaction.setOrders(orders);
        transaction.setTypeOfTransaction(typeOfTransaction);
        transactionDao.addTransaction(transaction);
    }
}

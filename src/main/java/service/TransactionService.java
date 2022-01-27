package service;

import dao.TransactionDao;
import model.Orders;
import model.Transaction;
import model.enums.TypeOfTransaction;

public class TransactionService {
    TransactionDao transactionDao = new TransactionDao();
    public void createTransaction(Orders orders, TypeOfTransaction typeOfTransaction){
        Transaction transaction = new Transaction();
        transaction.setOrders(orders);
        transaction.setTypeOfTransaction(typeOfTransaction);
        transactionDao.addTransaction(transaction);
    }
}

package service;

import dao.TransactionDao;
import model.Orders;
import model.Transaction;
import model.enums.TypeOfTransaction;

public class TransactionService {
    TransactionDao transactionDao = new TransactionDao();
    OrderService orderService = new OrderService();
    public void createTransaction(int orderId, TypeOfTransaction typeOfTransaction){
        Transaction transaction = new Transaction();
        Orders orders = orderService.findOrderByIdReturnOrder(orderId);
        transaction.setOrders(orders);
        transaction.setTypeOfTransaction(typeOfTransaction);
        transactionDao.addTransaction(transaction);
    }
}

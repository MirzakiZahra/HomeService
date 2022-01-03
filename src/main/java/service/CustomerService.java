package service;

import dao.CustomerDb;
import entity.Customer;
import entity.Expert;

public class CustomerService {
    CustomerDb customerDb=new CustomerDb();
    public void createCustomer(String firstName,String lastName,String address, String email, String password){
        Customer customer=new Customer(firstName,lastName,address,email,password);
        customerDb.addCustomer(customer);
        

    }
}

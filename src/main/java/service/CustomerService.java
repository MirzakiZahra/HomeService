package service;
import dao.CustomerDb;
import model.people.Customer;

public class CustomerService {
    CustomerDb customerDb=new CustomerDb();
    public void createCustomer(String firstName,String lastName,String address, String email, String password){
        Customer customer=new Customer(firstName,lastName,address,email,password);
        customerDb.addCustomer(customer);


    }
    public void changePassword(String password,int username){
       Customer customer= customerDb.findCustomer(username);
       customer.setPassword(password);

    }
}

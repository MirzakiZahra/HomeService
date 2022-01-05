package service;

import dao.CustomerDb;
import model.people.Customer;
import model.people.Expert;

import java.util.List;

public class CustomerService {
    CustomerDb customerDb = new CustomerDb();

    public void createCustomer(String firstName, String lastName, String address, String email, String password) {
        Customer customer = new Customer(firstName, lastName, address, email, password);
        customerDb.addCustomer(customer);
    }

    public void changePassword(String password, String email) {
        Customer customer = customerDb.findCustomerByEmail(email);
        customer.setPassword(password);
        customerDb.updateCustomerPassword(customer);
    }

    public void deductionOfMoneyForCustomer(String email, float money) {
        Customer customer = customerDb.findCustomerByEmail(email);
        float temp = customer.getCredit() - money;
        customer.setCredit(temp);
        customerDb.updateCustomerCredit(customer);

    }
    public void printShowCustomer(){
        List<Customer>customers=customerDb.showCustomer();
        customers.stream().forEach(i -> System.out.println(i.getLastName()));

    }
}

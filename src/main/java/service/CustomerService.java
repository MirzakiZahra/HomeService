package service;

import dao.CustomerDb;
import dao.ExpertDb;
import dao.OrderDb;
import exception.InputException;
import model.Address;
import model.user.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerService {
    CustomerDb customerDb = new CustomerDb();
    ExpertDb expertDb = new ExpertDb();
    OrderDb orderDb = new OrderDb();

    public void createCustomer(String firstName, String lastName,List< Address> address, String email, String password) {
        Customer customer = new Customer(firstName, lastName, email, password,address);
        customerDb.addCustomer(customer);
    }

    public void removeCustomer(String email) {
        Customer customer = customerDb.findCustomerByEmail(email);
        customerDb.deleteCustomer(customer);
    }

    public void changePassword(String password, String email) {
        Customer customer = customerDb.findCustomerByEmail(email);
        customer.setPassword(password);
        customerDb.updateCustomer(customer);
    }

    public void withdrawCreditOfCustomer(String email, float money) {
        Customer customer = customerDb.findCustomerByEmail(email);
        float temp = customer.getCredit() - money;
        customer.setCredit(temp);
        customerDb.updateCustomerCredit(customer);
    }

    public HashMap<String, List<String>> showCustomer() {
        List<Customer> customers = customerDb.showCustomer();
        HashMap<String, List<String>> customerHashMap = new HashMap<>();
        customers.stream().forEach(i -> customerHashMap.put(i.getFirstName(),
                new ArrayList<>() {{
                    add(i.getLastName());
                    //add(i.getAddress());
                }}));
        return customerHashMap;
    }

    public Customer findCustomerByEmail(String email) {
        Customer customer = customerDb.findCustomerByEmail(email);
        if (customer.equals(null)) {
            throw new InputException("Your Email DoesNot Exist");
        }
        return customer;
    }

    public void checkOldPassword(String password) {
        if (customerDb.checkExistOfPassword(password) == 0) {
            throw new InputException("Password is Incorrect");
        }
    }
}

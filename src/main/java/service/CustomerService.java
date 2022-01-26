package service;

import dao.CustomerDb;
import dao.ExpertDb;
import dao.OrderDb;
import dto.AddressDto;
import exception.InputException;
import model.Address;
import model.user.Customer;
import service.mapper.AddressMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerService {
    CustomerDb customerDb = new CustomerDb();
    AddressMapper addressMapper = new AddressMapper();
    AddressService addressService = new AddressService();

    public void createCustomer(String firstName, String lastName, AddressDto addressDto, String email, String password) {
        Address address = addressMapper.convertAddressDtoToAddress(addressDto);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        Customer customer = new Customer(firstName, lastName, email, password,addressList);
        customer.getAddress().add(address);
        address.setCustomer(customer);
        addressService.createAddress(address);
    }

    public void removeCustomer(String email) {
        Customer customer = customerDb.findCustomerByEmail(email).get(0);
        customerDb.deleteCustomer(customer);
    }

    public void changePassword(String password, String email) {
        Customer customer = customerDb.findCustomerByEmail(email).get(0);
        customer.setPassword(password);
        customerDb.updateCustomer(customer);
    }

    public void withdrawCreditOfCustomer(String email, float money) {
        Customer customer = customerDb.findCustomerByEmail(email).get(0);
        float temp = customer.getCredit() - money;
        customer.setCredit(temp);
        customerDb.updateCustomer(customer);
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

    public boolean checkExistenceOfCustomerByEmail(String email) {
        List<Customer> customerList = customerDb.findCustomerByEmail(email);
        if (customerList.size()==0) {
            return false;
        }
        return true;
    }
    public Customer findCustomerByEmail(String email) {
        List<Customer> customerList = customerDb.findCustomerByEmail(email);
        if (customerList.size()==0){
            throw new InputException("Customer Not Exist");
        }
        return customerList.get(0);
    }

    public void checkOldPassword(String password) {
        if (customerDb.checkExistOfPassword(password) == 0) {
            throw new InputException("Password is Incorrect");
        }
    }
    public void updateCustomer(Customer customer){
        customerDb.updateCustomer(customer);
    }
}

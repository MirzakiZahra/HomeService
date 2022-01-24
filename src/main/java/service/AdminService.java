package service;

import dto.AddressDto;
import model.Address;
import model.user.Customer;
import model.user.Manager;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    public void createCustomer(String firstName, String lastName, String email
            , String password,String username) {
       Manager manager = new Manager( firstName,lastName,  email,  password,username);
        customer.getAddress().add(address);
        address.setCustomer(customer);
        addressService.createAddress(address);
    }
}

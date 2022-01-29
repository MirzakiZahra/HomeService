package ir.service;

import ir.data.dto.AddressDto;
import ir.data.model.Address;
import ir.data.model.user.Customer;
import ir.data.repository.CustomerRepository;
import ir.exception.InputException;
import ir.service.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CustomerService {
    private  CustomerRepository customerRepository;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    //ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    @Autowired
  //  @Qualifier("customerRepository")
  //  CustomerRepository customerRepository;
    //= context.getBean(CustomerRepository.class) ;
    AddressMapper addressMapper = new AddressMapper();
    @Autowired
    AddressService addressService = new AddressService();

    public void createCustomer(String firstName, String lastName, AddressDto addressDto, String email, String password) {
        Address address = addressMapper.convertAddressDtoToAddress(addressDto);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        Customer customer = new Customer(firstName, lastName, email, password, addressList);
        customer.getAddress().add(address);
        address.setCustomer(customer);
        addressService.createAddress(address);
    }

    public void removeCustomer(String email) {
        Customer customer = customerRepository.findAllByEmail(email).get(0);
        customerRepository.delete(customer);
    }

    public void changePassword(String password, String email) {
        Customer customer = customerRepository.findAllByEmail(email).get(0);
        customer.setPassword(password);
        customerRepository.save(customer);
    }

    public void withdrawCreditOfCustomer(String email, float money) {
        Customer customer = customerRepository.findAllByEmail(email).get(0);
        if (customer.getCredit() < money) {
            throw new InputException("Your Credit is Not Enough");
        } else {
            float temp = customer.getCredit() - money;
            customer.setCredit(temp);
            customerRepository.save(customer);
        }
    }

    public boolean checkExistenceOfCustomerByEmail(String email) {
        List<Customer> customerList = customerRepository.findAllByEmail(email);
        if (customerList.size() == 0) {
            return false;
        }
        return true;
    }

    public Customer findCustomerByEmail(String email) {
        List<Customer> customerList = customerRepository.findAllByEmail(email);
        if (customerList.size() == 0) {
            throw new InputException("Customer Not Exist");
        }
        return customerList.get(0);
    }

    public void checkOldPassword(String password) {
        if (customerRepository.findAllByPassword(password).size() == 0) {
            throw new InputException("Password is Incorrect");
        }
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }


}

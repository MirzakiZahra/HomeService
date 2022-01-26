import dto.AddressDto;
import model.Address;
import model.user.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceTest {
    Customer customer = new Customer();
    Address address = new Address();
    AddressDto addressDto = new AddressDto();
    List<Address> addressList = new ArrayList<>();
    CustomerService customerService = new CustomerService();
    @BeforeEach
    void init(){
        addressDto = AddressDto.builder()
                .country("Iran")
                .city("Tehran")
                .street("Imam")
                .plaque("5")
                .build();
        addressList.add(address);
        customer=Customer.builder()
                .firstName("Zahra")
                .lastName("Mirzaki")
                .email("mirzaki@gmail.com")
                .password("Z@hra123456")
                .address(addressList)
                .build();
    }
    @Test
    void saveCustomerThenCheckExistence(){
        customerService.createCustomer("Zahra","Mirzaki",
                addressDto,"mirzaki1@gmail.com","Z@hra123456");
        Customer customer = customerService.findCustomerByEmail("mirzaki1@gmail.com");
        Assertions.assertEquals(customer.getFirstName(),"Zahra");
    }
}

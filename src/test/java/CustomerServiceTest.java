import dto.AddressDto;
import exception.InputException;
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
        customerService.createCustomer("Zahra","Mirzaki",
                addressDto,"mirzaki1@gmail.com","Z@hra123456");
    }
    @Test
    void saveCustomerThenCheckExistence(){
        Customer customer = customerService.findCustomerByEmail("mirzaki1@gmail.com");
        Assertions.assertEquals(customer.getFirstName(),"Zahra");
    }
    @Test
    void saveCustomerThenRemoveAndThenCheckExistence(){
        customerService.removeCustomer("mirzaki1@gmail.com");
        InputException result = Assertions.assertThrows(InputException.class, () ->
                customerService.findCustomerByEmail("mirzaki1@gmail.com"));
        Assertions.assertEquals(result.getMessage(),"Customer Not Exist");
    }
    @Test
    void checkOldPasswordByWrongPass(){
        InputException result = Assertions.assertThrows(InputException.class, () ->
                customerService.checkOldPassword("123456"));
        Assertions.assertEquals(result.getMessage(),"Password is Incorrect");
    }
}

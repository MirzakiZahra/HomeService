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
    AddressDto addressDto = new AddressDto();
    CustomerService customerService = new CustomerService();
    @BeforeEach
    void init(){
        addressDto = AddressDto.builder()
                .country("Iran")
                .city("Tehran")
                .street("Imam")
                .plaque("5")
                .build();
        customerService.createCustomer("Zahra","Mirzaki",
                addressDto,"mirzaki1@gmail.com","Z@hra123456");
    }
    @Test
    void giveExistCustomerEmail_findByEmail_customerName(){
        Customer customer = customerService.findCustomerByEmail("mirzaki1@gmail.com");
        Assertions.assertEquals(customer.getFirstName(),"Zahra");
    }
    @Test
    void giveExistUser_removeAndFindCustomer_ThrowException(){
        customerService.removeCustomer("mirzaki1@gmail.com");
        InputException result = Assertions.assertThrows(InputException.class, () ->
                customerService.findCustomerByEmail("mirzaki1@gmail.com"));
        Assertions.assertEquals(result.getMessage(),"Customer Not Exist");
    }
    @Test
    void giveWrongPass_checkOldPassword_ThrowException(){
        InputException result = Assertions.assertThrows(InputException.class, () ->
                customerService.checkOldPassword("123456"));
        Assertions.assertEquals(result.getMessage(),"Password is Incorrect");
    }
    @Test
    void
}

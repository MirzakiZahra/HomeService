import dto.AddressDto;
import exception.InputException;
import model.user.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.CustomerService;

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
        Assertions.assertEquals("Zahra",customer.getFirstName());
    }
    @Test
    void giveExistUser_removeAndFindCustomer_ThrowException(){
        customerService.removeCustomer("mirzaki1@gmail.com");
        InputException result = Assertions.assertThrows(InputException.class, () ->
                customerService.findCustomerByEmail("mirzaki1@gmail.com"));
        Assertions.assertEquals("Customer Not Exist",result.getMessage());
    }
    @Test
    void giveWrongPass_checkOldPassword_ThrowException(){
        InputException result = Assertions.assertThrows(InputException.class, () ->
                customerService.checkOldPassword("123456"));
        Assertions.assertEquals("Password is Incorrect",result.getMessage());
    }
    @Test
    void giveCustomerEmailAndNewPass_changePass_newPass(){
        customerService.changePassword("12345","mirzaki1@gmail.com");
        Customer customer = customerService.findCustomerByEmail("mirzaki1@gmail.com");
        Assertions.assertEquals("12345",customer.getPassword());
    }
    @Test
    void giveCustomerEmailAndCredit_withdrawCredit_newAccurateCredit(){
        Customer customer = customerService.findCustomerByEmail("mirzaki1@gmail.com");
        customer.setCredit(5000);
        customerService.updateCustomer(customer);
        customerService.withdrawCreditOfCustomer("mirzaki1@gmail.com",2000);
        customer=customerService.findCustomerByEmail("mirzaki1@gmail.com");
        Assertions.assertEquals(3000,customer.getCredit());
    }
    @Test
    void giveCustomerEmailAndCredit_withdrawCreditMoreThanCurrentCredit_throwException(){
        Customer customer = customerService.findCustomerByEmail("mirzaki1@gmail.com");
        customer.setCredit(5000);
        customerService.updateCustomer(customer);
        InputException result = Assertions.assertThrows(InputException.class, () ->
                customerService.withdrawCreditOfCustomer("mirzaki1@gmail.com",8000));
        Assertions.assertEquals("Your Credit is Not Enough",result.getMessage());
    }
}

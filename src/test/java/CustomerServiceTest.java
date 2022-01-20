import model.Address;
import model.user.Customer;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceTest {
    Customer customer = new Customer();
    Address address = new Address();
    List<Address> addressList = new ArrayList<>();
    @BeforeEach
    void init(){
        address = Address.builder()
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
    
}

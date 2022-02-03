import ir.config.SpringConfig;
import ir.data.model.Address;
import ir.service.AddressService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AddressServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    AddressService addressService = context.getBean(AddressService.class);

    @Test
    void giveAddressNeededData_addAddressAndThenFindIt_AccurateAddress() {
        Address address = Address.builder()
                .country("Iran")
                .city("Tehran")
                .street("ImamKhomeini")
                .plaque("65")
                .build();
        addressService.createAddress(address);
        Assertions.assertEquals(address, addressService.findById(13));
    }
}

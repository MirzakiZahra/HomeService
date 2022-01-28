import ir.config.SpringConfig;
import ir.data.repository.AddressRepository;
import ir.data.model.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ir.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AddressServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    AddressService addressService = context.getBean(AddressService.class);
    @Test
    void giveAddressNeededData_addAddressAndThenFindIt_AccurateAddress(){
        Address address = Address.builder()
                .country("Iran")
                .city("Tehran")
                .street("ImamKhomeini")
                .plaque("65")
                .build();
        addressService.createAddress(address);
        Address byId = addressService.findById(1);
        Assertions.assertEquals(address,byId);
    }
}

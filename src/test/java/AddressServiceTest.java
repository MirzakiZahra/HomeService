import ir.config.SpringConfig;
import ir.data.repository.AddressRepository;
import ir.data.model.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ir.service.AddressService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.ObjectInputFilter;

public class AddressServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    AddressService addressService = context.getBean(AddressService.class);
    AddressRepository addressRepository ;
    @Test
    void giveAddressNeededData_addAddressAndThenFindIt_AccurateAddress(){
        Address address = Address.builder()
                .country("Iran")
                .city("Tehran")
                .street("Imam")
                .plaque("6")
                .build();
        addressService.createAddress(address);
        Assertions.assertEquals(address, addressRepository.findAddressById(1));
    }
}

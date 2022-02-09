import ir.config.SpringConfig;
import ir.data.dto.AddressDto;
import ir.data.model.Address;
import ir.service.AddressService;
import ir.service.mapper.AddressMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AddressServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    AddressService addressService = context.getBean(AddressService.class);
    AddressMapper addressMapper = new AddressMapper();

    @Test
    void giveAddressNeededData_addAddressAndThenFindIt_AccurateAddress() {
        AddressDto addressDto = AddressDto.builder()
                .country("Iran")
                .city("Tehran")
                .street("ImamKhomeini")
                .plaque("65")
                .build();
        addressService.createAddress(addressDto);
        Assertions.assertEquals(13, addressService.findById(13).getId());
    }
}

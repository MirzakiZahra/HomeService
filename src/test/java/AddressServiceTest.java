import data.repository.AddressRepository;
import data.model.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.AddressService;

public class AddressServiceTest {
    AddressService addressService = new AddressService();
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

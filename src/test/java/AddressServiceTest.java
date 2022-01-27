import dao.AddressDb;
import model.Address;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.AddressService;

public class AddressServiceTest {
    AddressService addressService = new AddressService();
    AddressDb addressDb = new AddressDb();
    @Test
    void giveAddressNeededData_addAddressAndThenFindIt_AccurateAddress(){
        Address address = Address.builder()
                .country("Iran")
                .city("Tehran")
                .street("Imam")
                .plaque("6")
                .build();
        addressService.createAddress(address);
        Assertions.assertEquals(address,addressDb.findAddressById(1));
    }
}

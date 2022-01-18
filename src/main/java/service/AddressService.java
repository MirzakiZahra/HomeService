package service;

import dao.AddressDb;
import dto.AddressDto;
import model.Address;
import model.user.Customer;
import service.mapper.AddressMapper;

public class AddressService {
    AddressMapper addressMapper = new AddressMapper();
    AddressDb addressDb = new AddressDb();
    public void createAddress(Address address){
        addressDb.AddAddress(address);
    }
}

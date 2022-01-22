package service;

import dao.AddressDb;
import model.Address;
import service.mapper.AddressMapper;

public class AddressService {
    AddressMapper addressMapper = new AddressMapper();
    AddressDb addressDb = new AddressDb();
    public void createAddress(Address address){
        addressDb.AddAddress(address);
    }
}

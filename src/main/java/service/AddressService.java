package service;

import data.dao.AddressDb;
import data.model.Address;
import service.mapper.AddressMapper;

public class AddressService {
    AddressMapper addressMapper = new AddressMapper();
    AddressDb addressDb = new AddressDb();
    public void createAddress(Address address){
        addressDb.AddAddress(address);
    }
}

package service;

import dao.AddressDb;
import dto.AddressDto;
import model.Address;
import service.mapper.AddressMapper;

public class AddressService {
    AddressMapper addressMapper = new AddressMapper();
    AddressDb addressDb = new AddressDb();
    public void createAddress(AddressDto addressDto){
        Address address = addressMapper.convertAddressDtoToAddress(addressDto);
        addressDb.AddAddress(address);
    }
}

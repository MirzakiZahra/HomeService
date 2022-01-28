package service;

import data.repository.AddressRepository;
import data.model.Address;
import service.mapper.AddressMapper;

public class AddressService {
    AddressMapper addressMapper = new AddressMapper();
    AddressRepository addressRepository = new AddressRepository();
    public void createAddress(Address address){
        addressRepository.AddAddress(address);
    }
}

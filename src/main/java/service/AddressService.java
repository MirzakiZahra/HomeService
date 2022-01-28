package service;

import data.repository.AddressRepository;
import data.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.mapper.AddressMapper;
@Service
public class AddressService {
    AddressMapper addressMapper = new AddressMapper();
    @Autowired
    AddressRepository addressRepository ;
    public void createAddress(Address address){
        addressRepository.save(address);
    }
}

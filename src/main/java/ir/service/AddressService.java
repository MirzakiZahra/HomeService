package ir.service;

import ir.data.model.Address;
import ir.data.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("addressService")
public class AddressService {
    @Autowired
    AddressRepository addressRepository;

    public void createAddress(Address address) {
        addressRepository.save(address);
    }

    public Address findById(int id) {
        return addressRepository.findById(id);
    }
}

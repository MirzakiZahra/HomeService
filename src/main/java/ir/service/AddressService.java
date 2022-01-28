package ir.service;

import ir.data.repository.AddressRepository;
import ir.data.model.Address;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Qualifier("addressService")
//@Transactional
//@RequiredArgsConstructor
public class AddressService {
    @Autowired
    AddressRepository addressRepository ;
    public void createAddress(Address address){
        addressRepository.save(address);
    }
    public Address findById(int id){
        return addressRepository.findById(id);
    }
}

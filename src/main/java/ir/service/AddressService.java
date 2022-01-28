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
@Qualifier("AddressService")
//@Transactional
//@RequiredArgsConstructor
public class AddressService {
    @Autowired(required = true)
    AddressRepository addressRepository ;
    public void createAddress(Address address){
        addressRepository.save(address);
    }
}

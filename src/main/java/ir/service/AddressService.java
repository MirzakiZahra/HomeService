package ir.service;

import ir.data.dto.AddressDto;
import ir.data.model.Address;
import ir.data.repository.AddressRepository;
import ir.service.mapper.AddressMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("addressService")
public class AddressService {
    @Autowired
    AddressRepository addressRepository;
    AddressMapper addressMapper=new AddressMapper();

    public void createAddress(AddressDto addressDto) {
        addressRepository.save(addressMapper.convertAddressDtoToAddress(addressDto));
    }

    public Address findById(int id) {
        return addressRepository.findById(id);
    }
}

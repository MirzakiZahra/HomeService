package ir.service.mapper;

import ir.data.dto.AddressDto;
import ir.data.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address convertAddressDtoToAddress(AddressDto addressDto) {
        Address address = Address.builder()
                .city(addressDto.getCity())
                .country(addressDto.getCountry())
                .plaque(addressDto.getPlaque())
                .street(addressDto.getStreet())
                .build();
        return address;
    }
}

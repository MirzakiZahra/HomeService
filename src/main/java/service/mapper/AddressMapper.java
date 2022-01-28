package service.mapper;

import data.dto.AddressDto;
import data.model.Address;

public class AddressMapper {
    public Address convertAddressDtoToAddress(AddressDto addressDto){
        Address address = Address.builder()
                .city(addressDto.getCity())
                .country(addressDto.getCountry())
                .plaque(addressDto.getPlaque())
                .street(addressDto.getStreet())
                .build();
        return address;
    }
}

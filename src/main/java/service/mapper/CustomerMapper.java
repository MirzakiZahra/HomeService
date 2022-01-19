package service.mapper;

import dto.CustomerDto;
import model.user.Customer;

public class CustomerMapper {
    public CustomerDto convertCustomerToCustomerDto(Customer customer) {
        CustomerDto customerDto = CustomerDto.builder()
                .id(customer.getId())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .address(customer.getAddress())
                .credit(customer.getCredit())
                .build();
        return customerDto;
    }
}

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

    /*public List<Customer> convertCustomerDtoToCustomer(List<CustomerDto> customerDtoList) {
        List<Customer> customerList = new ArrayList<>();
        for (CustomerDto customerDto : customerDtoList) {
            Customer customer = Customer.builder()
                    .credit(customerDto.getCredit())
                    .registerTime(customerDto.getRegisterTime())
                    .build();
            customerList.add(customer);
        }
        return customerList;
    }*/
}

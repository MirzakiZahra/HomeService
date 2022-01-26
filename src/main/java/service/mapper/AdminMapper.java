package service.mapper;

import dto.AdminDto;
import dto.CustomerDto;
import model.user.Customer;
import model.user.Manager;

public class AdminMapper {
    public AdminDto convertAdminToAdminDto(Manager manager) {
        AdminDto adminDto= AdminDto.builder()
                .firstName(manager.getFirstName())
                .lastName(manager.getLastName())
                .email(manager.getEmail())
                .build();
        return adminDto;
    }
}

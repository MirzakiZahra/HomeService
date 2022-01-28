package service.mapper;

import data.dto.AdminDto;
import data.model.user.Manager;

public class AdminMapper {
    public AdminDto convertAdminToAdminDto(Manager manager) {
        AdminDto adminDto= AdminDto.builder()
                .firstName(manager.getFirstName())
                .lastName(manager.getLastName())
                .email(manager.getEmail())
                .password(manager.getPassword())
                .username(manager.getUsername())
                .build();
        return adminDto;
    }
}

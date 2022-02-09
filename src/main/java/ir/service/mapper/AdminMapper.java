package ir.service.mapper;

import ir.data.dto.AdminDto;
import ir.data.model.user.Admin;
import org.springframework.stereotype.Component;

@Component
public class AdminMapper {
    public AdminDto convertAdminToAdminDto(Admin admin) {
        AdminDto adminDto = AdminDto.builder()
                .firstName(admin.getFirstName())
                .lastName(admin.getLastName())
                .email(admin.getEmail())
                .password(admin.getPassword())
                .username(admin.getUsername())
                .build();
        return adminDto;
    }
}

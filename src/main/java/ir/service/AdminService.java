package ir.service;

import ir.data.dto.AdminDto;
import ir.data.model.user.Admin;
import ir.data.repository.AdminRepository;
import ir.service.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;
    AdminMapper adminMapper = new AdminMapper();

    public void createAdmin(String firstName, String lastName, String email
            , String password, String username) {
        Admin admin = new Admin(firstName, lastName, email, password, username);
        adminRepository.save(admin);
    }

    public AdminDto findManagerByEmailReturnDto(String email) {
        List<Admin> adminList = adminRepository.findManagerByEmail(email);
        return adminMapper.convertAdminToAdminDto(adminList.get(0));
    }

    public Admin findManagerByEmail(String email) {
        return adminRepository.findManagerByEmail(email).get(0);
    }
}

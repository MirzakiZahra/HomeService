package service;

import data.repository.AdminRepository;
import data.dto.AdminDto;
import data.model.user.Manager;
import service.mapper.AdminMapper;

import java.util.List;

public class AdminService {
    AdminRepository adminRepository =new AdminRepository();
    AdminMapper adminMapper = new AdminMapper();
    public void createAdmin(String firstName, String lastName, String email
            , String password,String username) {
       Manager manager = new Manager( firstName,lastName,  email,  password,username);
        adminRepository.addAdmin(manager);
    }
    public AdminDto findManagerByEmail(String email) {
        List<Manager> managerList = adminRepository.findManagerByEmail(email);
        return adminMapper.convertAdminToAdminDto(managerList.get(0));
    }
}

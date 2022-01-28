package service;

import data.repository.AdminRepository;
import data.dto.AdminDto;
import data.model.user.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.mapper.AdminMapper;

import java.util.List;
@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository ;
    AdminMapper adminMapper = new AdminMapper();
    public void createAdmin(String firstName, String lastName, String email
            , String password,String username) {
       Manager manager = new Manager( firstName,lastName,  email,  password,username);
        adminRepository.save(manager);
    }
    public AdminDto findManagerByEmail(String email) {
        List<Manager> managerList = adminRepository.findManagerByEmail(email);
        return adminMapper.convertAdminToAdminDto(managerList.get(0));
    }
}

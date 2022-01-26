package service;

import dao.AdminDb;
import dto.AdminDto;
import model.user.Manager;
import service.mapper.AdminMapper;

import java.util.List;

public class AdminService {
    AdminDb adminDb=new AdminDb();
    AdminMapper adminMapper = new AdminMapper();
    public void createAdmin(String firstName, String lastName, String email
            , String password,String username) {
       Manager manager = new Manager( firstName,lastName,  email,  password,username);
        adminDb.addAdmin(manager);
    }
    public AdminDto findManagerByEmail(String email) {
        List<Manager> managerList = adminDb.findManagerByEmail(email);
        return adminMapper.convertAdminToAdminDto(managerList.get(0));
    }
}

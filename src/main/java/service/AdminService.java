package service;

import dao.AdminDb;
import dto.AddressDto;
import dto.ManagerDto;
import model.Address;
import model.user.Customer;
import model.user.Manager;
import view.Main;

import java.util.ArrayList;
import java.util.List;

public class AdminService {
    AdminDb adminDb=new AdminDb();
    public void createAdmin(String firstName, String lastName, String email
            , String password,String username) {
       Manager manager = new Manager( firstName,lastName,  email,  password,username);
        adminDb.addAdmin(manager);
    }
    public ManagerDto findManagerByEmail(String email) {
        List<Manager> managerList = adminDb.findManagerByEmail(email);
        
        return managerList.get(0);
    }
}

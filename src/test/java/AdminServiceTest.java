import data.dao.AdminDb;
import data.model.user.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.AdminService;

public class AdminServiceTest {
    AdminService adminService = new AdminService();
    AdminDb adminDb = new AdminDb();
    @Test
    void giveAdminNeededData_addAdminAndThenFindIt_AccurateAdmin(){
        Manager manager = new Manager("admin","admin","admin@admin.com",
                "@Dmin123456","admin") ;
        adminService.createAdmin(manager.getFirstName(), manager.getLastName(), manager.getEmail(),
                manager.getPassword(), manager.getUsername());
        Assertions.assertEquals(manager,
                adminDb.findManagerByEmail("admin@admin.com").get(0));
    }
}

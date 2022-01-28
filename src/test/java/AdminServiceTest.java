import ir.config.SpringConfig;
import ir.data.repository.AdminRepository;
import ir.data.model.user.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ir.service.AdminService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AdminServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    AdminService adminService = context.getBean(AdminService.class);
    @Test
    void giveAdminNeededData_addAdminAndThenFindIt_AccurateAdmin(){
        Manager manager = new Manager("admin","admin","admin@admin.com",
                "@Dmin123456","admin") ;
        adminService.createAdmin(manager.getFirstName(), manager.getLastName(), manager.getEmail(),
                manager.getPassword(), manager.getUsername());
        Assertions.assertEquals(manager,
                adminRepository.findManagerByEmail("admin@admin.com").get(0));
    }
}

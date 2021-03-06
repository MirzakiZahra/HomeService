import ir.config.SpringConfig;
import ir.data.model.user.Admin;
import ir.service.AdminService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AdminServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    AdminService adminService = context.getBean(AdminService.class);

    @Test
    void giveAdminNeededData_addAdminAndThenFindIt_AccurateAdmin() {
        Admin admin = new Admin("admin", "admin", "admin@admin.com",
                "@Dmin123456", "admin");
        adminService.createAdmin(admin.getFirstName(), admin.getLastName(), admin.getEmail(),
                admin.getPassword(), admin.getUsername());
        Assertions.assertEquals(admin,
                adminService.findManagerByEmail("admin@admin.com"));
    }
}

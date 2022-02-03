import ir.config.SpringConfig;
import ir.exception.InputException;
import ir.service.MainServiceService;
import ir.service.SubServiceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SubServiceServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    SubServiceService subServiceService = context.getBean(SubServiceService.class);
    MainServiceService mainServiceService = context.getBean(MainServiceService.class);

    @BeforeEach
    void init() {
        mainServiceService.createMainService("Cleaning");
        subServiceService.createSubService("CleanHome", "Nothing", 8000,
                "Cleaning");
    }

    @Test
    void giveSubServiceName_deleteItThenFindIt_throwException() {
        subServiceService.deleteSubServiceByName("CleanHome");
        InputException result = Assertions.assertThrows(InputException.class, () ->
                subServiceService.findSubServiceByName("CleanHome"));
        Assertions.assertEquals("SubService DosesNot Exist", result.getMessage());
    }
}

import ir.config.SpringConfig;
import ir.exception.InputException;
import ir.data.model.services.MainService;
import ir.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ir.service.MainServiceService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainServiceServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    MainServiceService mainServiceService = context.getBean(MainServiceService.class);


    @BeforeEach
    void init() {
        MainService mainService = new MainService("Repairing");
        mainServiceService.createMainService(mainService.getName());
    }

    @Test
    void giveMainServiceName_addItAndThenGetIt_AccurateMainService() {
        Assertions.assertEquals("Repairing",
                mainServiceService.findMainService("Repairing").get(0).getName());
    }

    @Test
    void giveMainServiceName_addItThenDeleteITThenFindIt_throwException() {
        mainServiceService.deleteMainService("Repairing");
        InputException result = Assertions.assertThrows(InputException.class, () ->
                mainServiceService.findMainService("Repairing"));
        Assertions.assertEquals("MainService DoesNot Exist", result.getMessage());
    }

    @Test
    void giveDuplicateMainServiceName_addIt_throwException() {
        Exception result = Assertions.assertThrows(Exception.class, () ->
                mainServiceService.createMainService("Repairing"));
        Assertions.assertEquals("could not execute statement", result.getMessage());
    }
    @Test
    void giveNewMainServiceName_updateItThenFindIt_throwException(){
        MainService mainService = mainServiceService.findMainService("Repairing").get(0);
        mainService.setName("RepairingSomeThingElse");
        mainServiceService.updateMainService(mainService);
        InputException result = Assertions.assertThrows(InputException.class, () ->
                mainServiceService.findMainService("Repairing"));
        Assertions.assertEquals("MainService DoesNot Exist",result.getMessage());
    }
    @Test
    void giveExistMainServiceName_checkExistenceOfIt_returnTrue(){
        Assertions.assertEquals(true,mainServiceService.checkExistOfMainService("Repairing"));
    }
}

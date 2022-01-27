import exception.InputException;
import model.services.MainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.MainServiceService;

public class MainServiceServiceTest {
    MainServiceService mainServiceService = new MainServiceService();
    @BeforeEach
    void init(){
        MainService mainService = new MainService("Repairing");
        mainServiceService.createMainService(mainService.getName());
    }
    @Test
    void giveMainServiceName_addItAndThenGetIt_AccurateMainService(){
        Assertions.assertEquals("Repairing",
                mainServiceService.findMainService("Repairing").get(0).getName());
    }
    @Test
    void giveMainServiceName_addItThenDeleteITThenFindIt_throwException(){
        mainServiceService.deleteMainService("Repairing");
        InputException result = Assertions.assertThrows(InputException.class, () ->
               mainServiceService.findMainService("Repairing"));
        Assertions.assertEquals("MainService DoesNot Exist",result.getMessage());
    }
    
}

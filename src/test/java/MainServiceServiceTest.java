import model.services.MainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import service.MainServiceService;

public class MainServiceServiceTest {
    MainServiceService mainServiceService = new MainServiceService();

    @Test
    void giveMainServiceName_addItAndThenGetIt_AccurateMainService(){
        MainService mainService = new MainService("Repairing");
        mainServiceService.createMainService(mainService.getName());
        Assertions.assertEquals(mainService.getName(),
                mainServiceService.findMainService("Repairing").get(0).getName());
    }

}

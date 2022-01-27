import org.junit.jupiter.api.BeforeEach;
import service.MainServiceService;
import service.SubServiceService;

public class SubServiceServiceTest {
    SubServiceService subServiceService = new SubServiceService();
    MainServiceService mainServiceService = new MainServiceService();
    @BeforeEach
    void init(){
        mainServiceService.createMainService("Cleaning");
        subServiceService.createSubService("CleanHome","Nothing",8000,
                "Cleaning");
    }
    
}

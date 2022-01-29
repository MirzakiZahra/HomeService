import ir.exception.InputException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ir.service.MainServiceService;
import ir.service.SubServiceService;

public class SubServiceServiceTest {
    SubServiceService subServiceService = new SubServiceService();
    MainServiceService mainServiceService;
    @BeforeEach
    void init(){
        mainServiceService.createMainService("Cleaning");
        subServiceService.createSubService("CleanHome","Nothing",8000,
                "Cleaning");
    }
    @Test
    void giveSubServiceName_deleteItThenFindIt_throwException(){
        subServiceService.deleteSubServiceByName("CleanHome");
        InputException result = Assertions.assertThrows(InputException.class, () ->
                subServiceService.findSubServiceByName("CleanHome"));
        Assertions.assertEquals("SubService DosesNot Exist",result.getMessage());
    }
}

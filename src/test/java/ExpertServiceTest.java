import dao.ServiceDb;
import dao.SubServiceDb;
import dto.AddressDto;
import dto.ExpertDto;
import exception.InputException;
import model.services.MainService;
import model.services.SubService;
import model.user.Expert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.ExpertService;
import service.MainServiceService;

public class ExpertServiceTest {
    ExpertService expertService = new ExpertService();

    @BeforeEach
    void init() {
        expertService.createExpert("Ali", "Alavi", "ali@gmail.com");
    }
    @Test
    void giveExpertEmail_findExpertByEmail_trueExpertName(){
        ExpertDto expertDto = expertService.findExpertByEmail("ali@gmail.com");
        Assertions.assertEquals("Ali",expertDto.getFirstName());
    }
    @Test
    void giveNotExistExpertEmail_findExpertByEmail_throwException(){
        InputException result = Assertions.assertThrows(InputException.class, () ->
                expertService.findExpertByEmail("aliyavari@gmail.com"));
        Assertions.assertEquals("Expert DoesNot Exist",result.getMessage());
    }
    @Test
    void giveExistExpert_removeAndFindExpert_ThrowException(){
        expertService.deleteExpert("ali@gmail.com");
        InputException result = Assertions.assertThrows(InputException.class, () ->
                expertService.findExpertByEmail("ali@gmail.com"));
        Assertions.assertEquals("Expert DoesNot Exist",result.getMessage());
    }
    @Test
    void giveExpertEmailAndSubServiceName_addSubServiceToExpert_AccurateSubService(){
        MainService mainService = new MainService("Cleaning");
        ServiceDb serviceDb = new ServiceDb();
        serviceDb.addMainService(mainService);
        SubService subService = new SubService("Home Cleaning","Clean Home",
                2000,mainService);
        SubServiceDb subServiceDb = new SubServiceDb();
        subServiceDb.addSubService(subService);
        expertService.addServiceToExpert("ali@gmail.com",subService.getName());
        ExpertDto expertDto = expertService.findExpertByEmail("ali@gmail.com");
        Assertions.assertEquals("Home Cleaning",expertDto.getSubServiceList().get(0));
    }
    @Test
    void giveExpertEmailAndSubServiceName_checkExistOfSubService_trueOutput(){
        MainService mainService = new MainService("Cleaning");
        ServiceDb serviceDb = new ServiceDb();
        serviceDb.addMainService(mainService);
        SubService subService = new SubService("Home Cleaning","Clean Home",
                2000,mainService);
        SubServiceDb subServiceDb = new SubServiceDb();
        subServiceDb.addSubService(subService);
        expertService.addServiceToExpert("ali@gmail.com",subService.getName());
        ExpertDto expertDto = expertService.findExpertByEmail("ali@gmail.com");
        Assertions.assertEquals(true,
                expertService.checkExistenceOfSubServiceInExpertSubServiceList(expertDto,"Home Cleaning"));
    }
    @Test
    void giveValidExpertEmailAndSubServiceName_deleteSubServiceFromExpert_noExistenceOfSubService(){
        MainService mainService = new MainService("Cleaning");
        ServiceDb serviceDb = new ServiceDb();
        serviceDb.addMainService(mainService);
        SubService subService = new SubService("Home Cleaning","Clean Home",
                2000,mainService);
        SubServiceDb subServiceDb = new SubServiceDb();
        subServiceDb.addSubService(subService);
        expertService.addServiceToExpert("ali@gmail.com",subService.getName());
        expertService.deleteServiceFromExpert("ali@gmail.com","Home Cleaning");
        ExpertDto expertDto = expertService.findExpertByEmail("ali@gmail.com");
        Assertions.assertNotEquals(null,expertDto.
                getSubServiceList());
    }
}


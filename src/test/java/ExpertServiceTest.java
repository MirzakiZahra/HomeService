import ir.config.SpringConfig;
import ir.data.repository.ServiceRepository;
import ir.data.repository.SubServiceRepository;
import ir.data.dto.ExpertDto;
import ir.exception.InputException;
import ir.data.model.services.MainService;
import ir.data.model.services.SubService;
import ir.service.MainServiceService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ir.service.ExpertService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ExpertServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    ExpertService expertService= context.getBean(ExpertService .class);
    ServiceRepository serviceRepository ;
    SubServiceRepository subServiceRepository ;

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
        ExpertDto expertDto = preTasks();
        Assertions.assertEquals("Home Cleaning",expertDto.getSubServiceList().get(0).getName());
    }
    @Test
    void giveExpertEmailAndSubServiceName_checkExistOfSubService_trueOutput(){
        ExpertDto expertDto = preTasks();
        Assertions.assertEquals(true,
                expertService.checkExistenceOfSubServiceInExpertSubServiceList(expertDto,"Home Cleaning"));
    }
    @Test
    void giveValidExpertEmailAndSubServiceName_deleteSubServiceFromExpert_noExistenceOfSubService(){
        ExpertDto expertDto = preTasks();
        Assertions.assertNotEquals(null,expertDto.
                getSubServiceList());
    }
    public ExpertDto preTasks(){
        MainService mainService = new MainService("Cleaning");
        serviceRepository.save(mainService);
        SubService subService = new SubService("Home Cleaning","Clean Home",
                2000,mainService);

        subServiceRepository.save(subService);
        expertService.addServiceToExpert("ali@gmail.com",subService.getName());
        return expertService.findExpertByEmail("ali@gmail.com");
    }
    /*@Test
    void giveScoreAndOrderId_updateExpertScore_accurateScore(){
        OrderService orderService = new OrderService();
        CustomerService customerService = new CustomerService();
        AddressDto addressDto = AddressDto.builder()
                .country("Iran")
                .city("Tehran")
                .street("Imam")
                .plaque("5")
                .build();
        customerService.createCustomer("Zahra","Mirzaki",
                addressDto,"mirzaki1@gmail.com","Z@hra123456");
        orderService.createOrder(60000,"Hahaha",
                convertStringToDate("12/11/1400,20:00"),
                convertStringToDate("12/11/1400,22:00"),"NoWhere","mirzaki1@gmail.com",1);
        Offer offer = Offer.builder()
                .expert()
                .build()
        expertService.updateExpertScore(5,1);
        Assertions.assertEquals(5,expertService.findExpertByEmail("ali@gmail.com").getScore());
    }
    public static Date convertStringToDate(String date) {
        Date date1 = new Date();
        SimpleDateFormat formatter =
                new SimpleDateFormat("dd/MM/yyyy,HH:mm");
        try {
            date1 = formatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date1;
    }
    */
}


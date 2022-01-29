import ir.data.dto.AddressDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ir.service.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OfferServiceTest {
    OfferService offerService ;
    ExpertService expertService = new ExpertService();
    CustomerService customerService ;
    MainServiceService mainServiceService;
    SubServiceService subServiceService;
    OrderService orderService = new OrderService();
    @BeforeEach
    void init(){
        AddressDto addressDto = AddressDto.builder()
                .country("Iran")
                .city("Tehran")
                .street("Imam")
                .plaque("5")
                .build();
        customerService.createCustomer("Zahra","Mirzaki",
                addressDto,"mirzaki1@gmail.com","Z@hra123456");
        mainServiceService.createMainService("Cleaning");
        subServiceService.createSubService("CleanHome","Nothing",8000,
                "Cleaning");
        orderService.createOrder(80000,"Nothing to say",
                convertStringToDate("12/11/1400,20:00"), convertStringToDate("12/11/1400,21:00"),
                "Tehran","mirzaki1@gmail.com",1);
    }
    @Test
    void giveRequiredOfferData_createOfferThenFindOffer_createAndFindAccurately(){
        expertService.createExpert("Ali", "Alavi", "ali@gmail.com");
        offerService.createOffer(10000,1,8000,convertStringToDate("12/11/1400,20:00"),
                convertStringToDate("10/11/1400,21:00"),"ali@gmail.com");
        Assertions.assertEquals(1,offerService.findOfferById(1).getId());
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
}

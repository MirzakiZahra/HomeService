import dto.AddressDto;
import model.Orders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import service.CustomerService;
import service.MainServiceService;
import service.OrderService;
import service.SubServiceService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceTest {
    OrderService orderService = new OrderService();
    AddressDto addressDto = new AddressDto();
    CustomerService customerService = new CustomerService();
    MainServiceService mainServiceService = new MainServiceService();
    SubServiceService subServiceService = new SubServiceService();
    @BeforeEach
    void init(){
        addressDto = AddressDto.builder()
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
    void giveOrderId_findOrderById_trueOrder(){
        Orders order = orderService.findOrderByIdReturnOrder(1);
        Assertions.assertEquals(80000,order.getPrice());
        Assertions.assertEquals("Nothing to say",order.getExplanation());
        Assertions.assertEquals(convertStringToDate("12/11/1400,20:00"),
                order.getBeggingDate());
        Assertions.assertEquals(convertStringToDate("12/11/1400,21:00"),
                order.getEndingTime());
        Assertions.assertEquals("mirzaki1@gmail.com",order.getCustomer().getEmail());
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

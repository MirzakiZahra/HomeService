import ir.config.SpringConfig;
import ir.data.repository.ExpertRepository;
import ir.data.dto.AddressDto;
import ir.data.model.Offer;
import ir.data.model.Orders;
import ir.data.model.enums.OrderStatus;
import ir.data.model.user.Customer;
import ir.data.model.user.Expert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ir.service.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    OrderService orderService = context.getBean(OrderService.class);
    MainServiceService mainServiceService= context.getBean(MainServiceService.class);
    CustomerService customerService= context.getBean( CustomerService.class);
    AddressDto addressDto = new AddressDto();
    SubServiceService subServiceService= context.getBean( SubServiceService .class);
    ExpertService expertService= context.getBean( ExpertService .class);
    OfferService offerService= context.getBean( OfferService  .class);

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
    @Test
    void giveOrderAndNewStatus_changeOrderStatus_accurateOrderStatus(){
        orderService.changeOrderStatus(OrderStatus.DONE,1);
        Orders orders = orderService.findOrderByIdReturnOrder(1);
        Assertions.assertEquals(OrderStatus.DONE,orders.getOrderStatus());
    }
    @Test
    void giveOrderAndOffer_setOfferForOrder_offerSetAccurately(){
        expertService.createExpert("Ali", "Alavi", "ali@gmail.com");
        Orders orders = orderService.findOrderByIdReturnOrder(1);
        offerService.createOffer(10000,1,8000,
                convertStringToDate("10/11/1400,20:30"),convertStringToDate("10/11/1400,20:30"),
                "ali@gmail.com");
        Offer offer = offerService.findOfferById(1);
        orderService.setOfferForSpecificOrder(1);
        orders=orderService.findOrderByIdReturnOrder(1);
        Assertions.assertEquals(1,orders.getPreferredOffer().getId());
    }
    @Test
    void giveCustomerAndOrder_transferMoney_accurateCredit(){
        expertService.createExpert("Ali", "Alavi", "ali@gmail.com");
        Customer customer = customerService.findCustomerByEmail("mirzaki1@gmail.com");
        customer.setCredit(150000);
        customerService.updateCustomer(customer);
        orderService.transferMoney(1,"ali@gmail.com");
        Assertions.assertEquals(70000,
                customerService.findCustomerByEmail("mirzaki1@gmail.com").getCredit());
    }
    @Test
    void giveCustomer_showCustomerDoneOrder_accurateOrder(){
        orderService.changeOrderStatus(OrderStatus.DONE,1);
        Assertions.assertEquals(1,orderService.customerDoneOrder(1).get(0).getId());
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

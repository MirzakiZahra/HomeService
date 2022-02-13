package ir.web;

import ir.data.dto.AddressDto;
import ir.data.dto.CustomerDto;
import ir.data.dto.OrderDto;
import ir.data.dto.SubServiceDto;
import ir.service.CustomerService;
import ir.service.OrderService;
import ir.service.SubServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"addressDto","customerDto"})
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SubServiceService subServiceService;
    @Autowired
    private OrderService orderService;
    @ModelAttribute("addressDto")
    public AddressDto createAddressDtoObject() {
        return new AddressDto();
    }

   @ModelAttribute("customerDto")
    public CustomerDto createCustomerDtoObject() {
        return new CustomerDto();
    }


    @RequestMapping(value = "/customerSignUp")
    public String customerSignUp(@ModelAttribute("addressDto") AddressDto addressDto,
                          @ModelAttribute("customerDto") CustomerDto customerDto) {
        customerService.createCustomer(customerDto.getFirstName(), customerDto.getLastName(), addressDto
                , customerDto.getEmail(), customerDto.getPassword());
        return "customer/customerMainPage";
    }
    @RequestMapping(value = "/displaySignUp")
    public String displaySignUpPage(){
        return "customer/customerRegister";
    }
    @RequestMapping(value = "/displayChange")
    public String displayChangePassword(){
        return "customer/customerChangePassword";
    }

    @RequestMapping(value = "/ChangePassword")
    public String customerChangePassword
            (@RequestParam(name = "email") String email,
             @RequestParam(name = "oldPass") String oldPassword,
             @RequestParam(name = "newPass") String newPassword, Model model){
        customerService.checkOldPassword(oldPassword);
        customerService.changePassword(newPassword,email);
        model.addAttribute("succ_massage", "successfuly changed");
        return "customer/customerChangePassword";
    }
   /* public String addOrderCustomer(@ModelAttribute("orderDto")OrderDto orderDto,
                                   @ModelAttribute("subServiceDto")SubServiceDto subServiceDto){
        List<SubServiceDto> subServiceDtoList = subServiceService.showAllSubService();
        subServiceDtoList.stream().forEach(i -> System.out.println(i));
        orderService.createOrder(orderDto.getPrice(),orderDto.getExplanation(),
                orderDto.getBeggingDate(),orderDto.getEndingTime(),orderDto.getAddress()
                ,));
    }*/
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
  public String ShowOffersForSpecificOrder(@ModelAttribute("orderDto")OrderDto orderDto,
                                           @RequestParam(name = "OrderId") int orderId){
      orderService.findOrderById(orderId);
   orderDto.getOfferList().stream().forEach(i -> System.out.println(i));
   return
  }

}

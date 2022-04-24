package ir.web.customer;

import ir.data.dto.AddressDto;
import ir.data.dto.CustomerDto;
import ir.data.dto.OrderDto;
import ir.data.dto.SubServiceDto;
import ir.service.CustomerService;
import ir.service.ExpertService;
import ir.service.OrderService;
import ir.service.SubServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes({"addressDto", "customerDto"})
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private SubServiceService subServiceService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ExpertService expertService;

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
        customerService.createCustomer(customerDto.getFirstName(), customerDto.getLastName(),
                addressDto, customerDto.getEmail(), customerDto.getPassword());
        return "customer/customerMainPage";
    }

    @RequestMapping(value = "/displaySignUp")
    public String displaySignUpPage() {
        return "customer/customerRegister";
    }

    @RequestMapping(value = "/displayChange")
    public String displayChangePassword() {
        return "customer/customerChangePassword";
    }

    @RequestMapping(value = "/ChangePassword")
    public String customerChangePassword
            (@RequestParam(name = "email") String email,
             @RequestParam(name = "oldPass") String oldPassword,
             @RequestParam(name = "newPass") String newPassword, Model model) {
        customerService.checkOldPassword(oldPassword);
        customerService.changePassword(newPassword, email);
        model.addAttribute("succ_massage", "successfuly changed");
        return "customer/customerMainPage";
    }

    @RequestMapping("/showAllSubService")
    public String showAllSubService(ModelMap model) {
        List<SubServiceDto> subServiceDtoList = subServiceService.showAllSubService();
        model.addAttribute("subServiceDtoList", subServiceDtoList);
        return "customer/showSubService";
    }
    @RequestMapping(value = "/displayOrderPage")
    public String displayOrder() {
        return "customer/createOrder";
    }
    @RequestMapping(value = "/orderCreate")
    public String createOrder(@RequestParam(name = "cost") float cost,
                              @RequestParam(name="explanation") String explanation,
                              @RequestParam(name="beggingDate") String beggingDate,
                              @RequestParam(name="endingDate") String endingDate,
                              @RequestParam(name="address") String address,
                              @RequestParam(name = "email") String email,
                              @RequestParam(name = "subServiceId") int subServiceId) {
        orderService.createOrder(cost,explanation,
                convertStringToDate(beggingDate),
                convertStringToDate(endingDate),
                address,email, subServiceId);
        return "customer/customerChangePassword";
    }

    @RequestMapping("/ShowOrderListDone")
    public String showOrderListForScore(ModelMap model,
                                        @ModelAttribute("customerDto") CustomerDto customerDto) {
        List<OrderDto> orderDtoList = orderService.
                customerDoneOrder(customerDto.getId());
        model.addAttribute("orderDtoList ", orderDtoList);
        return "customer/showOrderListForScore";
    }

    /*public String addOrderByCustomer(@ModelAttribute("orderDto")OrderDto orderDto,
                                    @ModelAttribute("subServiceDto")SubServiceDto subServiceDto){
         List<SubServiceDto> subServiceDtoList = subServiceService.showAllSubService();
         subServiceDtoList.stream().forEach(i -> System.out.println(i));
         orderService.createOrder(orderDto.getPrice(),orderDto.getExplanation(),
                 orderDto.getBeggingDate(),orderDto.getEndingTime(),orderDto.getAddress()
                 ,);
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

    /*   @RequestMapping(value = "/ShowOffer")
     public String ShowOffersForSpecificOrder(@ModelAttribute("orderDto")OrderDto orderDto){
         orderService.findOrderById(orderDto.getId());
      orderDto.getOfferList().stream().forEach(i -> System.out.println(i));
      return "customer/customerOffer";
     }*/
    @RequestMapping(value = "/select")
    public String SelectExpert(@RequestParam(name = "offerId") int offerId) {
        orderService.chooseExpertForSpecificOrder(offerId);
        return "customer/customerSelectExpert";
    }

    @RequestMapping(value = "/score")
    public String Score(@RequestParam(name = "orderId") int orderId,
                        @RequestParam(name = "score") float score
    ) {
        expertService.updateExpertScore(score, orderId);
        return "customer/customerScore";

    }



}

package ir.web;

import ir.data.dto.AddressDto;
import ir.data.dto.CustomerDto;
import ir.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"addressDto","customerDto"})
@RequiredArgsConstructor
public class CustomerController {
    @Autowired
    private CustomerService customerService;
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
                          @ModelAttribute("customerDto") CustomerDto customerDto,
                          Model model) {
        customerService.createCustomer(customerDto.getFirstName(), customerDto.getLastName(), addressDto
                , customerDto.getEmail(), customerDto.getPassword());
        return "customerRegister";
    }
    @RequestMapping(value = "/displaySignUp")
    public String displaySignUpPage(){
        return "customerRegister";
    }
}

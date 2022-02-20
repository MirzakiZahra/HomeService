package ir.web.expert;

import ir.data.dto.AddressDto;
import ir.data.dto.CustomerDto;
import ir.data.dto.ExpertDto;
import ir.service.CustomerService;
import ir.service.ExpertService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class ExpertController {
    @Autowired
    private ExpertService expertService;
    @RequestMapping(value = "/displaySignUpExpert")
    public String displaySignUpPageExpert() {
        return "expert/expertRegister";
    }
    @RequestMapping(value = "/expertSignUp")
    public String expertSignUp(@ModelAttribute("expertDto")ExpertDto expertDto) {
        expertService.createExpert(expertDto.getFirstName(),expertDto.getLastName(),
                expertDto.getEmail());
        return "expert/expertMainPage";
    }
}

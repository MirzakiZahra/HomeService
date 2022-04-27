package ir.web;

import ir.data.dto.AddressDto;
import ir.data.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller

@RequiredArgsConstructor
public class aaaa {
    @RequestMapping(value = "/index")
    public String customerSignUp() {
        return "/index";
    }
}

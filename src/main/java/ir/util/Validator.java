package ir.util;

import ir.config.SpringConfig;
import ir.exception.InputException;
import ir.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Validator {
    static ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static CustomerService customerService = context.getBean(CustomerService.class);
    public boolean checkPassword(String password) {
        if (!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"))
            throw new InputException("Weak Password");
        return true;
    }
    public  boolean checkEmail(String email) {
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new InputException("Format is Wrong");
        }
        return true;
    }
    public boolean checkEmailPatternAndExistence(String email){
        if (email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")){
            if (customerService.checkExistenceOfCustomerByEmail(email)== false){
                return true;
            }
            throw new InputException("Email Exist");
        }
        throw new InputException("Format is Wrong");
    }
}

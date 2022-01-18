package util;

import exception.InputException;
import service.CustomerService;

public class Validator {
    CustomerService customerService = new CustomerService();
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
            if (customerService.findCustomerByEmail(email).equals(null)){
                return true;
            }
            throw new InputException("Email Exist");
        }
        throw new InputException("Format is Wrong");
    }
}

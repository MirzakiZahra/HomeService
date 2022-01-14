package util;

import exception.InputException;
import model.user.Customer;
import service.CustomerService;

public class Validator {
    public void checkPassword(String password){
        if (!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"))
            throw new InputException("Weak Password");
    }
}

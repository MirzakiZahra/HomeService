package util;

import exception.InputException;

public class Validator {
    public void checkPassword(String password) {
        if (!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$"))
            throw new InputException("Weak Password");
    }
    public static void checkEmail(String email) {
        if (!email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
            throw new InputException("Format is Wrong");
    }
}

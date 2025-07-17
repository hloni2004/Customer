package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

public class Helper {

    public static boolean NotValidString(String str){

        return str == null || str.trim().isEmpty();
    }

    public static  boolean ValidEmail(String email){

        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }
}

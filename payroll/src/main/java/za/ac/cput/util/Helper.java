package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

public class Helper {

    public static boolean NotValidString(String str){

        if(str.isEmpty() && str == null){
            return true;
        }
        return false;
    }

    public static  boolean ValidEmail(String email){

        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }
}

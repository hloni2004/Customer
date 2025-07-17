package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.random.RandomGenerator;

public class Helper {

    public static boolean validString(String str) {

        if (!(str == null || str.isEmpty())) {
            return true;
        }
        return false;
    }

    public static boolean validInteger(int number){
        if(number > 0 ){
            return true;
        }
        return false;
    }

    public static boolean ValidEmail(String Email){

        EmailValidator validator = EmailValidator.getInstance();
        return  validator.isValid(Email);
    }



}

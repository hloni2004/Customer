package za.ac.cput.factory;

import za.ac.cput.domain.Employee;
import za.ac.cput.util.Helper;

import java.time.LocalDate;

public class EmployeeFactory {


    public static  Employee createEmployee(String EmployeeNumber , String firstName, String lastName, String email, String identityNumber){

        if((Helper.NotValidString(EmployeeNumber) || Helper.NotValidString(firstName)||
                Helper.NotValidString(lastName)|| Helper.NotValidString(identityNumber))){
            return null;
        }
        if(!Helper.ValidEmail(email)){
            return null;
        }

        return new Employee.Builder().setEmployeeNumber(EmployeeNumber).setFirstName(firstName).setLastName(lastName).
                setEmail(email).
                setIdentityNumber(identityNumber).build();
    }
}

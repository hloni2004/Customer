package za.ac.cput.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity

public class Employee {
    @Id
    private String EmployeeNumber;
    private String firstName;
    private String lastName;
    private String email;
  //  private LocalDate dateOfBirth;
    private String identityNumber;

    protected Employee(){

    }
    public Employee(Builder build){
        this.EmployeeNumber = build.EmployeeNumber;
        this.firstName = build.firstName;
        this.lastName = build.lastName;
        this.email = build.email;
      //  this.dateOfBirth= build.dateOfBirth;
        this.identityNumber = build.identityNumber;
    }

    public String getEmployeeNumber() {
        return EmployeeNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

  //  public LocalDate getDateOfBirth() {
//        return dateOfBirth;
//    }
    public String getIdentityNumber() {
        return identityNumber;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeNumber='" + EmployeeNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +

                ", identityNumber=" + identityNumber + '\'' +
                '}';
    }

    public static class Builder{
        private String EmployeeNumber;
        private String firstName;
        private String lastName;
        private String email;
//private LocalDate dateOfBirth;
        private String identityNumber;

        public  Builder setEmployeeNumber(String employeeNumber) {
            EmployeeNumber = employeeNumber;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

//        public Builder setDateOfBirth(LocalDate dateOfBirth) {
//            this.dateOfBirth = dateOfBirth;
//            return this;
//        }

        public Builder setIdentityNumber(String identityNumber) {
            this.identityNumber = identityNumber;
            return this;
        }

        public Builder copy(Employee employee) {
            this.EmployeeNumber = employee.EmployeeNumber;
            this.firstName = employee.firstName;
            this.lastName = employee.lastName;
            this.email = employee.email;
           // this.dateOfBirth = employee.dateOfBirth;
            this.identityNumber = employee.identityNumber;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }







}

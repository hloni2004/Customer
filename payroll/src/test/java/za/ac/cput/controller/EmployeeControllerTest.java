package za.ac.cput.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeControllerTest {

    private static Employee employee;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/payroll/employee";

    @BeforeAll
    public static void setup(){
        employee = EmployeeFactory.createEmployee("021458","hloni","mokoena","hloniyacho@gmail.com","0402165695089");
    }



    @Test
    void a_createEmployee() {
//        String url = BASE_URL + "/create";
//        Employee createdEmployee = this.restTemplate.postForObject(url,employee, Employee.class);
//        assertNotNull(createdEmployee);
//        //Employee employeeSaved = postResponse.getBody();
//        assertEquals(employee.getEmployeeNumber(),createdEmployee.getEmployeeNumber());
//        System.out.println("Created" + createdEmployee);

        String url = BASE_URL + "/create";
        ResponseEntity<Employee> postResponse = this.restTemplate.postForEntity(url,employee, Employee.class);
        assertNotNull(postResponse);
        Employee employeeSaved = postResponse.getBody();
        assertEquals(employee.getEmployeeNumber(),employeeSaved.getEmployeeNumber());
        System.out.println("Created" + employeeSaved);

        
        
    }


    @Test
    void b_read() {
        String url = BASE_URL +"/read/"+ employee.getEmployeeNumber();
        ResponseEntity<Employee> reponse = this.restTemplate.getForEntity(url,Employee.class);
         assertEquals(employee.getEmployeeNumber(),reponse.getBody().getEmployeeNumber());
         System.out.println("Read"+reponse.getBody());
         
        
    }

    @Test
    void c_update() {

        Employee updatedEmployee = new Employee.Builder()
                .copy(employee)
                .setEmail("lohji@gmail.com")
                .build();
               String url = BASE_URL +"/update";
               this.restTemplate.put(url,updatedEmployee);

               ResponseEntity<Employee> response =restTemplate.getForEntity(BASE_URL+"/read/"+updatedEmployee.getEmployeeNumber(), Employee.class);

               assertEquals(response.getStatusCode(), HttpStatus.OK);

               assertNotNull(response.getBody());


        
    }

    @Test
    void d_delete()
    {
        String url = BASE_URL +"/delete/"+employee.getEmployeeNumber();
        this.restTemplate.delete(url);


        //verfiy that the was deleted
        ResponseEntity<Employee> response = this.restTemplate.getForEntity(BASE_URL+"/read/"+employee.getEmployeeNumber(),Employee.class);

        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
        System.out.println("Deleted :"+ employee.getEmployeeNumber());

    }

    @Test
    void e_getAll() {
        String url = BASE_URL +"/getAll/";
        ResponseEntity<Employee[]>response = this.restTemplate.getForEntity(url,Employee[].class);
        assertNotNull(response);
        System.out.print("Get All: ");
        for(Employee emp :response.getBody()){

            System.out.println(emp);
        }

    }
}
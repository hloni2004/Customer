package za.ac.cput.controller;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeControllerTest {

    private static Employee employee;

    @Autowired
    private TestRestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/payroll/employee";

    @BeforeAll
    public static void setup() {
        employee = EmployeeFactory.createEmployee(
                "021458", "Hloni", "Mokoena", "hloniyacho@gmail.com", "0402165695089"
        );
    }

    @Test
    void a_createEmployee() {
        String url = BASE_URL + "/create";
        ResponseEntity<Employee> postResponse = this.restTemplate.postForEntity(url, employee, Employee.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        Employee savedEmployee = postResponse.getBody();
        assertEquals(employee.getEmployeeNumber(), savedEmployee.getEmployeeNumber());
        System.out.println("Created: " + savedEmployee);
    }

    @Test
    void b_readEmployee() {
        String url = BASE_URL + "/read/" + employee.getEmployeeNumber();
        ResponseEntity<Employee> response = this.restTemplate.getForEntity(url, Employee.class);

        assertNotNull(response, "Read response is null");
        assertNotNull(response.getBody(), "Employee read is null");

        Employee readEmployee = response.getBody();
        System.out.println("Read: " + readEmployee);

        assertEquals(employee.getEmployeeNumber(), readEmployee.getEmployeeNumber(), "Employee numbers do not match");
    }

    @Test
    void c_updateEmployee() {
        Employee updatedEmployee = new Employee.Builder()
                .copy(employee)
                .setEmail("lohji@gmail.com")
                .build();

        String url = BASE_URL + "/update";
        this.restTemplate.put(url, updatedEmployee);

        ResponseEntity<Employee> response = this.restTemplate.getForEntity(
                BASE_URL + "/read/" + updatedEmployee.getEmployeeNumber(), Employee.class
        );

        assertNotNull(response, "Update read response is null");
        assertNotNull(response.getBody(), "Updated employee is null");

        Employee updated = response.getBody();
        System.out.println("Updated: " + updated);

        assertEquals("lohji@gmail.com", updated.getEmail(), "Email was not updated correctly");
    }

    @Test
    void d_deleteEmployee() {
        String url = BASE_URL + "/delete/" + employee.getEmployeeNumber();
        this.restTemplate.delete(url);

        ResponseEntity<Employee> response = this.restTemplate.getForEntity(
                BASE_URL + "/read/" + employee.getEmployeeNumber(), Employee.class
        );

        assertNull(response.getBody(), "Employee was not deleted");
        System.out.println("Deleted: " + employee.getEmployeeNumber());
    }

    @Test
    void e_getAllEmployees() {
        String url = BASE_URL + "/getAll";
        ResponseEntity<Employee[]> response = this.restTemplate.getForEntity(url, Employee[].class);

        assertNotNull(response, "GetAll response is null");
        assertNotNull(response.getBody(), "GetAll returned no data");

        System.out.println("All Employees:");
        for (Employee emp : response.getBody()) {
            System.out.println(emp);
        }
    }
}
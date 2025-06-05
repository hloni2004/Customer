package za.ac.cput.service;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Employee;
import za.ac.cput.factory.EmployeeFactory;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeServiceTest {

    @Autowired
    private  EmployeeService service ;


    private Employee employee = EmployeeFactory.createEmployee("23023689","hloni","mokoena","hloniyacho@gmail.com","0402165695089");


    @Test
    void a_create() {
        Employee newEmployee = service.create(employee);
        assertNotNull(newEmployee);
        System.out.println(newEmployee);
    }

    @Test
    void b_read() {
        Employee read = service.read(employee.getEmployeeNumber());
        assertNotNull(read);
        System.out.println(read);
    }

    @Test
    void c_update() {
        Employee newEmployee = new Employee.Builder().copy(employee).copy(employee).setFirstName("hlokoloza").build();
        Employee updatedEmployee = service.update(newEmployee);
        assertNotNull(updatedEmployee);
        System.out.println(updatedEmployee);
    }


    @Test
    void e_getAll() {
        System.out.println(service.getAll());
    }
}
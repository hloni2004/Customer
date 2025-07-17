package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Employee;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeFactoryTest {
  Employee employee = EmployeeFactory.createEmployee("021458","hloni","mokoena","hloniyacho@gmail.com","0402165695089");

    @Test
    void createEmployee() {
        assertNotNull(employee);
        System.out.println(employee);
    }
}
package za.ac.cput.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Employee;
import za.ac.cput.service.EmployeeService;

import java.util.List;

// this where we expose services
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService service;


    @Autowired
    public EmployeeController(EmployeeService service){

        this.service = service;
    }
    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {

        return service.create(employee);
    }


    @GetMapping("/read/{employeeNumber}")
    public Employee read(@PathVariable String employeeNumber){

        return service.read(employeeNumber);
    }
    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee){

        return service.update(employee);
    }
    @DeleteMapping ("/delete/{employeeNumber}")
    public boolean delete(@PathVariable String employeeNumber){

        return service.delete(employeeNumber);
    }

    @GetMapping("/getAll")
    public List<Employee> getAll(){
        return service.getAll();
    }
    }


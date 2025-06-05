package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;
import za.ac.cput.repository.EmployeeRepository;
import java.util.List;
@Service

public class EmployeeService implements IEmployeeService{


    private EmployeeRepository repository;



@Autowired EmployeeService(EmployeeRepository repository){

    this.repository = repository;
}


    @Override
    public Employee create(Employee employee) {

        return this.repository.save(employee);
    }

    @Override
    public Employee read(String id) {
        return this.repository.findById(id).orElse(null);

    }
// jpa that you will use it save
    @Override
    public Employee update(Employee employee) {

        return this.repository.save(employee);
    }
    public boolean delete(String employeeNumber){
         this.repository.deleteById(employeeNumber);
        return true;
    }
    @Override
    public List<Employee> getAll() {

        return  this.repository.findAll();
    }
}

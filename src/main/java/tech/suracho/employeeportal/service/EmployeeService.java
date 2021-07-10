package tech.suracho.employeeportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.suracho.employeeportal.exceptions.UserFoundException;
import tech.suracho.employeeportal.model.Employee;
import tech.suracho.employeeportal.repo.EmployeeRepo;

import java.util.List;
import java.util.UUID;



@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }
    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(()->new UserFoundException("User with id "+ id + "not found"));
//        if (employeeRepo.findEmployeeById(id) == null) {
//            throw new UserFoundException("User not found");
//        } else {
//            return employeeRepo.findEmployeeById(id);
//        }
    }
}

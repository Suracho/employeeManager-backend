package tech.suracho.employeeportal.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.suracho.employeeportal.model.Employee;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);
//    Employee findEmployeeById(Long id);
}

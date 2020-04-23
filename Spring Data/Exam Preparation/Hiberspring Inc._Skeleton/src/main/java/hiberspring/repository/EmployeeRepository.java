package hiberspring.repository;

import hiberspring.domain.entities.Employee;
import hiberspring.domain.entities.EmployeeCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByFirstNameAndLastNameAndPosition(String firstName,String lastName,String position);
    Employee findByEmployeeCard(EmployeeCard employeeCard);

    @Query(value = "SELECT e FROM Employee as e " +
            "WHERE e.branch.products.size > 0 " +
            "ORDER BY CONCAT(e.firstName, ' ' , e.lastName), LENGTH(e.position) DESC ")
    List<Employee> getAllProductiveEmployees();
}

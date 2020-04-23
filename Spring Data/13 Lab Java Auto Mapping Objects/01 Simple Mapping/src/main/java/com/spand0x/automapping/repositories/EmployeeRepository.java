package com.spand0x.automapping.repositories;

import com.spand0x.automapping.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByFirstName(String firstName);
}

package com.spand0x.advancedmapping.repositories;

import com.spand0x.advancedmapping.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Employee findByFirstName(String firstName);
}

package com.spand0x.xmlcardealer.repositories;

import com.spand0x.xmlcardealer.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer getByName(String name);
    List<Customer> getAllByIdIsNotNullOrderByBirthDateAscYoungDriverAsc();

    @Query("SELECT c.name,c.sales.size, SUM(p.price) FROM Customer c " +
            "JOIN Sale s ON c.id = s.customer.id " +
            "JOIN Car ca ON s.car.id = ca.id " +
            "JOIN ca.parts p " +
            "group by c.id " +
            "ORDER BY SUM(p.price)DESC , c.sales.size DESC")
    List<List<String>> getCustomersWithSales();
}

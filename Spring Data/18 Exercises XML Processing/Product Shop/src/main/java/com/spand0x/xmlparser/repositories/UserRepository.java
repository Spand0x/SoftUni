package com.spand0x.xmlparser.repositories;

import com.spand0x.xmlparser.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Set<User> getAllByBoughtIsNotNullOrderByLastNameAscFirstNameAsc();

    @Query("SELECT u FROM User u " +
            "JOIN Product p " +
            "ON p.seller.id = u.id " +
            "WHERE u.sold.size > 0 " +
            "GROUP BY u.id " +
            "ORDER BY u.sold.size DESC, u.lastName ASC")
    List<User> getUsersWithAtLeastOneSellingProduct();
}

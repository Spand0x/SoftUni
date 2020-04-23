package alararestaurant.repository;

import alararestaurant.domain.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    @Query(value = "SELECT o FROM Order o WHERE o.employee.position.name = :position ORDER BY o.employee.name, o.id")
    List<Order> getAllByPositionName(String position);
}

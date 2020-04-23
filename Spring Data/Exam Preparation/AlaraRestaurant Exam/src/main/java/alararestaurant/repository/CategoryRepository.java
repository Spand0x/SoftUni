package alararestaurant.repository;

import alararestaurant.domain.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "SELECT c FROM Category c JOIN Item i ON c = i.category GROUP BY c.id ORDER BY c.items.size DESC,SUM(i.price) DESC ")
    List<Category> findAllCategories();

    Category findByName(String name);
}

package com.spand0x.xmlparser.repositories;

import com.spand0x.xmlparser.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> getAllByPriceBetweenOrderByPriceAsc(BigDecimal min, BigDecimal max);
}

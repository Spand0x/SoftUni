package com.spand0x.xmlcardealer.repositories;

import com.spand0x.xmlcardealer.models.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Supplier findByName(String name);
    Set<Supplier> getAllByImporterFalse();
}

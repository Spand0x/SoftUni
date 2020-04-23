package com.spand0x.usersystem.repositories;

import com.spand0x.usersystem.entities.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town,Long> {

}

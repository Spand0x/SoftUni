package com.spand0x.gamestore.repositories;

import com.spand0x.gamestore.domain.dtos.UserLoginDto;
import com.spand0x.gamestore.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

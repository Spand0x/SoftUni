package com.spand0x.springintro.repositories;

import com.spand0x.springintro.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getByUsername(String username);

}

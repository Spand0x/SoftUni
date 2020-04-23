package com.spand0x.advancequering.repositories;


import com.spand0x.advancequering.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
    List<Author> findAllByFirstNameEndsWith(String ending);

    List<Author> findAllByLastNameStartsWithIgnoreCase(String start);

    @Procedure(name = "udp_find_books_by_author")
    int getAuthorBooksCount(@Param("first_name") String first_name, @Param("last_name") String last_name);
}

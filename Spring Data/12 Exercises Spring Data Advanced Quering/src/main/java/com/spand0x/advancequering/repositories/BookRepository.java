package com.spand0x.advancequering.repositories;

import com.spand0x.advancequering.entities.AgeRestriction;
import com.spand0x.advancequering.entities.Book;
import com.spand0x.advancequering.entities.ReducedBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBookByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(String firstName, String lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByCopiesLessThan(int copies);

    List<Book> findAllByPriceIsLessThanOrPriceGreaterThan(BigDecimal lowerPrice, BigDecimal higherPrice);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByTitleContainsIgnoreCase(String characters);

    @Query("SELECT COUNT(b.title) FROM Book AS b WHERE LENGTH(b.title)> :length ")
    int getBooksByTitleLength(@Param(value = "length") int length);

    @Query("SELECT b.author.firstName AS firstName," +
            "b.author.lastName AS lastName," +
            "SUM(b.copies) AS nCopies " +
            "FROM Book AS b GROUP BY b.author ORDER BY nCopies DESC")
    List<Object[]> getBooksCopiesPerAuthor();

    ReducedBook getBookByTitle(String title);

    @Modifying
    @Query("UPDATE Book AS b SET b.copies = b.copies*:copies WHERE b.releaseDate>:date")
    int increaseCopiesOfBooksReleasedAfterDate( @Param("date") LocalDate date,@Param("copies")int copies);

    List<Book> findAllByReleaseDateAfter(LocalDate date);

    @Modifying
    int deleteBooksByCopiesIsLessThan(int copies);

}

package com.spand0x.advancequering.services;

import com.spand0x.advancequering.entities.AgeRestriction;
import com.spand0x.advancequering.entities.Book;
import com.spand0x.advancequering.entities.ReducedBook;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> getAllBooksByAuthor(String firstName, String lastName);

    List<Book> findAllBookByAge(AgeRestriction ageRestriction);

    List<Book> findBooksWithLessCopiesThan(int number);

    List<Book> findBooksWithPriceNotBetween(BigDecimal lowerPrice, BigDecimal higherPrice);

    List<Book> findBooksExceptReleasedYear(int year);

    List<Book> getAllBooksBefore(String year);

    List<Book> findBooksContainingString(String characters);

    int getCountOfBooksByTitleLength(int length);

    List<Object[]> getTotalBookCopiesPerAuthor();

    ReducedBook getBookByTitle(String title);

    int increaseCopiesOfBooksAfterDate(LocalDate date,int copies);

    int deleteBooksWithCopiesLessThan(int copies);

}

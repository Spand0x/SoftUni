package com.spand0x.springbookshopsystem.services;

import com.spand0x.springbookshopsystem.entities.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> getAllBookAfter(int year);

    List<Book> getAllBooksBefore(int year);

    List<Book> getAllBooksByAuthor(String firstName, String lastName);
}

package com.spand0x.springbookshopsystem.services;

import com.spand0x.springbookshopsystem.entities.Author;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    int getAuthorsCount();

    Author findAuthorById(long id);

    List<Author> findAllAuthorsByCountOfBooks();

    List<Author> findAllAuthorsByCountBooks();

}

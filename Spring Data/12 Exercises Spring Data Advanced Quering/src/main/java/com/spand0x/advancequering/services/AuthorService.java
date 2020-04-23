package com.spand0x.advancequering.services;


import com.spand0x.advancequering.entities.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    int getAuthorsCount();

    Author findAuthorById(long id);

    Author getRandomAuthor();

    List<Author> getAuthorsWithFirstNameEndingWith(String ending);

    List<Author> getTitleOfAuthorsWithLastNameStartingWith(String starting);

    int getAuthorBooksCount(String firstName,String lastName);

}

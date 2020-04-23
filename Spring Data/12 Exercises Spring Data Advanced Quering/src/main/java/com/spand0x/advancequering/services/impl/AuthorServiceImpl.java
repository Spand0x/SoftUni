package com.spand0x.advancequering.services.impl;

import com.spand0x.advancequering.constants.GlobalConstants;
import com.spand0x.advancequering.entities.Author;
import com.spand0x.advancequering.repositories.AuthorRepository;
import com.spand0x.advancequering.services.AuthorService;
import com.spand0x.advancequering.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final FileUtil fileUtil;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, FileUtil fileUtil) {
        this.authorRepository = authorRepository;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (this.authorRepository.count() != 0) {
            return;
        }
        String[] fileContent = this.fileUtil
                .readFileContent(GlobalConstants.AUTHORS_FILE_PATH);
        Arrays.stream(fileContent).forEach(r->{
            String[] params = r.split("\\s+");
            Author author = new Author(params[0],params[1]);
            this.authorRepository.saveAndFlush(author);
        });
    }

    @Override
    public int getAuthorsCount() {
        return (int) this.authorRepository.count();
    }

    @Override
    public Author findAuthorById(long id) {
        return this.authorRepository.getOne(id);
    }

    public Author getRandomAuthor() {
        Random random = new Random();
        int randomId = random.nextInt(this.getAuthorsCount()) + 1;
        return this.findAuthorById(randomId);
    }

    @Override
    public List<Author> getAuthorsWithFirstNameEndingWith(String ending) {
        return this.authorRepository.findAllByFirstNameEndsWith(ending);
    }

    @Override
    public List<Author> getTitleOfAuthorsWithLastNameStartingWith(String starting) {
        return this.authorRepository.findAllByLastNameStartsWithIgnoreCase(starting);

    }

    @Override
    public int getAuthorBooksCount(String firstName, String lastName) {
        return this.authorRepository.getAuthorBooksCount(firstName,lastName);
    }
}

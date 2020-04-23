package com.spand0x.springbookshopsystem.services.impl;

import com.spand0x.springbookshopsystem.constants.GlobalConstants;
import com.spand0x.springbookshopsystem.entities.Author;
import com.spand0x.springbookshopsystem.repositories.AuthorRepository;
import com.spand0x.springbookshopsystem.services.AuthorService;
import com.spand0x.springbookshopsystem.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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

    @Override
    public List<Author> findAllAuthorsByCountOfBooks() {
        return this.authorRepository.findAuthorByCountOfBook();
    }

    @Override
    public List<Author> findAllAuthorsByCountBooks() {
        return this.authorRepository.getAllByIdNotNullOrderByBooksDesc();
    }

}

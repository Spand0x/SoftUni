package com.spand0x.springbookshopsystem.services.impl;


import com.spand0x.springbookshopsystem.entities.*;
import com.spand0x.springbookshopsystem.repositories.BookRepository;
import com.spand0x.springbookshopsystem.services.AuthorService;
import com.spand0x.springbookshopsystem.services.BookService;
import com.spand0x.springbookshopsystem.services.CategoryService;
import com.spand0x.springbookshopsystem.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.spand0x.springbookshopsystem.constants.GlobalConstants.BOOKS_FILE_PATH;


@Service
@Transactional
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final FileUtil fileUtil;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService, FileUtil fileUtil) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.fileUtil = fileUtil;
    }

    @Override
    public void seedBooks() throws IOException {
        if (this.bookRepository.count() != 0) {
            return;
        }
        String[] fileContent = this.fileUtil.readFileContent(BOOKS_FILE_PATH);
        Arrays.stream(fileContent).forEach(r -> {
            String[] params = r.split("\\s+");

            Author author = this.getRandomAuthor();

            EditionType editionType = EditionType.values()[Integer.parseInt(params[0])];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate releaseDate = LocalDate.parse(params[1], formatter);
            int copies = Integer.parseInt(params[2]);
            BigDecimal price = new BigDecimal(params[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(params[4])];
            String title = this.getTitle(params);
            Set<Category> categories = this.getRandomCategories();

            Book book = new Book();
            book.setAuthor(author);
            book.setEditionType(editionType);
            book.setReleaseDate(releaseDate);
            book.setCopies(copies);
            book.setPrice(price);
            book.setAgeRestriction(ageRestriction);
            book.setTitle(title);
            book.setCategories(categories);

            this.bookRepository.saveAndFlush(book);

            System.out.println();
        });
    }

    @Override
    public List<Book> getAllBookAfter(int year) {
        LocalDate releaseDate = LocalDate.of(year,12,31);
        return this.bookRepository.findAllByReleaseDateAfter(releaseDate);
    }

    @Override
    public List<Book> getAllBooksBefore(int year) {
       return this.bookRepository.findAllByReleaseDateBefore(LocalDate.of(year,1,1));
    }

    @Override
    public List<Book> getAllBooksByAuthor(String firstName, String lastName) {
        return this.bookRepository.findBookByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName,lastName);
    }

    private Set<Category> getRandomCategories() {
        Random random = new Random();
        int bound = random.nextInt(3) + 1;
        Set<Category> result = new HashSet<>();
        for (int i = 1; i <= bound; i++) {
            int randomId = random.nextInt(8) + 1;
            result.add(this.categoryService.getCategoryById(randomId));
        }
        return result;
    }

    private String getTitle(String[] params) {
        StringBuilder sb = new StringBuilder();
        for (int i = 5; i < params.length; i++) {
            sb.append(params[i]).append(" ");
        }
        return sb.toString().trim();
    }

    private Author getRandomAuthor() {
        Random random = new Random();
        int randomId = random.nextInt(authorService.getAuthorsCount()) + 1;
        return this.authorService.findAuthorById(randomId);
    }
}
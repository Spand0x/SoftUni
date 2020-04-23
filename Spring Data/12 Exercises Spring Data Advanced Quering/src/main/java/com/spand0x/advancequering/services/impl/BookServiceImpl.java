package com.spand0x.advancequering.services.impl;


import com.spand0x.advancequering.entities.*;
import com.spand0x.advancequering.repositories.BookRepository;
import com.spand0x.advancequering.services.AuthorService;
import com.spand0x.advancequering.services.BookService;
import com.spand0x.advancequering.services.CategoryService;
import com.spand0x.advancequering.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.spand0x.advancequering.constants.GlobalConstants.BOOKS_FILE_PATH;


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

            Author author = authorService.getRandomAuthor();

            EditionType editionType = EditionType.values()[Integer.parseInt(params[0])];
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            LocalDate releaseDate = LocalDate.parse(params[1], formatter);
            int copies = Integer.parseInt(params[2]);
            BigDecimal price = new BigDecimal(params[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(params[4])];
            String title = this.getTitle(params);
            Set<Category> categories = categoryService.getRandomCategories();

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
    public List<Book> getAllBooksByAuthor(String firstName, String lastName) {
        return this.bookRepository.findBookByAuthorFirstNameAndAuthorLastNameOrderByReleaseDateDescTitleAsc(firstName, lastName);
    }

    @Override
    public List<Book> findAllBookByAge(AgeRestriction ageRestriction) {
        return this.bookRepository.findAllByAgeRestriction(ageRestriction);
    }

    @Override
    public List<Book> findBooksWithLessCopiesThan(int number) {
        return this.bookRepository.findAllByCopiesLessThan(number);
    }

    @Override
    public List<Book> findBooksWithPriceNotBetween(BigDecimal lowerPrice, BigDecimal higherPrice) {
        return this.bookRepository.findAllByPriceIsLessThanOrPriceGreaterThan(lowerPrice, higherPrice);
    }

    @Override
    public List<Book> findBooksExceptReleasedYear(int year) {
        return this.bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate.of(year, 1, 1), LocalDate.of(year, 12, 31));
    }


    @Override
    public List<Book> getAllBooksBefore(String date) {
        String[] dateArr = date.split("-");
        int day = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int year = Integer.parseInt(dateArr[2]);

        LocalDate releaseDate = LocalDate.of(year, month, day);
        return this.bookRepository.findAllByReleaseDateBefore(releaseDate);
    }

    @Override
    public List<Book> findBooksContainingString(String characters) {
        return this.bookRepository.findAllByTitleContainsIgnoreCase(characters);
    }

    @Override
    public int getCountOfBooksByTitleLength(int length) {
        return this.bookRepository.getBooksByTitleLength(length);
    }

    @Override
    public List<Object[]> getTotalBookCopiesPerAuthor() {
        return this.bookRepository.getBooksCopiesPerAuthor();

    }

    @Override
    public ReducedBook getBookByTitle(String title) {
        return this.bookRepository.getBookByTitle(title);
    }

    @Override
    public int increaseCopiesOfBooksAfterDate(LocalDate date,int copies) {
        return this.bookRepository.increaseCopiesOfBooksReleasedAfterDate(date,copies) * copies;
//        List<Book> books = this.bookRepository.findAllByReleaseDateAfter(date);
//        books.forEach(b->{
//            b.setCopies(b.getCopies()*copies);
//            this.bookRepository.saveAndFlush(b);
//        });
//        return books.size()*copies;
    }

    @Override
    public int deleteBooksWithCopiesLessThan(int copies) {
        return this.bookRepository.deleteBooksByCopiesIsLessThan(copies);
    }


    private String getTitle(String[] params) {
        StringBuilder sb = new StringBuilder();
        for (int i = 5; i < params.length; i++) {
            sb.append(params[i]).append(" ");
        }
        return sb.toString().trim();
    }


}

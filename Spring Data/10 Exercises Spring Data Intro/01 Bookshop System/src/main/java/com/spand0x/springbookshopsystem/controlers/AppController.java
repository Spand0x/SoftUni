package com.spand0x.springbookshopsystem.controlers;


import com.spand0x.springbookshopsystem.services.AuthorService;
import com.spand0x.springbookshopsystem.services.BookService;
import com.spand0x.springbookshopsystem.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AppController implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();

        //Ex 1 without query
//        List<Book> booksAfterYear = this.bookService.getAllBookAfter(2000);
//        System.out.println();

        //Ex 2 without query
//        this.bookService.getAllBooksBefore(1990)
//                .forEach(b->{
//                    System.out.printf("%s %s%n",b.getAuthor().getFirstName(),
//                            b.getAuthor().getLastName());
//                });

        //Ex 3 with query
//        this.authorService.findAllAuthorsByCountOfBooks().forEach(a->{
//            System.out.printf("%s %s %d%n",a.getFirstName(),a.getLastName(),a.getBooks().size());
//        });
//
//        Ex 3 Without query
//        this.authorService.findAllAuthorsByCountBooks()
//                .forEach(a->{
//                    System.out.printf("%s %s %d%n",a.getFirstName(),a.getLastName(),a.getBooks().size());
//                });

        //Ex 4 without query
//        this.bookService.getAllBooksByAuthor("George","Powell")
//                .forEach(b->{
//                    System.out.printf("%s %s %d%n",b.getTitle(),b.getReleaseDate().toString(),b.getCopies());
//                });
    }
}

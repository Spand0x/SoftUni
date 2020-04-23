package com.spand0x.advancequering.controlers;


import com.spand0x.advancequering.entities.AgeRestriction;
import com.spand0x.advancequering.entities.Author;
import com.spand0x.advancequering.services.AuthorService;
import com.spand0x.advancequering.services.BookService;
import com.spand0x.advancequering.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;


@Controller
public class AppController implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final Scanner scanner;

    @Autowired
    public AppController(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
//        this.categoryService.seedCategories();
//        this.authorService.seedAuthors();
//        this.bookService.seedBooks();
        while (true) {
            System.out.println("\n\nEnter number of Exercise or write 0 to exit.");
            String input = scanner.nextLine();
            switch (input) {
                case "0":
                    return;
                case "1":
                    booksTitlesByAgeRestrictionEx();
                    break;
                case "2":
                    goldenBooksEx();
                    break;
                case "3":
                    booksByPriceEx();
                    break;
                case "4":
                    notReleasedBooksEx();
                    break;
                case "5":
                    booksReleasedBeforeDateEx();
                    break;
                case "6":
                    authorsSearchEx();
                    break;
                case "7":
                    booksSearchEx();
                    break;
                case "8":
                    bookTitleSearchEx();
                    break;
                case "9":
                    countBooksEx();
                    break;
                case "10":
                    totalBookCopiesEx();
                    break;
                case "11":
                    reducedBookEx();
                    break;
                case "12":
                    increaseBookCopiesEx();
                    break;
                case "13":
                    removeBooksEx();
                    break;
                case "14":
//                    todo: fix it
//                    storedProcedureEx();
                    break;
                default:

                    break;
            }
        }

    }

    private void storedProcedureEx() {
        System.out.println("Ex 14: Please enter Author Name: ");
        String[] name = scanner.nextLine().split("\\s+");
        String firstName = name[0];
        String lastName = name[1];
        System.out.println(this.authorService.getAuthorBooksCount(firstName,lastName));
    }

    private void removeBooksEx() {
        System.out.println("Ex 13: Please Enter number of copies:");
        int copies = Integer.parseInt(scanner.nextLine());
        System.out.println(this.bookService.deleteBooksWithCopiesLessThan(copies));
    }

    private void increaseBookCopiesEx() {
        System.out.println("Ex 12: Please enter date in format: (dd MMM yyyy)");
        String dateRaw = scanner.nextLine();
        System.out.println("Please enter number of copies: ");
        int copies = Integer.parseInt(scanner.nextLine());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate date = LocalDate.parse(dateRaw,dtf);
        System.out.println(this.bookService.increaseCopiesOfBooksAfterDate(date, copies));

    }

    private void reducedBookEx() {
        System.out.println("Ex 11: Please Enter Title:");
        String title = scanner.nextLine();
        System.out.println(this.bookService.getBookByTitle(title));
    }

    private void totalBookCopiesEx() {
        List<Object[]> copiesAuthors = this.bookService.getTotalBookCopiesPerAuthor();
        copiesAuthors.forEach(e -> {
            System.out.printf("%s %s - %s%n", e[0], e[1], e[2]);
        });
    }

    private void countBooksEx() {
        System.out.println("Ex 9: Please enter minimal title length:");
        int length = Integer.parseInt(scanner.nextLine());
        System.out.println(this.bookService.getCountOfBooksByTitleLength(length));
    }

    private void bookTitleSearchEx() {
        System.out.println("Ex 8 Please write the start of the last name of Author");
        String characters = scanner.nextLine();
        List<Author> authors = this.authorService.getTitleOfAuthorsWithLastNameStartingWith(characters);
        for (Author author :
                authors) {
            author.getBooks().forEach(b -> {
                System.out.printf("%s (%s %s)%n", b.getTitle(), author.getFirstName(), author.getLastName());
            });
        }
    }

    private void booksSearchEx() {
        System.out.println("Ex 7 Please Enter String");
        String characters = scanner.nextLine();
        this.bookService.findBooksContainingString(characters)
                .forEach(b -> System.out.println(b.getTitle()));
    }

    private void authorsSearchEx() {
        System.out.println("Ex 6 Please Enter Ending String for First Name");
        String ending = scanner.nextLine();
        this.authorService.getAuthorsWithFirstNameEndingWith(ending)
                .forEach(a -> {
                    System.out.printf("%s %s%n", a.getFirstName(), a.getLastName());
                });
    }

    private void booksReleasedBeforeDateEx() {
        System.out.println("Ex 5 Please Enter Date In Format : (dd-MM-yyyy)");
        String date = scanner.nextLine();
        this.bookService.getAllBooksBefore(date).forEach(b -> {
            System.out.printf("%s %s %s%n", b.getTitle(), b.getEditionType(), b.getPrice());
        });
    }

    private void notReleasedBooksEx() {
        System.out.println("Ex 4 Please Enter Year");
        int year = Integer.parseInt(scanner.nextLine());
        this.bookService.findBooksExceptReleasedYear(year).forEach(b -> System.out.println(b.getTitle()));
    }

    private void booksByPriceEx() {
        this.bookService.findBooksWithPriceNotBetween(new BigDecimal("5"), new BigDecimal("40")).forEach(b -> {
            System.out.printf("%s - $%s%n", b.getTitle(), b.getPrice());
        });
    }

    private void goldenBooksEx() {
        this.bookService.findBooksWithLessCopiesThan(5000).forEach(book -> System.out.println(book.getTitle()));
    }

    private void booksTitlesByAgeRestrictionEx() {
        System.out.println("Ex 1 Books titles by Age Restriction\nEnter Age Restriction (MINOR, TEEN, ADULT):");
        String input = scanner.nextLine().toUpperCase();
        this.bookService.findAllBookByAge(AgeRestriction.valueOf(input)).forEach(b -> {
            System.out.println(b.getTitle());
        });
    }
}

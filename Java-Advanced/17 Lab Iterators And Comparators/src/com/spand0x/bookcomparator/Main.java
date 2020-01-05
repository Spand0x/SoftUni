package com.spand0x.bookcomparator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    Book book1 = new Book("Animals",2000,"AnimalAuthh");
	    Book book2 = new Book("People",1000,"People","Animals");
	    Book book3 = new Book("People",999,"People");
        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.sort(new BookComparator());
        books.forEach(e-> System.out.println(e.getTitle() + " " +e.getYear()));
    }
}

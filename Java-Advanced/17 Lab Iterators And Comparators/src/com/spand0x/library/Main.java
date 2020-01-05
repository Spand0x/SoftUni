package com.spand0x.library;

public class Main {

    public static void main(String[] args) {
	    Book book1 = new Book("Animals",2000,"AnimalAuthh");
	    Book book2 = new Book("People",1000,"People","Animals");
	    Library<Book> library = new Library<>(book1,book2);

        for (Book book :
                library) {
            System.out.println(book.getTitle());
            System.out.println(book.getYear());
            System.out.println(book.getAuthors());
            System.out.println();
        }
    }
}

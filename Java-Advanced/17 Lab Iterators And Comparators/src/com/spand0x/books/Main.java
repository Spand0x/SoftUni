package com.spand0x.books;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Gosho",1999,"Gosho","Pesho");
        System.out.println(book.getAuthors());
        System.out.println(book.getTitle());
        System.out.println(book.getYear());
    }
}

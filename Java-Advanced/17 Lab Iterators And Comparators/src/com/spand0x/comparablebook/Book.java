package com.spand0x.comparablebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        setTitle(title);
        setYear(year);
        this.setAuthors(authors);
    }

    private void setAuthors(String... authors) {
        if(authors.length == 0){
            this.authors = new ArrayList<>();
        }else{
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return new ArrayList<>(authors);
    }

    @Override
    public int compareTo(Book o) {
        if(this.title.compareTo(o.title) == 0){
            return this.year - o.year;
        }
        return this.title.compareTo(o.title);
    }
}

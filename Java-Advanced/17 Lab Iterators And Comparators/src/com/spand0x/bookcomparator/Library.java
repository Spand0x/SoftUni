package com.spand0x.bookcomparator;

import java.util.Iterator;

public class Library<T> implements Iterable<T> {
    private T[] books;

    public Library(T... books) {
        this.books = books;
    }

    @Override
    public Iterator<T> iterator() {
        return new LibraryIterator();
    }
    private class LibraryIterator implements Iterator<T>{
        private int count;
        @Override
        public boolean hasNext() {
            return count < books.length;
        }

        @Override
        public T next() {
            return books[count++];
        }
    }
}

package com.spand0x.customListSort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Consumer;

public class CustomList<T extends Object & Comparable> {
    private static final int INITIAL_CAPACITY = 4;
    private T[] data;
    private int size;
    private int capacity;

    public CustomList() {
        this.data = (T[]) Array.newInstance(Object.class,INITIAL_CAPACITY);
        this.capacity = INITIAL_CAPACITY;
    }

    public void add(T element) {
        if (this.size == this.capacity) {
            this.resize();
        }
        this.data[this.size++] = element;
    }

    public T remove(int index) {
        checkIndex(index);
        T element = this.data[index];
        shift(index);
        this.size--;
        if (this.size <= this.capacity / 4) {
            shrink();
        }
        return element;
    }

    public int getSize(){
        return this.size;
    }

    public boolean contains(T element) {
        for (int i = 0; i < this.size; i++) {
            if (data[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void swap(int firstIndex, int secondIndex) {
        checkIndex(firstIndex);
        checkIndex(secondIndex);
        T temp = this.data[firstIndex];
        this.data[firstIndex] = this.data[secondIndex];
        this.data[secondIndex] = temp;
    }

    public int countGreaterThan(T element) {
        return (int)Arrays.stream(this.data,0,this.size)
                .filter(e->0 < e.compareTo(element))
                .count();
    }

    public T getMax() {
        return Arrays.stream(this.data,0,this.size)
                .max(T::compareTo)
                .orElse(null);
    }

    public T getMin() {
        return Arrays.stream(this.data,0,this.size)
                .min(T::compareTo)
                .orElse(null);
    }

    public void forEach(Consumer<T> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }
    }


    public T get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    private void shrink() {
        this.capacity /= 2;
        T[] copy = (T[])Array.newInstance(Object.class,this.capacity);
        for (int i = 0; i < this.data.length; i++) {
            copy[i] = this.data[i];
        }
        this.data = copy;
    }

    private void shift(int index) {
        for (int i = index; i < this.size; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[size - 1] = null;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > this.size) {
            String message = String.format("Index %d out of bounds for length %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    private void resize() {
        this.capacity *= 2;
        T[] copy = (T[])Array.newInstance(Object.class,this.capacity);
        for (int i = 0; i < this.data.length; i++) {
            copy[i] = this.data[i];
        }
        this.data = copy;
    }
}

package com.spand0x.genericBox;

public class Box<T> {
    private T name;

    public Box(T name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name.getClass().getName() + ": " + name;
    }
}

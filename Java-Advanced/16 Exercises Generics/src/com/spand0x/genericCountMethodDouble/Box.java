package com.spand0x.genericCountMethodDouble;

public class Box<T> {
    private T name;

    public Box(T name) {
        this.name = name;
    }

    public T getElement(){
        return this.name;
    }

    @Override
    public String toString() {
        return this.name.getClass().getName() + ": " + name;
    }




}

package com.spand0x.genericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class ArrayCreator {


    public static <T> T[] create(int length, T item){
        T[] array = (T[]) new Objects[length];
        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }

    public static <T> T[] create(Class<T> cl,int length, T item){
        T[] array = (T[]) Array.newInstance(cl,length);
        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }
}

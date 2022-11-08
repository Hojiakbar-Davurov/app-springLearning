package com.example.appspringlearning.generic;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Integer[] arr = {2, 3, 5};
        System.out.println(countGreater(arr, 3));

        Double[] arr1 = {2.0, 3.4, 5.2};
        System.out.println(countGreater(arr1, 3.0));
    }


    public static <T extends Comparable<T>> int countGreater(T[] arr, T number) {
        int count = 0;
        for (T i : arr) {
            if (i.compareTo(number) > 0) {
                count++;
            }
        }
        return count;
    }

    public static void print(List<? super Integer> list) {

    }
}

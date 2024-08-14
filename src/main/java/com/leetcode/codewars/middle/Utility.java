package com.leetcode.codewars.middle;

import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

public class Utility {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateFibonacciSequence().limit(20).toArray()));
    }

    public static IntStream generateFibonacciSequence() {
        return IntStream.generate(new IntSupplier() {
            int a = 0;
            int b = 1;

            @Override
            public int getAsInt() {
                int x = a + b;
                a = b;
                b = x;
                return a;
            }
        });
    }
}

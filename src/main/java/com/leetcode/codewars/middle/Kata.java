package com.leetcode.codewars.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Kata {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5, 3, 2, 8, 1, 4})));
        System.out.println((int) 'a');
        System.out.println((int) 'z');
    }

    public static int[] sortArray(int[] array) {
        List<Integer> sortedList = new ArrayList<>();
        for (Integer number : array) {
            sortedList.add(number);
        }
        sortedList = sortedList.stream()
                .filter(x -> x % 2 != 0)
                .sorted()
                .collect(Collectors.toList());

        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                array[i] = sortedList.get(0);
                sortedList.remove(0);
            }
        }

        return array;
    }
}

package com.leetcode.codewars.simple;

public class Kata {
    public static void main(String[] args) {
        System.out.println(sequenceSum(2, 2, 2));
        System.out.println(sequenceSum(2, 6, 2));
        System.out.println(sequenceSum(1, 5, 1));
    }

    public static int sequenceSum(int start, int end, int step) {
        var count = 0;
        for (int i = start; i <= end; i += step) {
            count += i;
        }

        return count;
    }
}

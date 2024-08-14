package com.leetcode.codewars.simple;

import java.util.ArrayList;
import java.util.List;

public class FindDivisor {
    public static void main(String[] args) {
        var test = new FindDivisor();
        System.out.println(test.numberOfDivisors(4));
        System.out.println(test.numberOfDivisors(5));
        System.out.println(test.numberOfDivisors(12));
        System.out.println(test.numberOfDivisors(30));
    }

    public long numberOfDivisors(int n) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                nums.add(i);
            }
        }

        return nums.size();
    }
}

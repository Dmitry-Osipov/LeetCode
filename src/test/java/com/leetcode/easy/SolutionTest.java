package com.leetcode.easy;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        twoSum();
        twoSum2();
        System.out.println("----------------------------");
    }

    public static void twoSum() {
        var solution = new Solution();
        System.out.println(Arrays.equals(solution.twoSum(new int[] {2, 7, 11, 15}, 9), new int[] {0, 1}));
        System.out.println(Arrays.equals(solution.twoSum(new int[] {3, 2, 4}, 6), new int[] {1, 2}));
        System.out.println(Arrays.equals(solution.twoSum(new int[] {3, 3}, 6), new int[] {0, 1}));
    }

    public static void twoSum2() {
        var solution = new Solution();
        System.out.println(Arrays.equals(solution.twoSum2(new int[] {2, 7, 11, 15}, 9), new int[] {0, 1}));
        System.out.println(Arrays.equals(solution.twoSum2(new int[] {3, 2, 4}, 6), new int[] {1, 2}));
        System.out.println(Arrays.equals(solution.twoSum2(new int[] {3, 3}, 6), new int[] {0, 1}));
    }
}

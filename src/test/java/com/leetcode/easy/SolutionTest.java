package com.leetcode.easy;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        twoSum();
        twoSum2();
        System.out.println("----------------------------");
        reverseWords();
        System.out.println("----------------------------");
        findPeakElement();
        System.out.println("----------------------------");
        majorityElement();
        majorityElement2();
        System.out.println("----------------------------");
        containsDuplicate();
        System.out.println("----------------------------");
        reverseString();
        System.out.println("----------------------------");
        fib();
        System.out.println("----------------------------");
        newReverseWords();
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

    public static void reverseWords() {
        var solution = new Solution();
        System.out.println(solution.reverseWords("how are you"));
        System.out.println(solution.reverseWords("a good   example"));
        System.out.println(solution.reverseWords("  hello world   "));
    }

    public static void findPeakElement() {
        var solution = new Solution();
        System.out.println(solution.findPeakElement(new int[] {1, 2}));
        System.out.println(solution.findPeakElement(new int[] {1}));
        System.out.println(solution.findPeakElement(new int[] {1, 2, 3, 4, 5, 1}));
    }

    public static void majorityElement() {
        var solution = new Solution();
        System.out.println(solution.majorityElement(new int[] {3, 2, 3}));
        System.out.println(solution.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
    }

    public static void majorityElement2() {
        var solution = new Solution();
        System.out.println(solution.majorityElement2(new int[] {3, 2, 3}));
        System.out.println(solution.majorityElement2(new int[] {2, 2, 1, 1, 1, 2, 2}));
    }

    public static void containsDuplicate() {
        var solution = new Solution();
        System.out.println(solution.containsDuplicate(new int[] {1, 2, 3, 1}));
        System.out.println(solution.containsDuplicate(new int[] {1, 2, 3, 4}));
    }

    public static void reverseString() {
        var solution = new Solution();
        var res1 = new char[] {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(res1);
        System.out.println(Arrays.toString(res1));
    }

    public static void fib() {
        var solution = new Solution();
        System.out.println(solution.fib(1));
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(4));
        System.out.println(solution.fib(5));
        System.out.println(solution.fib(6));
        System.out.println(solution.fib(7));
    }

    public static void newReverseWords() {
        var solution = new Solution();
        System.out.println(solution.newReverseWords("Let's take LeetCode contest"));
        System.out.println(solution.newReverseWords("Mr Ding"));
        System.out.println(solution.newReverseWords("hehhhhhhe"));
    }
}

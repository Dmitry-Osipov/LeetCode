package com.leetcode.codewars.simple;

public class ShortLongShort {
    public static void main(String[] args) {
        System.out.println(solution("a", "bb"));
        System.out.println(solution("aa", "b"));
    }

    public static String solution(String a, String b) {
        return a.length() < b.length() ? a + b + a : b + a + b;
    }
}

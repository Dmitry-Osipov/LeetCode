package com.leetcode.codewars.middle;

import java.util.Arrays;

public class StringSplit {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("abc")));
        System.out.println(Arrays.toString(solution("HelloWorld")));
    }

    public static String[] solution(String s) {
        if (s == null || s.isBlank()) {
            return new String[0];
        }

        var result = s.split("(?<=\\G.{2})");
        if (s.length() % 2 != 0) {
            result[result.length - 1] = result[result.length - 1] + "_";
        }

        return result;
    }
}

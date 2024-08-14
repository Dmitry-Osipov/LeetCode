package com.leetcode.codewars.middle;

public class StringMerger {
    public static void main(String[] args) {
        System.out.println(isMerge("codewars", "cdw", "oears"));
    }

    public static boolean isMerge(String s, String part1, String part2) {
        if (s.isEmpty()) {
            return true;
        }

        if (s.length() != part1.length() + part2.length()) {
            return false;
        }

        boolean firstPart = !part1.isEmpty()
                && part1.charAt(0) == s.charAt(0)
                && isMerge(s.substring(1), part1.substring(1), part2);
        boolean secondPart = !part2.isEmpty()
                && part2.charAt(0) == s.charAt(0)
                && isMerge(s.substring(1), part1, part2.substring(1));
        return firstPart || secondPart;
    }
}

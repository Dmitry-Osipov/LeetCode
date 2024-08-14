package com.leetcode.codewars.simple;

import java.util.HashMap;
import java.util.Map;

public class Isogram {
    public static void main(String[] args) {
        System.out.println(isIsogram("Dermatoglyphics"));
        System.out.println(isIsogram("aba"));
        System.out.println(isIsogram("moOse"));
    }

    public static boolean isIsogram(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }

        str = str.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        return map.values().stream().allMatch(integer -> integer == 1);
    }
}

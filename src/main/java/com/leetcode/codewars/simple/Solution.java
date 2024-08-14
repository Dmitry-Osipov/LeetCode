package com.leetcode.codewars.simple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumNoDuplicates(new int[]{1, 1, 2, 3}));
        System.out.println(toCamelCase("the-stealth-warrior"));
        System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }

    public static int sumNoDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer num = entry.getKey();
            if (map.get(num) == 1) {
                list.add(num);
            }
        }

        return list.stream().reduce(0, Integer::sum);
    }

    public static String toCamelCase(String s) {
        var words = s.split("(\\W)|(_)");
        for (int i = 1; i < words.length; i++) {
            words[i] = words[i].substring(0, 1).toUpperCase() + words[i].substring(1);
        }

        return String.join("", words);
    }

    public static String whoLikesIt(String... names) {
        String answer;
        var length = names.length;
        switch (length) {
            case 0 -> answer = "no one likes this";
            case 1 -> answer = String.format("%s likes this", names[0]);
            case 2 -> answer = String.format("%s and %s like this", names[0], names[1]);
            case 3 -> answer = String.format("%s, %s and %s like this", names[0], names[1], names[2]);
            default -> answer = String.format("%s, %s and %d others like this", names[0], names[1], length - 2);
        }

        return answer;
    }
}

package com.leetcode.codewars.simple;

import java.util.List;

public class BinaryArrayToNumber {
    public static void main(String[] args) {
        System.out.println(ConvertBinaryArrayToInt(List.of(0, 0, 0, 1)));
        System.out.println(ConvertBinaryArrayToInt(List.of(1, 0, 1, 1)));
    }

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        var builder = new StringBuilder();
        binary.forEach(builder::append);
        return Integer.parseInt(builder.toString(), 2);
    }
}

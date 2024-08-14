package com.leetcode.codewars.simple;

public class EmailObfuscator {
    public static void main(String[] args) {
        System.out.println(obfuscate("test@123.com"));
    }

    public static String obfuscate(String email) {
        return email.replace("@", " [at] ").replace(".", " [dot] ");
    }
}

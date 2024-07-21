package com.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up
    // to target.
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //You can return the answer in any order.
    //
    //Example 1:
    //Input: nums = [2,7,11,15], target = 9
    //Output: [0,1]
    //Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    public int[] twoSum(int[] nums, int target) {  // O(n^2)
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }

        return new int[0];
    }

    public int[] twoSum2(int[] nums, int target) {  // O(n)
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }

    //------------------------------------------------------------------------------------------------------------------

    // Given an input string s, reverse the order of the words.
    //A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
    //Return a string of the words in reverse order concatenated by a single space.
    //Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string
    //should only have a single space separating the words. Do not include any extra spaces.
    //
    //Example 1:
    //Input: s = "the sky is blue"
    //Output: "blue is sky the"
    public String reverseWords(String s) {
        s = s.trim();
        var array = s.split("\\s+");
        if (array.length == 1) {
            return array[0];
        }

        var result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[array.length - i - 1];
        }

        return String.join(" ", result);
    }

    //------------------------------------------------------------------------------------------------------------------

    //A peak element is an element that is strictly greater than its neighbors.
    //Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple
    //peaks, return the index to any of the peaks.
    //You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly
    //greater than a neighbor that is outside the array.
    //You must write an algorithm that runs in O(log n) time.
    //
    //Example 1:
    //Input: nums = [1,2,3,1]
    //Output: 2
    //Explanation: 3 is a peak element and your function should return the index number 2.
    public int findPeakElement(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        var max = nums[0];
        var index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        return index;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an array nums of size n, return the majority element.
    //The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element
    //always exists in the array.
    //
    //Example 1:
    //Input: nums = [2,2,1,1,1,2,2]
    //Output: 2
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        var max = Integer.MIN_VALUE;
        var result = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n/2];
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer array nums, return true if any value appears at least twice in the array, and return false if
    //every element is distinct.
    //
    //Example 1:
    //Input: nums = [1,2,3,1]
    //Output: true
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums).distinct().count() != nums.length;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Write a function that reverses a string. The input string is given as an array of characters s.
    //You must do this by modifying the input array in-place with O(1) extra memory.
    //
    //Example 1:
    //Input: s = ["h","e","l","l","o"]
    //Output: ["o","l","l","e","h"]
    public void reverseString(char[] s) {
        if (s.length <= 1) {
            return;
        }

        var result = new char[s.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = s[result.length - 1 - i];
        }

        System.arraycopy(result, 0, s, 0, s.length);
    }

    //------------------------------------------------------------------------------------------------------------------

    // The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each
    //number is the sum of the two preceding ones, starting from 0 and 1. That is,
    //F(0) = 0, F(1) = 1
    //F(n) = F(n - 1) + F(n - 2), for n > 1.
    //Given n, calculate F(n).
    //
    //Example 1:
    //Input: n = 2
    //Output: 1
    //Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
    public int fib(int n) {
        var sqrt = Math.sqrt(5);
        var firstOperand = Math.pow((1 + sqrt) / 2, n);
        var secondOperand = Math.pow((1 - sqrt)/ 2, n);
        return (int) ((firstOperand - secondOperand) / sqrt);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace
    //and initial word order.
    //
    //Example 1:
    //Input: s = "Let's take LeetCode contest"
    //Output: "s'teL ekat edoCteeL tsetnoc"
    public String newReverseWords(String s) {
        s = s.trim();
        var array = s.split("\\s+");
        for (int i = 0; i < array.length; i++) {
            var sb = new StringBuilder(array[i]);
            array[i] = sb.reverse().toString();
        }

        return String.join(" ", array);
    }
}

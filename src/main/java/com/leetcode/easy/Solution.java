package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

public class Solution {
    // This is help collection for "levelOrder" task
    private List<List<Integer>> levels = new ArrayList<>();
    // This is help value for "isValidBST" task
    private Integer prev;

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

    //------------------------------------------------------------------------------------------------------------------

    //Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
    //Example:
    // [3 <- 2 -> 4] <- [1] -> [4 <- 2 -> 3]
    //Input: root = [1,2,2,3,4,4,3]
    //Output: true
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return node1.val == node2.val
                && isMirror(node1.right, node2.left)
                && isMirror(node1.left, node2.right);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the roots of two binary trees p and q, write a function to check if they are the same or not.
    //Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
    //Example1:
    //Input:
    //p = [2 <- 1 -> 3], q = [2 <- 1 -> 3]
    //Output:
    //true
    //Example2:
    //Input:
    //p = [2 <- 1 -> null], q = [null <- 1 -> 2]
    //Output:
    //false
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right,
    //level by level).
    //Example:
    //Input:
    //[null <- 9 -> null] <- 3 -> [15 <- 20 -> 7]
    //Output:
    //[[3], [9,20], [15,7]]
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        helper(root, 0);
        return levels;
    }

    private void helper(TreeNode root, int level) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }

        levels.get(level).add(root.val);

        if (root.left != null) {
            helper(root.left, level + 1);
        }

        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    // You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were
    // swapped by mistake. Recover the tree without changing its structure.
    // Input:
    // [2 <- 3 -> 1]
    // Output:
    // [2 <- 1 -> 3]
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recover(root, 2, swapped[0], swapped[1]);
    }

    private void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }

        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    private int[] findTwoSwapped(List<Integer> nums) {
        int n = nums.size();
        int x = -1, y = -1;
        boolean swappedFirstOccurence = false;

        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i + 1) < nums.get(i)) {
                y = nums.get(i + 1);
                if (!swappedFirstOccurence) {
                    x = nums.get(i);
                    swappedFirstOccurence = true;
                } else {
                    break;
                }
            }
        }

        return new int[] {x, y};
    }

    private void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.left, count, x, y);
            recover(root.right, count, x, y);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the root of a binary tree, determine if it is a valid binary search tree (BST).
    //A valid BST is defined as follows:
    //The left
    //subtree
    // of a node contains only nodes with keys less than the node's key.
    //The right subtree of a node contains only nodes with keys greater than the node's key.
    //Both the left and right subtrees must also be binary search trees.
    //Example1:
    //Input:
    // [1 <- 2 -> 3]
    //Output:
    //true
    //Example2:
    //Input:
    // [1] <- 5 -> [3 <- 4 -> 6]
    //Output:
    //false
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!inorder(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev) {
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the root of a binary tree, return the inorder traversal of its nodes' values.
    //Example:
    // Input:
    // null <- 1 -> [3 <- 2 -> null]
    // Output:
    // [1, 3, 2]
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> list) {
        if (root != null) {
            helper(root.left, list);
            list.add(root.val);
            helper(root.right, list);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n
    // nodes of unique values from 1 to n.
    //Example:
    // [1 -> [2 <- 3]], [1 -> 2 -> 3], [1 <- 2 -> 3], [1 <- 2 <- 3], [[1 -> 2] <- 3]
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }

    //Given an integer numRows, return the first numRows of Pascal's triangle.
    //In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
    // Input:
    // 5
    // Output:
    // [[1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1]]
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }

        if (numRows == 1) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(Arrays.asList(1));
            return result;
        }

        List<List<Integer>> prevRows = generate(numRows - 1);
        List<Integer> newRow = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            newRow.add(1);
        }

        for (int i = 1; i < numRows - 1; i++) {
            newRow.set(i, prevRows.get(numRows - 2).get(i - 1) + prevRows.get(numRows - 2).get(i));
        }

        prevRows.add(newRow);
        return prevRows;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
    //You must implement a solution with a linear runtime complexity and use only constant extra space.
    //Example 1:
    //Input: nums = [2,2,1]
    //Output: 1
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
    //In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
    //Example:
    //Input:
    //3
    //Output:
    //[1,3,3,1]
    public List<Integer> getRow(int rowIndex) {
        return generate(rowIndex + 1).get(rowIndex);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
    //'.' Matches any single character.
    //'*' Matches zero or more of the preceding element.
    //The matching should cover the entire input string (not partial).
    //Example 1:
    //Input: s = "aa", p = "a"
    //Output: false
    //Explanation: "a" does not match the entire string "aa".
    //Example 2:
    //Input: s = "aa", p = "a*"
    //Output: true
    //Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes
    //"aa".
    //Example 3:
    //Input: s = "ab", p = ".*"
    //Output: true
    //Explanation: ".*" means "zero or more (*) of any character (.)".
    public boolean isMatch(String s, String p) {
        try {
            return s.matches(p);
        } catch (PatternSyntaxException e) {
            return false;
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are climbing a staircase. It takes n steps to reach the top.
    //Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    //Example 1:
    //Input: n = 2
    //Output: 2
    //Explanation: There are two ways to climb to the top.
    //1. 1 step + 1 step
    //2. 2 steps
    //Example 2:
    //Input: n = 3
    //Output: 3
    //Explanation: There are three ways to climb to the top.
    //1. 1 step + 1 step + 1 step
    //2. 1 step + 2 steps
    //3. 2 steps + 1 step
    public int climbStairs(int n) {
        return climbingStairs(0, n);
    }

    private int climbingStairs(int i, int n) {
        if (i > n) {
            return 0;
        }

        if (i == n) {
            return 1;
        }

        return climbingStairs(i + 1, n) + climbingStairs(i + 2, n);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number
    // of 1's in the binary representation of i.
    //Example 1:
    //Input: n = 2
    //Output: [0,1,1]
    //Explanation:
    //0 --> 0
    //1 --> 1
    //2 --> 10
    //Example 2:
    //Input: n = 5
    //Output: [0,1,1,2,1,2]
    //Explanation:
    //0 --> 0
    //1 --> 1
    //2 --> 10
    //3 --> 11
    //4 --> 100
    //5 --> 101
    public int[] countBits(int n) {
        String[] binaryIntegers = new String[n + 1];
        int[] result = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            binaryIntegers[i] = Integer.toBinaryString(i);
        }

        for (int i = 0; i < result.length; i++) {
            int count = 0;
            for (int j = 0; j < binaryIntegers[i].length(); j++) {
                if (binaryIntegers[i].charAt(j) == '1') {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------
    //Simple Tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}

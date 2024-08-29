package com.leetcode.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.IntSupplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    // This is help collection for "levelOrder" task
    private final List<List<Integer>> levels = new ArrayList<>();
    // This is help value for "isValidBST" task
    private Integer prev;
    //Simple Tree
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
    // Simple Linked List
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    //------------------------------------------------------------------------------------------------------------------

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
        var sqrt5 = Math.sqrt(5);
        var firstOperand = Math.pow((1 + sqrt5) / 2, n);
        var secondOperand = Math.pow((1 - sqrt5) / 2, n);
        return (int) ((firstOperand - secondOperand) / sqrt5);
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
        int x = -1;
        int y = -1;
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
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                array[i] += array[j - 1] * array[i - j];
            }
        }

        return array[n];
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
            result.add(List.of(1));
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

    //Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if
    // needle is not part of haystack.
    //Example 1:
    //Input: haystack = "sadbutsad", needle = "sad"
    //Output: 0
    //Explanation: "sad" occurs at index 0 and 6.
    //The first occurrence is at index 0, so we return 0.
    //Example 2:
    //Input: haystack = "leetcode", needle = "leeto"
    //Output: -1
    //Explanation: "leeto" did not occur in "leetcode", so we return -1.
    public int strStr(String haystack, String needle) {
        int haystackLen = haystack.length();
        int needleLen = needle.length();
        Map<Character, Integer> offsetTable = new HashMap<>();
        for (int i = 0; i < needleLen - 1; i++) {
            offsetTable.put(needle.charAt(i), needleLen - i - 1);
        }

        int shift = 0;
        while (shift <= haystackLen - needleLen) {
            int j = needleLen - 1;
            while (j >= 0 && needle.charAt(j) == haystack.charAt(shift + j)) {
                j--;
            }

            if (j < 0) {
                return shift;
            } else {
                shift += Math.max(1, offsetTable.getOrDefault(haystack.charAt(shift + j), needleLen) - 1);
            }
        }

        return -1;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer array nums, find the
    //subarray
    // with the largest sum, and return its sum.
    //Example 1:
    //Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    //Output: 6
    //Explanation: The subarray [4,-1,2,1] has the largest sum 6.
    //Example 2:
    //Input: nums = [1]
    //Output: 1
    //Explanation: The subarray [1] has the largest sum 1.
    //Example 3:
    //Input: nums = [5,4,-1,7,8]
    //Output: 23
    //Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
    public int maxSubArray(int[] nums) {
        if (Arrays.stream(nums).allMatch(num -> num < 0)) {
            return Arrays.stream(nums).max().orElse(0);
        }

        int prevSum = 0;
        int answer = -1;
        for (int num : nums) {
            prevSum = Math.max(prevSum + num, 0);
            if (prevSum >= answer) {
                answer = prevSum;
            }
        }

        return answer;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such
    // that adding up all the values along the path equals targetSum.
    //A leaf is a node with no children.
    //Example:
    //Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
    //Output: true
    //Explanation: 5 + 4 + 11 + 2 = 22
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> nodeStack = new LinkedList<>();
        Deque<Integer> sumStack = new LinkedList<>();
        nodeStack.add(root);
        sumStack.add(targetSum - root.val);

        TreeNode node;
        int currentSum;
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pollLast();
            currentSum = sumStack.pollLast();
            if (node.right == null && node.left == null && currentSum == 0) {
                return true;
            }

            if (node.left != null) {
                nodeStack.add(node.left);
                sumStack.add(currentSum - node.left.val);
            }

            if (node.right != null) {
                nodeStack.add(node.right);
                sumStack.add(currentSum - node.right.val);
            }
        }

        return false;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given a binary tree, find its minimum depth.
    //The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    //Note: A leaf is a node with no children.
    //Example:
    //Input:
    // [9] <- [3] -> [15 <- 20 -> 7]
    //Output:
    // 3 -> 20 -> 7 будет 2
    public int minDepth(TreeNode root) {
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null) {
            return 1 + dfs(root.right);
        }

        if (root.right == null) {
            return 1 + dfs(root.left);
        }

        return Math.min(dfs(root.left), dfs(root.right)) + 1;
    }

    //------------------------------------------------------------------------------------------------------------------

    // Given a binary tree, determine if it is height-balanced
    //Example 1:
    //Input: root = [3,9,20,null,null,15,7]
    //Output: true
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return -1;
        }

        return 1 + Math.max(height(root.left), height(root.right));
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in
    // any order.
    //Example 1:
    //Input: nums = [1,1,1,2,2,3], k = 2
    //Output: [1,2]
    //Example 2:
    //Input: nums = [1], k = 1
    //Output: [1]
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .distinct()
                .toList();
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------

    //A distinct string is a string that is present only once in an array.
    //Given an array of strings arr, and an integer k, return the kth distinct string present in arr. If there are
    //fewer than k distinct strings, return an empty string "".
    //Note that the strings are considered in the order in which they appear in the array.
    //Example 1:
    //Input: arr = ["d","b","c","b","c","a"], k = 2
    //Output: "a"
    //Explanation:
    //The only distinct strings in arr are "d" and "a".
    //"d" appears 1st, so it is the 1st distinct string.
    //"a" appears 2nd, so it is the 2nd distinct string.
    //Since k == 2, "a" is returned.
    //Example 2:
    //Input: arr = ["aaa","aa","a"], k = 1
    //Output: "aaa"
    //Explanation:
    //All strings in arr are distinct, so the 1st string "aaa" is returned.
    //Example 3:
    //Input: arr = ["a","b","a"], k = 3
    //Output: ""
    //Explanation:
    //The only distinct string is "b". Since there are fewer than 3 distinct strings, we return an empty string "".
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        String[] distinct = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .toArray(String[]::new);

        return Arrays.stream(distinct)
                .skip(k - 1L)
                .limit(1)
                .findFirst()
                .orElse("");
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
    //The overall run time complexity should be O(log (m+n)).
    //Example 1:
    //Input: nums1 = [1,3], nums2 = [2]
    //Output: 2.00000
    //Explanation: merged array = [1,2,3] and median is 2.
    //Example 2:
    //Input: nums1 = [1,2], nums2 = [3,4]
    //Output: 2.50000
    //Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var firstOperand = Arrays.stream(nums1)
                .average()
                .orElse(0);
        var secondOperand = Arrays.stream(nums2)
                .average()
                .orElse(0);
        return (firstOperand + secondOperand) / 2.0;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    //An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using
    //all the original letters exactly once.
    //Example 1:
    //Input: strs = ["eat","tea","tan","ate","nat","bat"]
    //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    //Example 2:
    //Input: strs = [""]
    //Output: [[""]]
    //Example 3:
    //Input: strs = ["a"]
    //Output: [["a"]]
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);
            map.computeIfAbsent(sortedWord, k -> new ArrayList<>());
            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

    //------------------------------------------------------------------------------------------------------------------

    //Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
    //The algorithm for myAtoi(string s) is as follows:
    //Whitespace: Ignore any leading whitespace (" ").
    //Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity is neither
    // present.
    //Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of
    // the string is reached. If no digits were read, then the result is 0.
    //Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to
    // remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater
    // than 231 - 1 should be rounded to 231 - 1.
    //Return the integer as the final result.
    //Example 1:
    //Input: s = "42"
    //Output: 42
    //Explanation:
    //The underlined characters are what is read in and the caret is the current reader position.
    //Step 1: "42" (no characters read because there is no leading whitespace)
    //         ^
    //Step 2: "42" (no characters read because there is neither a '-' nor '+')
    //         ^
    //Step 3: "42" ("42" is read in)
    //           ^
    //
    //Example 2:
    //Input: s = " -042"
    //Output: -42
    //Explanation:
    //
    //Step 1: "   -042" (leading whitespace is read and ignored)
    //            ^
    //Step 2: "   -042" ('-' is read, so the result should be negative)
    //             ^
    //Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
    //               ^
    //Example 3:
    //Input: s = "1337c0d3"
    //Output: 1337
    //Explanation:
    //Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
    //         ^
    //Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
    //         ^
    //Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
    //             ^
    //Example 4:
    //Input: s = "0-1"
    //Output: 0
    //Explanation:
    //Step 1: "0-1" (no characters read because there is no leading whitespace)
    //         ^
    //Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
    //         ^
    //Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
    //          ^
    //Example 5:
    //Input: s = "words and 987"
    //Output: 0
    //Explanation:
    //Reading stops at the first non-digit character 'w'.
    public int myAtoi(String s) {
        s = s.trim();
        var sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i)) || (isSign(s.charAt(i)) && i == 0)) {
                sb.append(s.charAt(i));
            } else {
                break;
            }
        }

        return (sb.isEmpty() || (sb.length() == 1 && sb.charAt(0) == '-')) ? 0 : parseInt(sb.toString());
    }

    private boolean isSign(char c) {
        return c == '+' || c == '-';
    }

    private int parseInt(String s) {
        int result;
        try {
            result = Integer.parseInt(s);
        } catch (NumberFormatException e) {
            if (s.charAt(0) == '-') {
                result = Integer.MIN_VALUE;
            } else {
                result = Integer.MAX_VALUE;
            }
        }

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------

    //A sentence is a list of tokens separated by a single space with no leading or trailing spaces. Every token is
    // either a positive number consisting of digits 0-9 with no leading zeros, or a word consisting of lowercase
    // English letters.
    //For example, "a puppy has 2 eyes 4 legs" is a sentence with seven tokens: "2" and "4" are numbers and the other
    // tokens such as "puppy" are words.
    //Given a string s representing a sentence, you need to check if all the numbers in s are strictly increasing from
    // left to right (i.e., other than the last number, each number is strictly smaller than the number on its
    // right in s).
    //Return true if so, or false otherwise.
    //
    //Example 1:
    //example-1
    //Input: s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles"
    //Output: true
    //Explanation: The numbers in s are: 1, 3, 4, 6, 12.
    //They are strictly increasing from left to right: 1 < 3 < 4 < 6 < 12.
    //Example 2:
    //Input: s = "hello world 5 x 5"
    //Output: false
    //Explanation: The numbers in s are: 5, 5. They are not strictly increasing.
    //Example 3:
    //example-3
    //Input: s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"
    //Output: false
    //Explanation: The numbers in s are: 7, 51, 50, 60. They are not strictly increasing.
    public boolean areNumbersAscending(String s) {
        int[] array = Arrays.stream(s.split("\\D"))
                .filter(string -> !string.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i = 1; i < array.length; i++) {
            if (array[i] <= array[i - 1]) {
                return false;
            }
        }

        return true;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
    //A subsequence of a string is a new string that is formed from the original string by deleting some (can be none)
    // of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a
    // subsequence of "abcde" while "aec" is not).
    //Example 1:
    //Input: s = "abc", t = "ahbgdc"
    //Output: true
    //Example 2:
    //Input: s = "axc", t = "ahbgdc"
    //Output: false
    public boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (i == sLength) {
                return true;
            }

            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
        }

        return i == sLength;
    }

    //------------------------------------------------------------------------------------------------------------------

    //The Tribonacci sequence Tn is defined as follows:
    //T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
    //Given n, return the value of Tn.
    //Example 1:
    //Input: n = 4
    //Output: 4
    //Explanation:
    //T_3 = 0 + 1 + 1 = 2
    //T_4 = 1 + 1 + 2 = 4
    //Example 2:
    //Input: n = 25
    //Output: 1389537
    public int tribonacci(int n) {
        if (n < 1) {
            return 0;
        }

        return generateTribonacci().skip(n - 1L).limit(1L).sum();
    }

    private IntStream generateTribonacci() {
        return IntStream.generate(new IntSupplier() {
            int a = 1;
            int b = 1;
            int c = 2;

            @Override
            public int getAsInt() {
                int x = a;
                int temp = a + b + c;
                a = b;
                b = c;
                c = temp;
                return x;
            }
        });
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
    //order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
    //You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    //Example 1:
    //Input: l1 = [2,4,3], l2 = [5,6,4]
    //Output: [7,0,8]
    //Explanation: 342 + 465 = 807.
    //Example 2:
    //Input: l1 = [0], l2 = [0]
    //Output: [0]
    //Example 3:
    //Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    //Output: [8,9,9,9,0,0,0,1]
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            tail.next = new ListNode(digit);
            tail = tail.next;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        ListNode result = dummyHead.next;
        dummyHead.next = null;
        return result;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given a string s, find the length of the longest substring without repeating characters.
    //Example 1:
    //Input: s = "abcabcbb"
    //Output: 3
    //Explanation: The answer is "abc", with the length of 3.
    //Example 2:
    //Input: s = "bbbbb"
    //Output: 1
    //Explanation: The answer is "b", with the length of 1.
    //Example 3:
    //Input: s = "pwwkew"
    //Output: 3
    //Explanation: The answer is "wke", with the length of 3.
    //Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        Set<Character> charSet = new HashSet<>();
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            if (!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                while (charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }

        return maxLength;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting
    // a decimal place value into a Roman numeral has the following rules:
    //If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the
    // input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
    //If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following
    // symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following
    // subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
    //Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You
    // cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the
    // subtractive form.
    //Given an integer, convert it to a Roman numeral.
    //Example 1:
    //Input: num = 3749
    //Output: "MMMDCCXLIX"
    //Explanation:
    //3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
    // 700 = DCC as 500 (D) + 100 (C) + 100 (C)
    //  40 = XL as 10 (X) less of 50 (L)
    //   9 = IX as 1 (I) less of 10 (X)
    //Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
    //Example 2:
    //Input: num = 58
    //Output: "LVIII"
    //Explanation:
    //50 = L
    // 8 = VIII
    //Example 3:
    //Input: num = 1994
    //Output: "MCMXCIV"
    //Explanation:
    //1000 = M
    // 900 = CM
    //  90 = XC
    //   4 = IV
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            if (num <= 0) {
                break;
            }

            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the
    // array such that nums[i] == nums[j] and abs(i - j) <= k.
    //Example 1:
    //Input: nums = [1,2,3,1], k = 3
    //Output: true
    //Example 2:
    //Input: nums = [1,0,1,1], k = 1
    //Output: true
    //Example 3:
    //Input: nums = [1,2,3,1,2,3], k = 2
    //Output: false
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && (i - map.get(nums[i]) <= k)) {
                return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the head of a linked list and an integer val, remove all the nodes of the linked list that has
    // Node.val == val, and return the new head.
    //Example 1:
    //Input: head = [1,2,6,3,4,5,6], val = 6
    //Output: [1,2,3,4,5]
    //Example 2:
    //Input: head = [], val = 1
    //Output: []
    //Example 3:
    //Input: head = [7,7,7,7], val = 7
    //Output: []
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode current = head;
        ListNode previous = dummy;
        while (current != null) {
            if (current.val == val) {
                previous.next = current.next;
            } else {
                previous = current;
            }

            current = current.next;
        }

        return dummy.next;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase
    // letters, the email may contain one or more '.' or '+'.
    //For example, in "alice@leetcode.com", "alice" is the local name, and "leetcode.com" is the domain name.
    //If you add periods '.' between some characters in the local name part of an email address, mail sent there will
    // be forwarded to the same address without dots in the local name. Note that this rule does not apply to
    // domain names.
    //For example, "alice.z@leetcode.com" and "alicez@leetcode.com" forward to the same email address.
    //If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows
    // certain emails to be filtered. Note that this rule does not apply to domain names.
    //For example, "m.y+name@email.com" will be forwarded to "my@email.com".
    //It is possible to use both of these rules at the same time.
    //Given an array of strings emails where we send one email to each emails[i], return the number of different
    // addresses that actually receive mails.
    //Example 1:
    //Input: emails =
    // ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
    //Output: 2
    //Explanation: "testemail@leetcode.com" and "testemail@lee.tcode.com" actually receive mails.
    //Example 2:
    //Input: emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"]
    //Output: 3
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        for (String email : emails) {
            var address = email.split("@");
            address[0] = address[0].split("\\+")[0];
            address[0] = address[0].replace(".", "");
            unique.add(String.join("@", address));
        }

        return unique.size();
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given an integer array nums consisting of n elements, and an integer k.
    //Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value.
    // Any answer with a calculation error less than 10-5 will be accepted.
    //Example 1:
    //Input: nums = [1,12,-5,-6,50,3], k = 4
    //Output: 12.75000
    //Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
    //Example 2:
    //Input: nums = [5], k = 1
    //Output: 5.00000
    public double findMaxAverage(int[] nums, int k) {
        Set<Double> avgs = new TreeSet<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }
        avgs.add(getAvg(queue));

        for (int i = k; i < nums.length; i++) {
            queue.remove();
            queue.add(nums[i]);
            avgs.add(getAvg(queue));
        }

        return avgs.stream()
                .max(Double::compareTo)
                .orElse((double) 0);
    }

    private double getAvg(Queue<Integer> queue) {
        return queue.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero
    // elements.
    //Note that you must do this in-place without making a copy of the array.
    //Example 1:
    //Input: nums = [0,1,0,3,12]
    //Output: [1,3,12,0,0]
    //Example 2:
    //Input: nums = [0]
    //Output: [0]
    public void moveZeroes(int[] nums) {
        var temp = Arrays.stream(nums)
                .boxed()
                .sorted(new ZeroesComparator())
                .mapToInt(Integer::intValue)
                .toArray();
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    private static class ZeroesComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer a, Integer b) {
            if (a == 0 && b != 0) {
                return 1;
            } else if (a != 0 && b == 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given a positive integer num, return true if num is a perfect square or false otherwise.
    //A perfect square is an integer that is the square of an integer. In other words, it is the product of some
    // integer with itself.
    //You must not use any built-in library function, such as sqrt.
    //Example 1:
    //Input: num = 16
    //Output: true
    //Explanation: We return true because 4 * 4 = 16 and 4 is an integer.
    //Example 2:
    //Input: num = 14
    //Output: false
    //Explanation: We return false because 3.742 * 3.742 = 14 and 3.742 is not an integer.
    public boolean isPerfectSquare(int num) {
        long count = 0;
        while (count * count <= num) {
            if (count * count == num) {
                return true;
            }
            count++;
        }

        return false;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
    //Example 1:
    //Input: num = 38
    //Output: 2
    //Explanation: The process is
    //38 --> 3 + 8 --> 11
    //11 --> 1 + 1 --> 2
    //Since 2 has only one digit, return it.
    //Example 2:
    //Input: num = 0
    //Output: 0
    public int addDigits(int num) {
        String str = String.valueOf(num);
        while (str.length() != 1) {
            str = sumCharsInString(str);
        }

        return Integer.parseInt(str);
    }

    private String sumCharsInString(String str) {
        return String.valueOf(Arrays.stream(str.split(""))
                .mapToInt(Integer::parseInt)
                .sum());
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given a string s representing an attendance record for a student where each character signifies whether
    // the student was absent, late, or present on that day. The record only contains the following three characters:
    //'A': Absent.
    //'L': Late.
    //'P': Present.
    //The student is eligible for an attendance award if they meet both of the following criteria:
    //The student was absent ('A') for strictly fewer than 2 days total.
    //The student was never late ('L') for 3 or more consecutive days.
    //Return true if the student is eligible for an attendance award, or false otherwise.
    //Example 1:
    //Input: s = "PPALLP"
    //Output: true
    //Explanation: The student has fewer than 2 absences and was never late 3 or more consecutive days.
    //Example 2:
    //Input: s = "PPALLL"
    //Output: false
    //Explanation: The student was late 3 consecutive days in the last 3 days, so is not eligible for the award.
    public boolean checkRecord(String s) {
        return kmpSearch(s, "LLL").isEmpty() && kmpSearch(s, "A").size() < 2;
    }

    private List<Integer> kmpSearch(String text, String sample) {
        List<Integer> result = new ArrayList<>();
        int[] prefixFunc = prefixFunction(sample);
        int i = 0;
        int j = 0;
        while (i < text.length()) {
            if (sample.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == sample.length()) {
                result.add(i - j);
                j = prefixFunc[j - 1];
            } else if (i < text.length() && text.charAt(i) != sample.charAt(j)) {
                if (j != 0) {
                    j = prefixFunc[j - 1];
                } else {
                    i++;
                }
            }
        }

        return result;
    }

    private int[] prefixFunction(String sample) {
        int[] values = new int[sample.length()];
        for (int i = 1; i < values.length; i++) {
            int j = 0;
            while(i + j < sample.length() && sample.charAt(i + j) == sample.charAt(j)) {
                values[i + j] = Math.max(values[i + j], j + 1);
                j++;
            }
        }

        return values;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the root of a binary tree, return the postorder traversal of its nodes' values.
    //Example 1:
    //Input: root = [] <- [1] -> [[3] <- 2 -> []]
    //Output: [3,2,1]
    //Example 2:
    //Input: root = []
    //Output: []
    //Example 3:
    //Input: root = [1]
    //Output: [1]
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();

        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.addFirst(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the head of a singly linked list, return the middle node of the linked list.
    //If there are two middle nodes, return the second middle node.
    //Example 1:
    //Input: head = [1,2,3,4,5]
    //Output: [3,4,5]
    //Explanation: The middle node of the list is node 3.
    //Example 2:
    //Input: head = [1,2,3,4,5,6]
    //Output: [4,5,6]
    //Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
    public ListNode middleNode(ListNode head) {
        int count = 0;
        int listSize = getSizeOfLinkedList(head);
        ListNode current = head;
        while (current != null) {
            if (count < listSize / 2) {
                current = current.next;
                count++;
            } else {
                head = current;
                break;
            }
        }

        return head;
    }

    private int getSizeOfLinkedList(ListNode head) {
        int size = 0;
        if (head == null) {
            return size;
        }

        while (head.next != null) {
            head = head.next;
            size++;
        }

        return ++size;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an array arr of integers, check if there exist two indices i and j such that :
    // 1) i != j
    // 2) 0 <= i, j < arr.length
    // 3) arr[i] == 2 * arr[j]
    //Example 1:
    //Input: arr = [10,2,5,3]
    //Output: true
    //Explanation: For i = 0 and j = 2, arr[i] == 10 == 2 * 5 == 2 * arr[j]
    //Example 2:
    //Input: arr = [3,1,7,11]
    //Output: false
    //Explanation: There is no i and j that satisfy the conditions.
    public boolean checkIfExist(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j && arr[i] == 2 * arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to
    // search target in nums. If target exists, then return its index. Otherwise, return -1.
    //You must write an algorithm with O(log n) runtime complexity.
    //Example 1:
    //Input: nums = [-1,0,3,5,9,12], target = 9
    //Output: 4
    //Explanation: 9 exists in nums and its index is 4
    //Example 2:
    //Input: nums = [-1,0,3,5,9,12], target = 2
    //Output: -1
    //Explanation: 2 does not exist in nums so return -1
    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int minPos, int maxPos) {
        if (minPos > maxPos) {
            return -1;
        }

        int mid = (minPos + maxPos) / 2;

        if (nums[mid] == target) {
            return mid;
        }

        return nums[mid] < target ? binarySearch(nums, target, mid + 1, maxPos) :
                binarySearch(nums, target, minPos, mid - 1);
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given an integer mountain array arr of length n where the values increase to a peak element and then
    // decrease.
    //Return the index of the peak element.
    //Your task is to solve it in O(log(n)) time complexity.
    //Example 1:
    //Input: arr = [0,1,0]
    //Output: 1
    //Example 2:
    //Input: arr = [0,2,1,0]
    //Output: 1
    //Example 3:
    //Input: arr = [0,10,5,2]
    //Output: 1
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (arr[mid] > arr[mid - 1]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return -1;
    }

    //------------------------------------------------------------------------------------------------------------------

    //The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in
    // its binary representation.
    //For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
    //Given an integer num, return its complement.
    //Example 1:
    //Input: num = 5
    //Output: 2
    //Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you
    // need to output 2.
    //Example 2:
    //Input: num = 1
    //Output: 0
    //Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you
    // need to output 0.
    public int findComplement(int num) {
        if (num == 0) {
            return 1;
        }

        int bitLength = Integer.toBinaryString(num).length();
        int mask = (1 << bitLength) - 1;  // Создаём маску, в которой двигаем единицу на длину изначального числа, а
        // затем отнимаем единицу, чтобы конвертировать все нули в единицы (например, было 1000, станет 0111)
        return num ^ mask;  // конвертируем биты изначального числа с маской (было 1010, станет 0101)
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an array nums of integers, return how many of them contain an even number of digits.
    //Example 1:
    //Input: nums = [12,345,2,6,7896]
    //Output: 2
    //Explanation:
    //12 contains 2 digits (even number of digits).
    //345 contains 3 digits (odd number of digits).
    //2 contains 1 digit (odd number of digits).
    //6 contains 1 digit (odd number of digits).
    //7896 contains 4 digits (even number of digits).
    //Therefore only 12 and 7896 contain an even number of digits.
    //Example 2:
    //Input: nums = [555,901,482,1771]
    //Output: 1
    //Explanation:
    //Only 1771 contains an even number of digits.
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            int log = (int) Math.log10(num);
            if (log >= 1 && log % 2 != 0) {
                count++;
            }
        }

        return count;
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given a string s consisting of lowercase English letters. A duplicate removal consists of choosing two
    // adjacent and equal letters and removing them.
    //We repeatedly make duplicate removals on s until we no longer can.
    //Return the final string after all such duplicate removals have been made. It can be proven that the answer
    // is unique.
    //Example 1:
    //Input: s = "abbaca"
    //Output: "ca"
    //Explanation:
    //For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only
    // possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the
    // final string is "ca".
    //Example 2:
    //Input: s = "azxxzy"
    //Output: "ay"
    public String removeDuplicates(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peekLast().equals(c)) {
                stack.removeLast();
            } else {
                stack.addLast(c);
            }
        }

        return String.join("", stack.stream()
                .map(String::valueOf)
                .toArray(String[]::new));
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest
    // version of your product fails the quality check. Since each version is developed based on the previous version,
    // all the versions after a bad version are also bad.
    //Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the
    // following ones to be bad.
    //You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to
    // find the first bad version. You should minimize the number of calls to the API.
    //Example 1:
    //Input: n = 5, bad = 4
    //Output: 4
    //Explanation:
    //call isBadVersion(3) -> false
    //call isBadVersion(5) -> true
    //call isBadVersion(4) -> true
    //Then 4 is the first bad version.
    //Example 2:
    //Input: n = 1, bad = 1
    //Output: 1
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // заглушка для теста
    private static boolean isBadVersion(int n) {
        return n >= 4;
    }

    //------------------------------------------------------------------------------------------------------------------

    //We are playing the Guess Game. The game is as follows:
    //I pick a number from 1 to n. You have to guess which number I picked.
    //Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
    //You call a pre-defined API int guess(int num), which returns three possible results:
    //-1: Your guess is higher than the number I picked (i.e. num > pick).
    //1: Your guess is lower than the number I picked (i.e. num < pick).
    //0: your guess is equal to the number I picked (i.e. num == pick).
    //Return the number that I picked.
    //Example 1:
    //Input: n = 10, pick = 6
    //Output: 6
    //Example 2:
    //Input: n = 1, pick = 1
    //Output: 1
    //Example 3:
    //Input: n = 2, pick = 1
    //Output: 1
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        int middle;
        int answer = -1;
        while(start <= end) {
            middle = start + (end - start) / 2;
            if (guess(middle) == -1) {
                end = middle - 1;
            } else if (guess(middle) == 1) {
                start = middle + 1;
            } else {
                answer = middle;
                break;
            }
        }

        return answer;
    }

    // заглушка для теста
    private static int guess(int num) {
        return Integer.compare(6, num);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer n, return true if it is a power of four. Otherwise, return false.
    //An integer n is a power of four, if there exists an integer x such that n == 4x.
    //Example 1:
    //Input: n = 16
    //Output: true
    //Example 2:
    //Input: n = 5
    //Output: false
    //Example 3:
    //Input: n = 1
    //Output: true
    public boolean isPowerOfFour(int n) {
        if (n < 1) {
            return false;
        }

        if ((n & (n - 1)) != 0) {  // Проверка, что число не является степенью двойки
            return false;
        }

        return (n & 0x55555555) != 0;  // Проверка, находится ли единичный бит в позиции, соответствующей степени 4
    }

    //------------------------------------------------------------------------------------------------------------------

    //You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be
    // planted in adjacent plots.
    //Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an
    // integer n, return true if n new flowers can be planted in the flowerbed without violating the
    // no-adjacent-flowers rule and false otherwise.
    //Example 1:
    //Input: flowerbed = [1,0,0,0,1], n = 1
    //Output: true
    //Example 2:
    //Input: flowerbed = [1,0,0,0,1], n = 2
    //Output: false
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n < 1) {
            return true;
        }

        int length = flowerbed.length;
        if (length == 1 && flowerbed[0] == 0) {
            return true;
        }

        int count = 0;
        while (count < length) {
            try {
                if (flowerbed[count] == 0) {
                    if (flowerbed[count - 1] == 0 && flowerbed[count + 1] == 0) {
                        flowerbed[count] = 1;
                        n--;
                    }
                    count++;
                } else {
                    count += 2;
                }
            } catch (ArrayIndexOutOfBoundsException ignore) {
                if (count == 0 && flowerbed[count + 1] == 0) {
                    flowerbed[count] = 1;
                    n--;
                    count++;
                } else if (count == length - 1 && flowerbed[count - 1] == 0) {
                    flowerbed[count] = 1;
                    n--;
                    count++;
                }

                count++;
            }
        }

        return n <= 0;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the root of a binary tree, return its maximum depth.
    //A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the
    // farthest leaf node.
    //Example 1:
    //Input: root = [3,9,20,null,null,15,7]
    //Output: 3
    //Example 2:
    //Input: root = [1,null,2]
    //Output: 2
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSubHeight = maxDepth(root.left);
        int rightSubHeight = maxDepth(root.right);
        return Math.max(leftSubHeight, rightSubHeight) + 1;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means
    // a backspace character.
    //Note that after backspacing an empty text, the text will continue empty.
    //Example 1:
    //Input: s = "ab#c", t = "ad#c"
    //Output: true
    //Explanation: Both s and t become "ac".
    //Example 2:
    //Input: s = "ab##", t = "c#d#"
    //Output: true
    //Explanation: Both s and t become "".
    //Example 3:
    //Input: s = "a#c", t = "b"
    //Output: false
    //Explanation: s becomes "c" while t becomes "b".
    public boolean backspaceCompare(String s, String t) {
        if (s.equals(t)) {
            return true;
        }

        Deque<Character> stackS = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            pushOrRemoveChar(c, stackS);
        }

        Deque<Character> stackT = new LinkedList<>();
        for (Character c : t.toCharArray()) {
            pushOrRemoveChar(c, stackT);
        }

        return stackS.equals(stackT);
    }

    private void pushOrRemoveChar(Character c, Deque<Character> stack) {
        if (c.equals('#')) {
            if (!stack.isEmpty()) {
                stack.remove();
            }
        } else {
            stack.push(c);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given a string expression representing an expression of fraction addition and subtraction, return the
    // calculation result in string format.
    //The final result should be an irreducible fraction. If your final result is an integer, change it to the format
    // of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.
    //Example 1:
    //Input: expression = "-1/2+1/2"
    //Output: "0/1"
    //Example 2:
    //Input: expression = "-1/2+1/2+1/3"
    //Output: "1/3"
    //Example 3:
    //Input: expression = "1/3-1/2"
    //Output: "-1/6"
    public String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;

        Pattern pattern = Pattern.compile("([+-]?\\d+)/(\\d+)");
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            int num = Integer.parseInt(matcher.group(1));
            int den = Integer.parseInt(matcher.group(2));

            numerator = numerator * den + num * denominator;
            denominator *= den;

            int gcdVal = gcd(Math.abs(numerator), denominator);
            numerator /= gcdVal;
            denominator /= gcdVal;
        }

        return numerator + "/" + denominator;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given head, the head of a linked list, determine if the linked list has a cycle in it.
    //There is a cycle in a linked list if there is some node in the list that can be reached again by continuously
    // following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer
    // is connected to. Note that pos is not passed as a parameter.
    //Return true if there is a cycle in the linked list. Otherwise, return false.
    //Example 1:
    //Input: head = [3,2,0,-4], pos = 1
    //Output: true
    //Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
    //Example 2:
    //Input: head = [1,2], pos = 0
    //Output: true
    //Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
    //Example 3:
    //Input: head = [1], pos = -1
    //Output: false
    //Explanation: There is no cycle in the linked list.
    public boolean hasCycle1(ListNode head) {
        if (head == null) {
            return false;
        }

        Set<ListNode> seen = new HashSet<>();
        ListNode current = head;
        while (current != null) {
            if (seen.contains(current)) {
                return true;
            }

            seen.add(current);
            current = current.next;
        }

        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer n, return true if it is a power of two. Otherwise, return false.
    //An integer n is a power of two, if there exists an integer x such that n == 2x.
    //Example 1:
    //Input: n = 1
    //Output: true
    //Explanation: 20 = 1
    //Example 2:
    //Input: n = 16
    //Output: true
    //Explanation: 24 = 16
    //Example 3:
    //Input: n = 3
    //Output: false
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }

        return (Math.log10(n) / Math.log10(2)) % 1 == 0;  // Обычный логарифм не сработал на 2^29, ибо арифметика
        // с плавающей точкой
    }

    //------------------------------------------------------------------------------------------------------------------

    //The Hamming distance between two integers is the number of positions at which the corresponding bits are
    // different.
    //Given two integers x and y, return the Hamming distance between them.
    //Example 1:
    //Input: x = 1, y = 4
    //Output: 2
    //Explanation:
    //1   (0 0 0 1)
    //4   (0 1 0 0)
    //       ↑   ↑
    //The above arrows point to positions where the corresponding bits are different.
    //Example 2:
    //Input: x = 3, y = 1
    //Output: 1
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;

        while(xor != 0) {
            if(xor % 2 == 1)
                distance++;
            xor = xor >> 1;
        }

        return distance;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that
    // is missing from the array.
    //Example 1:
    //Input: nums = [3,0,1]
    //Output: 2
    //Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in
    // the range since it does not appear in nums.
    //Example 2:
    //Input: nums = [0,1]
    //Output: 2
    //Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in
    // the range since it does not appear in nums.
    //Example 3:
    //Input: nums = [9,6,4,2,3,5,7,0,1]
    //Output: 8
    //Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in
    // the range since it does not appear in nums.
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }

        return res;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the root of a binary tree, return all root-to-leaf paths in any order.
    //A leaf is a node with no children.
    //Example 1:
    //Input: root = [1,2,3,null,5]
    //Output: ["1->2->5","1->3"]
    //Example 2:
    //Input: root = [1]
    //Output: ["1"]
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfs(root, "", res);
        return res;
    }

    private void dfs(TreeNode node, String path, List<String> res) {
        path += node.val + "->";

        if (node.left == null && node.right == null) {
            res.add(path.substring(0, path.length() - 2));
            return;
        }

        if (node.left != null) {
            dfs(node.left, path, res);
        }

        if (node.right != null) {
            dfs(node.right, path, res);
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer array nums where the elements are sorted in ascending order, convert it to a
    //height-balanced binary search tree.
    //Example 1:
    //Input: nums = [-10,-3,0,5,9]
    //Output: [0,-3,9,-10,null,5]
    //Explanation: [0,-10,5,null,-3,null,9] is also accepted:
    //Example 2:
    //Input: nums = [1,3]
    //Output: [3,1]
    //Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left <= right) {  // По принципу бинарного поиска текущую голову выдаём за середину, а остальное цепляем
            // справа или слева
            int mid = (left + right) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = helper(nums, left, mid - 1);
            node.right = helper(nums, mid + 1, right);

            return node;
        }

        return null;
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given two binary trees root1 and root2.
    //Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the
    // others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes
    // overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be
    // used as the node of the new tree.
    //Return the merged tree.
    //Note: The merging process must start from the root nodes of both trees.
    //Example 1:
    //Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
    //Output: [3,4,5,5,4,null,7]
    //Example 2:
    //Input: root1 = [1], root2 = [1,2]
    //Output: [2,2]
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return getTreeNode(root1, root2);
        }

        return mergeNodes(root1, root2);
    }

    private TreeNode mergeNodes(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            root1.val += root2.val;
            root1.left = mergeNodes(root1.left, root2.left);
            root1.right = mergeNodes(root1.right, root2.right);
        }

        return getTreeNode(root1, root2);
    }

    private TreeNode getTreeNode(TreeNode root1, TreeNode root2) {
        return root1 == null ? root2 : root1;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an n x n binary matrix image, flip the image horizontally, then invert it, and return the resulting image.
    //To flip an image horizontally means that each row of the image is reversed.
    //For example, flipping [1,1,0] horizontally results in [0,1,1].
    //To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0.
    //For example, inverting [0,1,1] results in [1,0,0].
    //Example 1:
    //Input: image = [[1,1,0],[1,0,1],[0,0,0]]
    //Output: [[1,0,0],[0,1,0],[1,1,1]]
    //Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
    //Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
    //Example 2:
    //Input: image = [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
    //Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    //Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
    //Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
    public int[][] flipAndInvertImage1(int[][] image) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < image.length; i++) {
            list.add(new ArrayList<>());
            for (int j = 0; j < image[i].length; j++) {
                list.get(i).add(image[i][j]);
            }
            list.set(i, list.get(i).reversed());
        }

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = list.get(i).get(j) == 0 ? 1 : 0;
            }
        }

        return image;
    }

    public int[][] flipAndInvertImage2(int[][] image) {  // Такой же по скорости, что и List, но без ручных переворотов
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                image[i][j] = image[i][j] == 0 ? 1 : 0;
            }

            for (int j = 0; j < image[i].length / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][image.length - 1 - j];
                image[i][image.length - 1 - j] = temp;
            }
        }

        return image;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such
    // that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2]
    // where 1 <= index1 < index2 <= numbers.length.
    //Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2]
    // of length 2.
    //The tests are generated such that there is exactly one solution. You may not use the same element twice.
    //Your solution must use only constant extra space.
    //Example 1:
    //Input: numbers = [2,7,11,15], target = 9
    //Output: [1,2]
    //Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
    //Example 2:
    //Input: numbers = [2,3,4], target = 6
    //Output: [1,3]
    //Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
    //Example 3:
    //Input: numbers = [-1,0], target = -1
    //Output: [1,2]
    //Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
    public int[] twoSumMedium(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int current = numbers[left] + numbers[right];
            if (current == target) {
                return new int[]{left + 1, right + 1};
            }

            if (current > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[] {-1, -1};
    }

    //------------------------------------------------------------------------------------------------------------------

    //In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order.
    // The order of the alphabet is some permutation of lowercase letters.
    //Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only
    // if the given words are sorted lexicographically in this alien language.
    //Example 1:
    //Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
    //Output: true
    //Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
    //Example 2:
    //Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
    //Output: false
    //Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
    //Example 3:
    //Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
    //Output: false
    //Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to
    // lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is
    // less than any other character
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> weights = prepareMap(order);

        for (int i = 0; i < words.length - 1; i++) {
            String str1 = words[i];
            String str2 = words[i + 1];
            for (int j = 0; j < str1.length(); j++) {
                if (j >= str2.length()) {
                    return false;
                }

                if (weights.get(str1.charAt(j)) < weights.get(str2.charAt(j))) {
                    break;
                }

                if (weights.get(str1.charAt(j)) > weights.get(str2.charAt(j))) {
                    return false;
                }
            }
        }

        return true;
    }

    private Map<Character, Integer> prepareMap(String order) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = order.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
        }

        return map;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an array of integers arr, return true if and only if it is a valid mountain array.
    //Recall that arr is a mountain array if and only if:
    //arr.length >= 3
    //There exists some i with 0 < i < arr.length - 1 such that:
    //arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
    //arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
    //Example 1:
    //Input: arr = [2,1]
    //Output: false
    //Example 2:
    //Input: arr = [3,5,5]
    //Output: false
    //Example 3:
    //Input: arr = [0,3,2,1]
    //Output: true
    public boolean validMountainArray1(int[] arr) {
        int arrLength = arr.length;
        int maxElemPosition = findMaxElemPosition(arr);
        if (arrLength < 3 || !isPosInAcceptableLimits(maxElemPosition, arrLength)) {
            return false;
        }

        var asc = getAscendingArray(arr, maxElemPosition);
        int max = asc[0];
        for (int i = 1; i < asc.length; i++) {
            if (max >= asc[i]) {
                return false;
            }
            max = asc[i];
        }

        var desc = getDescendingArray(arr, maxElemPosition);
        int min = desc[0];
        for (int i = 1; i < desc.length; i++) {
            if (min <= desc[i]) {
                return false;
            }
            min = desc[i];
        }

        return true;
    }

    private int[] getAscendingArray(int[] arr, int maxPos) {
        int length = maxPos + 1;
        int[] res = new int[length];
        System.arraycopy(arr, 0, res, 0, length);

        return res;
    }

    private int[] getDescendingArray(int[] arr, int maxPos) {
        int length = arr.length - maxPos;
        int[] res = new int[length];
        System.arraycopy(arr, maxPos, res, 0, length);

        return res;
    }

    private int findMaxElemPosition(int[] arr) {
        int pos = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[pos]) {
                pos = i;
            }
        }

        return pos;
    }

    private boolean isPosInAcceptableLimits(int pos, int arrLength) {
        return 0 < pos && pos < arrLength - 1;
    }

    public boolean validMountainArray2(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int l = 0;
        while (l + 1 < arr.length - 1 && arr[l] < arr[l + 1]) {
            l++;
        }

        int r = arr.length - 1;
        while (r - 1 > 0 && arr[r] < arr[r - 1]) {
            r--;
        }

        return l == r;
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given a license key represented as a string s that consists of only alphanumeric characters and dashes.
    // The string is separated into n + 1 groups by n dashes. You are also given an integer k.
    //We want to reformat the string s such that each group contains exactly k characters, except for the first group,
    // which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash
    // inserted between two groups, and you should convert all lowercase letters to uppercase.
    //Return the reformatted license key.
    //Example 1:
    //Input: s = "5F3Z-2e-9-w", k = 4
    //Output: "5F3Z-2E9W"
    //Explanation: The string s has been split into two parts, each part has 4 characters.
    //Note that the two extra dashes are not needed and can be removed.
    //Example 2:
    //Input: s = "2-5g-3-J", k = 2
    //Output: "2-5G-3J"
    //Explanation: The string s has been split into three parts, each part has 2 characters except the first part as
    // it could be shorter as mentioned above.
    public String licenseKeyFormatting(String s, int k) {
        Deque<Character> stack = new LinkedList<>();
        int count = 0;
        char[] chars = s.toCharArray();
        reverseCharArray(chars);
        for (char c : chars) {
            if (c != '-') {
                stack.push(Character.toUpperCase(c));
                count++;

                if (count == k) {
                    stack.push('-');
                    count = 0;
                }
            }
        }

        if (!stack.isEmpty() && stack.peek() == '-') {
            stack.pop();
        }

        return String.join("", stack.stream()
                .map(String::valueOf)
                .toArray(String[]::new));
    }

    private void reverseCharArray(char[] chars) {
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    //Assume you are an awesome parent and want to give your children some cookies. But, you should give each child
    // at most one cookie.
    //Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with;
    // and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i
    // will be content. Your goal is to maximize the number of your content children and output the maximum number.
    //Example 1:
    //Input: g = [1,2,3], s = [1,1]
    //Output: 1
    //Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
    //And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor
    // is 1 content.
    //You need to output 1.
    //Example 2:
    //Input: g = [1,2], s = [1,2,3]
    //Output: 2
    //Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
    //You have 3 cookies and their sizes are big enough to gratify all of the children,
    //You need to output 2.
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        for (int cookie : s) {
            if (i < g.length && cookie >= g[i]) {
                i++;
            }
        }

        return i;
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given a sorted unique integer array nums.
    //A range [a,b] is the set of all integers from a to b (inclusive).
    //Return the smallest sorted list of ranges that cover all the numbers in the array exactly. That is, each element
    // of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges
    // but not in nums.
    //Each range [a,b] in the list should be output as:
    //"a->b" if a != b
    //"a" if a == b
    //Example 1:
    //Input: nums = [0,1,2,4,5,7]
    //Output: ["0->2","4->5","7"]
    //Explanation: The ranges are:
    //[0,2] --> "0->2"
    //[4,5] --> "4->5"
    //[7,7] --> "7"
    //Example 2:
    //Input: nums = [0,2,3,4,6,8,9]
    //Output: ["0","2->4","6","8->9"]
    //Explanation: The ranges are:
    //[0,0] --> "0"
    //[2,4] --> "2->4"
    //[6,6] --> "6"
    //[8,9] --> "8->9"
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            return ans;
        }

        int start = 0;
        for (int end = 1; end <= n; end++) {
            if (end == n || nums[end] != nums[end - 1] + 1) {
                if (start == end - 1) {
                    ans.add(String.valueOf(nums[start]));
                } else {
                    ans.add(nums[start] + "->" + nums[end - 1]);
                }
                start = end;
            }
        }

        return ans;
    }

    //------------------------------------------------------------------------------------------------------------------

    //There are n kids with candies. You are given an integer array candies, where each candies[i] represents the
    // number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you
    // have.
    //Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the
    // extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
    //Note that multiple kids can have the greatest number of candies.
    //Example 1:
    //Input: candies = [2,3,5,1,3], extraCandies = 3
    //Output: [true,true,true,false,true]
    //Explanation: If you give all extraCandies to:
    //- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
    //- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
    //- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
    //- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
    //- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
    //Example 2:
    //Input: candies = [4,2,1,1,2], extraCandies = 1
    //Output: [true,false,false,false,false]
    //Explanation: There is only 1 extra candy.
    //Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
    //Example 3:
    //Input: candies = [12,1,12], extraCandies = 10
    //Output: [true,false,true]
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        for (int i : candies) {
            boolean flag = true;
            for (int j : candies) {
                if (i + extraCandies < j) {
                    flag = false;
                    break;
                }
            }
            result.add(flag);
        }

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given a string s, reverse only all the vowels in the string and return it.
    //The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.
    //Example 1:
    //Input: s = "hello"
    //Output: "holle"
    //Example 2:
    //Input: s = "leetcode"
    //Output: "leotcede"
    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] chars = s.toCharArray();
        while (start < end) {
            char first = s.charAt(start);
            char second = s.charAt(end);
            if (!isVowel(first)) {
                start++;
            } else if (!isVowel(second)) {
                end--;
            } else {
                swapCharsInArray(chars, start, end);
                start++;
                end--;
            }
        }

        return String.valueOf(chars);
    }

    private boolean isVowel(char c) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        return vowels.contains(c);
    }

    private void swapCharsInArray(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the root of a binary tree, return the sum of all left leaves.
    //A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
    //Example 1:
    //Input: root = [3,9,20,null,null,15,7]
    //Output: 24
    //Explanation: There are two left leaves in the binary tree, with values 9 and 15 respectively.
    //Example 2:
    //Input: root = [1]
    //Output: 0
    public int sumOfLeftLeaves(TreeNode root) {
        int ans = 0;
        Deque<Map<TreeNode, Boolean>> stack = new ArrayDeque<>();
        stack.add(Map.of(root, false));
        while (!stack.isEmpty()) {
            Map<TreeNode, Boolean> map = stack.poll();
            TreeNode current = map.entrySet().iterator().next().getKey();
            boolean isLeft = map.get(current);
            if (current.right == null && current.left == null && isLeft) {
                ans += current.val;
            }

            if (current.left != null) {
                stack.add(Map.of(current.left, true));
            }

            if (current.right != null) {
                stack.add(Map.of(current.right, false));
            }
        }

        return ans;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given a string s which consists of lowercase or uppercase letters, return the length of the longest
    //palindrome that can be built with those letters.
    //Letters are case sensitive, for example, "Aa" is not considered a palindrome.
    //Example 1:
    //Input: s = "abccccdd"
    //Output: 7
    //Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
    //Example 2:
    //Input: s = "a"
    //Output: 1
    //Explanation: The longest palindrome that can be built is "a", whose length is 1.
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = getCharMapFromString(s);
        int result = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            var value = entry.getValue();
            int current = value - (value % 2);
            result += current;
            map.put(entry.getKey(), value - current);
        }

        return map.values().stream().noneMatch(i -> i > 0) ? result : result + 1;
    }

    private Map<Character, Integer> getCharMapFromString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the root of a binary tree, return the preorder traversal of its nodes' values.
    //Example 1:
    //Input: root = [1,null,2,3]
    //Output: [1,2,3]
    //Example 2:
    //Input: root = []
    //Output: []
    //Example 3:
    //Input: root = [1]
    //Output: [1]
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        ans.add(root.val);
        if (root.left != null) {
            ans.addAll(preorderTraversal(root.left));
        }

        if (root.right != null) {
            ans.addAll(preorderTraversal(root.right));
        }

        return ans;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given a binary array nums, return the maximum number of consecutive 1's in the array.
    //Example 1:
    //Input: nums = [1,1,0,1,1,1]
    //Output: 3
    //Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of
    //consecutive 1s is 3.
    //Example 2:
    //Input: nums = [1,0,1,1,0,1]
    //Output: 2
    public int findMaxConsecutiveOnes(int[] nums) {
        var target = 1;
        var count = 0;
        var max = 0;
        for (int num : nums) {
            if (num == target) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 0;
            }
        }

        return Math.max(max, count);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an unsorted array of integers nums, return the length of the longest continuous increasing subsequence
    // (i.e. subarray). The subsequence must be strictly increasing.
    //A continuous increasing subsequence is defined by two indices l and r (l < r) such that it is [nums[l],
    // nums[l + 1], ..., nums[r - 1], nums[r]] and for each l <= i < r, nums[i] < nums[i + 1].
    //Example 1:
    //Input: nums = [1,3,5,4,7]
    //Output: 3
    //Explanation: The longest continuous increasing subsequence is [1,3,5] with length 3.
    //Even though [1,3,5,7] is an increasing subsequence, it is not continuous as elements 5 and 7 are separated
    // by element 4.
    //Example 2:
    //Input: nums = [2,2,2,2,2]
    //Output: 1
    //Explanation: The longest continuous increasing subsequence is [2] with length 1. Note that it must be strictly
    //increasing.
    public int findLengthOfLCIS(int[] nums) {
        var max = 1;
        var count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                count++;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }

        return Math.max(max, count);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
    // element appears only once. The relative order of the elements should be kept the same. Then return the number
    // of unique elements in nums.
    //Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
    //Change the array nums such that the first k elements of nums contain the unique elements in the order they were
    // present in nums initially. The remaining elements of nums are not important as well as the size of nums.
    //Return k.
    //Custom Judge:
    //The judge will test your solution with the following code:
    //int[] nums = [...]; // Input array
    //int[] expectedNums = [...]; // The expected answer with correct length
    //int k = removeDuplicates(nums); // Calls your implementation
    //assert k == expectedNums.length;
    //for (int i = 0; i < k; i++) {
    //    assert nums[i] == expectedNums[i];
    //}
    //If all assertions pass, then your solution will be accepted.
    //Example 1:
    //Input: nums = [1,1,2]
    //Output: 2, nums = [1,2,_]
    //Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
    //It does not matter what you leave beyond the returned k (hence they are underscores).
    //Example 2:
    //Input: nums = [0,0,1,1,1,2,2,3,3,4]
    //Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
    //Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3,
    // and 4 respectively.
    //It does not matter what you leave beyond the returned k (hence they are underscores).
    public int removeDuplicates(int[] nums) {
        int[] distinct = Arrays.stream(nums).distinct().toArray();
        System.arraycopy(distinct, 0, nums, 0, distinct.length);
        return distinct.length;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
    //Return the running sum of nums.
    //Example 1:
    //Input: nums = [1,2,3,4]
    //Output: [1,3,6,10]
    //Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].
    //Example 2:
    //Input: nums = [1,1,1,1,1]
    //Output: [1,2,3,4,5]
    //Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].
    //Example 3:
    //Input: nums = [3,1,2,10,1]
    //Output: [3,4,6,16,17]
    public int[] runningSum(int[] nums) {
        int sum = nums[0];
        int[] result = new int[nums.length];
        result[0] = sum;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            result[i] = sum;
        }

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given two integer arrays nums1 and nums2, return an array of their
    //intersection. Each element in the result must be unique and you may return the result in any order.
    //Example 1:
    //Input: nums1 = [1,2,2,1], nums2 = [2,2]
    //Output: [2]
    //Example 2:
    //Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //Output: [9,4]
    //Explanation: [4,9] is also accepted.
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        set1.retainAll(set2);
        return set1.stream().mapToInt(Integer::intValue).toArray();
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given the root of a binary search tree (BST) and an integer val.
    //Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If
    // such a node does not exist, return null.
    //Example 1:
    //Input: root = [4,2,7,1,3], val = 2
    //Output: [2,1,3]
    //Example 2:
    //Input: root = [4,2,7,1,3], val = 5
    //Output: []
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == val) {
                return node;
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return null;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either
    // 0 or 1. The linked list holds the binary representation of a number.
    //Return the decimal value of the number in the linked list.
    //The most significant bit is at the head of the linked list.
    //Example 1:
    //Input: head = [1,0,1]
    //Output: 5
    //Explanation: (101) in base 2 = (5) in base 10
    //Example 2:
    //Input: head = [0]
    //Output: 0
    public int getDecimalValue(ListNode head) {
        var sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(sb.toString(), 2);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Write a function that takes the binary representation of a positive integer and returns the number of set bits
    // it has (also known as the Hamming weight).
    //Example 1:
    //Input: n = 11
    //Output: 3
    //Explanation:
    //The input binary string 1011 has a total of three set bits.
    //Example 2:
    //Input: n = 128
    //Output: 1
    //Explanation:
    //The input binary string 10000000 has a total of one set bit.
    //Example 3:
    //Input: n = 2147483645
    //Output: 30
    //Explanation:
    //The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
    public int hammingWeight(int n) {
        return (int) Integer.toBinaryString(n)
                .chars()
                .filter(ch -> ch == '1')
                .count();
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes
    // with a value in the inclusive range [low, high].
    //Example 1:
    //Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
    //Output: 32
    //Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
    //Example 2:
    //Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
    //Output: 23
    //Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (low <= node.val && node.val <= high) {
                count += node.val;
            }

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return count;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd
    // integers.
    //Return any array that satisfies this condition.
    //Example 1:
    //Input: nums = [3,1,2,4]
    //Output: [2,4,3,1]
    //Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
    //Example 2:
    //Input: nums = [0]
    //Output: [0]
    public int[] sortArrayByParity(int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted(new OddNumbersComparator())
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static class OddNumbersComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer integer, Integer t1) {
            if (integer % 2 != 0 && t1 % 2 == 0) {
                return 1;
            } else if (integer % 2 == 0 && t1 % 2 != 0) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the root of a binary search tree and an integer k, return true if there exist two elements in the BST such
    // that their sum is equal to k, or false otherwise.
    //Example 1:
    //Input: root = [5,3,6,2,4,null,7], k = 9
    //Output: true
    //Example 2:
    //Input: root = [5,3,6,2,4,null,7], k = 28
    //Output: false
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        Set<Integer> hash = new HashSet<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (hash.contains(k - node.val)) {
                return true;
            }

            hash.add(node.val);

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        return false;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
    // Answers within 10-5 of the actual answer will be accepted.
    //Example 1:
    //Input: root = [3,9,20,null,null,15,7]
    //Output: [3.00000,14.50000,11.00000]
    //Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
    //Hence return [3, 14.5, 11].
    //Example 2:
    //Input: root = [3,9,20,15,7]
    //Output: [3.00000,14.50000,11.00000]
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            double sum = 0.0;
            int count = 0;
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                count++;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(sum / count);
        }

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in
    // the range [1, n] that do not appear in nums.
    //Example 1:
    //Input: nums = [4,3,2,7,8,2,3,1]
    //Output: [5,6]
    //Example 2:
    //Input: nums = [1,1]
    //Output: [2]
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = IntStream.range(1, nums.length + 1).boxed().collect(Collectors.toSet());
        for (int num : nums) {
            set.remove(num);
        }

        return set.stream().toList();
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the root of a binary tree, invert the tree, and return its root.
    //Example 1:
    //Input: root = [4,2,7,1,3,6,9]
    //Output: [4,7,2,9,6,3,1]
    //Example 2:
    //Input: root = [2,1,3]
    //Output: [2,3,1]
    //Example 3:
    //Input: root = []
    //Output: []
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted
    // in non-decreasing order.
    //Example 1:
    //Input: nums = [-4,-1,0,3,10]
    //Output: [0,1,9,16,100]
    //Explanation: After squaring, the array becomes [16,1,0,9,100].
    //After sorting, it becomes [0,1,9,16,100].
    //Example 2:
    //Input: nums = [-7,-3,2,3,11]
    //Output: [4,9,9,49,121]
    public int[] sortedSquares(int[] nums) {
        int[] array = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = nums[i] * nums[i];
        }

        Arrays.sort(array);
        return array;
    }

    //------------------------------------------------------------------------------------------------------------------

    //You're given strings jewels representing the types of stones that are jewels, and stones representing the stones
    // you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have
    // are also jewels.
    //Letters are case sensitive, so "a" is considered a different type of stone from "A".
    //Example 1:
    //Input: jewels = "aA", stones = "aAAbbbb"
    //Output: 3
    //Example 2:
    //Input: jewels = "z", stones = "ZZ"
    //Output: 0
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> jewel = jewels.chars().mapToObj(ch -> (char) ch).collect(Collectors.toSet());
        List<Character> stone = new ArrayList<>(stones.chars().mapToObj(ch -> (char) ch).toList());
        stone.retainAll(jewel);
        return stone.size();
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return
    // the linked list sorted as well.
    //Example 1:
    //Input: head = [1,1,2]
    //Output: [1,2]
    //Example 2:
    //Input: head = [1,1,2,3,3]
    //Output: [1,2,3]
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode current = head;
        ListNode previous = dummy;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                previous.next = current.next;
            } else {
                previous = current;
            }

            current = current.next;
        }

        return dummy.next;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given a string s, find the first non-repeating character in it and return its index. If it does not exist,
    // return -1.
    //Example 1:
    //Input: s = "leetcode"
    //Output: 0
    //Example 2:
    //Input: s = "loveleetcode"
    //Output: 2
    //Example 3:
    //Input: s = "aabb"
    //Output: -1
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from
    // magazine and false otherwise.
    //Each letter in magazine can only be used once in ransomNote.
    //Example 1:
    //Input: ransomNote = "a", magazine = "b"
    //Output: false
    //Example 2:
    //Input: ransomNote = "aa", magazine = "ab"
    //Output: false
    //Example 3:
    //Input: ransomNote = "aa", magazine = "aab"
    //Output: true
    public boolean canConstruct(String ransomNote, String magazine) {
        var noteMap = getCountingCharsMap(ransomNote);
        var magazineMap = getCountingCharsMap(magazine);
        for (Map.Entry<Character, Integer> entry : noteMap.entrySet()) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (!magazineMap.containsKey(key)) {
                return false;
            }

            if (magazineMap.get(key) < value) {
                return false;
            } else {
                magazineMap.put(key, magazineMap.get(key) - value);
            }
        }

        return true;
    }

    private Map<Character, Integer> getCountingCharsMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        return map;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer n, return a string array answer (1-indexed) where:
    //answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    //answer[i] == "Fizz" if i is divisible by 3.
    //answer[i] == "Buzz" if i is divisible by 5.
    //answer[i] == i (as a string) if none of the above conditions are true.
    //Example 1:
    //Input: n = 3
    //Output: ["1","2","Fizz"]
    //Example 2:
    //Input: n = 5
    //Output: ["1","2","Fizz","4","Buzz"]
    //Example 3:
    //Input: n = 15
    //Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------

    //We define the usage of capitals in a word to be right when one of the following cases holds:
    //All letters in this word are capitals, like "USA".
    //All letters in this word are not capitals, like "leetcode".
    //Only the first letter in this word is capital, like "Google".
    //Given a string word, return true if the usage of capitals in it is right.
    //Example 1:
    //Input: word = "USA"
    //Output: true
    //Example 2:
    //Input: word = "FlaG"
    //Output: false
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        boolean firstUpper = Character.isUpperCase(chars[0]);
        int upperCount = firstUpper ? 1 : 0;
        for (int i = 1; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                upperCount++;
            }
        }

        return upperCount == chars.length || upperCount == 0 || (upperCount == 1 && firstUpper);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Write an algorithm to determine if a number n is happy.
    //A happy number is a number defined by the following process:
    //Starting with any positive integer, replace the number by the sum of the squares of its digits.
    //Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does
    // not include 1.
    //Those numbers for which this process ends in 1 are happy.
    //Return true if n is a happy number, and false if not.
    //Example 1:
    //Input: n = 19
    //Output: true
    //Explanation:
    //12 + 92 = 82
    //82 + 22 = 68
    //62 + 82 = 100
    //12 + 02 + 02 = 1
    //Example 2:
    //Input: n = 2
    //Output: false
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = squareByEveryDigit(slow);
            fast = squareByEveryDigit(squareByEveryDigit(fast));
        } while (slow != fast);

        return slow == 1;
    }

    private int squareByEveryDigit(int num) {
        int ans = 0;
        while(num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }

        return ans;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result
    // must appear as many times as it shows in both arrays and you may return the result in any order.
    //Example 1:
    //Input: nums1 = [1,2,2,1], nums2 = [2,2]
    //Output: [2,2]
    //Example 2:
    //Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    //Output: [4,9]
    //Explanation: [9,4] is also accepted.
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList<>(Arrays.stream(nums1).boxed().toList());
        List<Integer> list2 = new ArrayList<>(Arrays.stream(nums2).boxed().toList());
        List<Integer> result = new ArrayList<>();
        if (list1.size() > list2.size()) {
            fillIntersections(list2, list1, result);
        } else {
            fillIntersections(list1, list2, result);
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private void fillIntersections(List<Integer> iterable, List<Integer> removable, List<Integer> result) {
        for (Integer number : iterable) {
            if (removable.contains(number)) {
                result.add(number);
                removable.remove(number);
            }
        }
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same
    // structure and node values of subRoot and false otherwise.
    //A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
    // The tree tree could also be considered as a subtree of itself.
    //Example 1:
    //Input: root = [3,4,5,1,2], subRoot = [4,1,2]
    //Output: true
    //Example 2:
    //Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
    //Output: false
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        return subtree(root, subRoot);
    }

    private boolean subtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (root.val == subRoot.val && isIdentical(root, subRoot)) {
            return true;
        }

        return subtree(root.left, subRoot) || subtree(root.right, subRoot);
    }

    private boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        if (!isIdentical(root.left, subRoot.left)) {
            return false;
        }

        return isIdentical(root.right, subRoot.right);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given a string s, find any substring of length 2 which is also present in the reverse of s.
    //Return true if such a substring exists, and false otherwise.
    //Example 1:
    //Input: s = "leetcode"
    //Output: true
    //Explanation: Substring "ee" is of length 2 which is also present in reverse(s) == "edocteel".
    //Example 2:
    //Input: s = "abcba"
    //Output: true
    //Explanation: All of the substrings of length 2 "ab", "bc", "cb", "ba" are also present in reverse(s) == "abcba".
    //Example 3:
    //Input: s = "abcd"
    //Output: false
    //Explanation: There is no substring of length 2 in s, which is also present in the reverse of s.
    public boolean isSubstringPresent(String s) {
        if (s.length() < 2) {
            return false;
        }

        String t = new StringBuilder(s).reverse().toString();
        String temp = s.substring(0, 2);
        for (int i = 2; i < s.length() + 1; i++) {
            if (t.contains(temp)) {
                return true;
            }

            try {
                temp = s.substring(i - 1, i + 1);
            } catch (StringIndexOutOfBoundsException ignore) {}
        }

        return false;
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given a 0-indexed integer array nums, and an integer k.
    //In one operation, you can remove one occurrence of the smallest element of nums.
    //Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.
    //Example 1:
    //Input: nums = [2,11,10,1,3], k = 10
    //Output: 3
    //Explanation: After one operation, nums becomes equal to [2, 11, 10, 3].
    //After two operations, nums becomes equal to [11, 10, 3].
    //After three operations, nums becomes equal to [11, 10].
    //At this stage, all the elements of nums are greater than or equal to 10 so we can stop.
    //It can be shown that 3 is the minimum number of operations needed so that all elements of the array are greater
    // than or equal to 10.
    //Example 2:
    //Input: nums = [1,1,2,4,9], k = 1
    //Output: 0
    //Explanation: All elements of the array are greater than or equal to 1 so we do not need to apply any operations
    // on nums.
    //Example 3:
    //Input: nums = [1,1,2,4,9], k = 9
    //Output: 4
    //Explanation: only a single element of nums is greater than or equal to 9 so we need to apply the operations 4
    // times on nums.
    public int minOperations(int[] nums, int k) {
        int count = 0;
        for (int num : nums) {
            if (num < k) {
                count++;
            }
        }

        return count;
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given an integer array nums of even length. You have to split the array into two parts nums1 and nums2
    // such that:
    //nums1.length == nums2.length == nums.length / 2.
    //nums1 should contain distinct elements.
    //nums2 should also contain distinct elements.
    //Return true if it is possible to split the array, and false otherwise.
    //Example 1:
    //Input: nums = [1,1,2,2,3,4]
    //Output: true
    //Explanation: One of the possible ways to split nums is nums1 = [1,2,3] and nums2 = [1,2,4].
    //Example 2:
    //Input: nums = [1,1,1,1]
    //Output: false
    //Explanation: The only possible way to split nums is nums1 = [1,1] and nums2 = [1,1]. Both nums1 and nums2 do
    // not contain distinct elements. Therefore, we return false.
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> elements = new HashMap<>();
        for (int num : nums) {
            elements.put(num, elements.getOrDefault(num, 0) + 1);
        }
        return elements.values().stream().allMatch(x -> x < 3);
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given a 0-indexed string array words.
    //Let's define a boolean function isPrefixAndSuffix that takes two strings, str1 and str2:
    //isPrefixAndSuffix(str1, str2) returns true if str1 is both a prefix and a suffix of str2, and false otherwise.
    //For example, isPrefixAndSuffix("aba", "ababa") is true because "aba" is a prefix of "ababa" and also a suffix,
    // but isPrefixAndSuffix("abc", "abcd") is false.
    //Return an integer denoting the number of index pairs (i, j) such that i < j, and
    // isPrefixAndSuffix(words[i], words[j]) is true.
    //Example 1:
    //Input: words = ["a","aba","ababa","aa"]
    //Output: 4
    //Explanation: In this example, the counted index pairs are:
    //i = 0 and j = 1 because isPrefixAndSuffix("a", "aba") is true.
    //i = 0 and j = 2 because isPrefixAndSuffix("a", "ababa") is true.
    //i = 0 and j = 3 because isPrefixAndSuffix("a", "aa") is true.
    //i = 1 and j = 2 because isPrefixAndSuffix("aba", "ababa") is true.
    //Therefore, the answer is 4.
    //Example 2:
    //Input: words = ["pa","papa","ma","mama"]
    //Output: 2
    //Explanation: In this example, the counted index pairs are:
    //i = 0 and j = 1 because isPrefixAndSuffix("pa", "papa") is true.
    //i = 2 and j = 3 because isPrefixAndSuffix("ma", "mama") is true.
    //Therefore, the answer is 2.
    //Example 3:
    //Input: words = ["abab","ab"]
    //Output: 0
    //Explanation: In this example, the only valid index pair is i = 0 and j = 1, and isPrefixAndSuffix("abab", "ab")
    // is false. Therefore, the answer is 0.
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isPrefixAndSuffix(String subString, String string) {
        if (subString.length() > string.length()) {
            return false;
        }

        return string.startsWith(subString) && string.endsWith(subString);
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an array of integers called nums, you can perform the following operation while nums contains at least
    // 2 elements:
    //Choose the first two elements of nums and delete them.
    //The score of the operation is the sum of the deleted elements.
    //Your task is to find the maximum number of operations that can be performed, such that all operations have the
    // same score.
    //Return the maximum number of operations possible that satisfy the condition mentioned above.
    //Example 1:
    //Input: nums = [3,2,1,4,5]
    //Output: 2
    //Explanation: We perform the following operations:
    //- Delete the first two elements, with score 3 + 2 = 5, nums = [1,4,5].
    //- Delete the first two elements, with score 1 + 4 = 5, nums = [5].
    //We are unable to perform any more operations as nums contain only 1 element.
    //Example 2:
    //Input: nums = [3,2,6,1,4]
    //Output: 1
    //Explanation: We perform the following operations:
    //- Delete the first two elements, with score 3 + 2 = 5, nums = [6,1,4].
    //We are unable to perform any more operations as the score of the next operation isn't the same as
    // the previous one.
    public int maxOperations(int[] nums) {
        int result = 1;
        List<Integer> list = new ArrayList<>(Arrays.stream(nums).boxed().toList());
        int target = list.removeFirst() + list.removeFirst();
        if (list.size() < 2) {
            return result;
        }

        while (list.size() > 1) {
            if (list.removeFirst() + list.removeFirst() == target) {
                result++;
            } else {
                break;
            }
        }

        return result;
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given an array prices where prices[i] is the price of a given stock on the ith day.
    //You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the
    // future to sell that stock.
    //Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
    //Example 1:
    //Input: prices = [7,1,5,3,6,4]
    //Output: 5
    //Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    //Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
    //Example 2:
    //Input: prices = [7,6,4,3,1]
    //Output: 0
    //Explanation: In this case, no transactions are done and the max profit = 0.
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            profit = Math.max(profit, price - minPrice);
        }

        return profit;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the
    // elements of nums except nums[i].
    //The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    //You must write an algorithm that runs in O(n) time and without using the division operation.
    //Example 1:
    //Input: nums = [1,2,3,4]
    //Output: [24,12,8,6]
    //Example 2:
    //Input: nums = [-1,1,0,-3,3]
    //Output: [0,0,9,0,0]
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] temp1 = new int[length];
        temp1[0] = 1;
        for (int i = 1; i < length; i++) {
            temp1[i] = temp1[i - 1] * nums[i - 1];
        }

        int[] temp2 = new int[length];
        temp2[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            temp2[i] = temp2[i + 1] * nums[i + 1];
        }

        int[] products = new int[length];
        for (int i = 0; i < length; i++) {
            products[i] = temp1[i] * temp2[i];
        }
        return products;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given a string s, return the longest palindromic substring in s.
    //Example 1:
    //Input: s = "babad"
    //Output: "bab"
    //Explanation: "aba" is also a valid answer.
    //Example 2:
    //Input: s = "cbbd"
    //Output: "bb"
    public String longestPalindromeMedium(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLen; j <= s.length(); j++) {
                if (j - i > maxLen && isPalindrome(s.substring(i, j))) {
                    maxLen = j - i;
                    maxStr = s.substring(i, j);
                }
            }
        }

        return maxStr;
    }

    private boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
    //Example 1:
    //Input: head = [1,2,2,1]
    //Output: true
    //Example 2:
    //Input: head = [1,2]
    //Output: false
    public boolean isPalindrome1(ListNode head) {
        Queue<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            queue.add(head.val);
            stack.push(head.val);
            head = head.next;
        }

        for (Integer val : queue) {
            if (!Objects.equals(val, stack.pop())) {
                return false;
            }
        }

        return true;
    }

    public boolean isPalindrome2(ListNode head) {
        if (head == null) {
            return true;
        }

        ListNode slow = head, fast = head, previous, temp;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        previous = slow;
        slow = slow.next;
        previous.next = null;
        while (slow != null) {
            temp = slow.next;
            slow.next = previous;
            previous = slow;
            slow = temp;
        }

        fast = head;
        slow = previous;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    //------------------------------------------------------------------------------------------------------------------

    //Given the head of a singly linked list, reverse the list, and return the reversed list.
    //Example 1:
    //Input: head = [1,2,3,4,5]
    //Output: [5,4,3,2,1]
    //Example 2:
    //Input: head = [1,2]
    //Output: [2,1]
    //Example 3:
    //Input: head = []
    //Output: []
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;  // Запоминаем следующий элемент, который потом станет предыдущим
            current.next = previous;  // Меняем следующий элемент на предыдущий
            previous = current;  // Меняем предыдущий элемент на текущий (идём вперёд)
            current = next;  // Меняем текущий элемент на следующий, который запомнили (идём вперёд)
        }

        return previous;
    }

    //------------------------------------------------------------------------------------------------------------------

    //You are given an integer array coins representing coins of different denominations and an integer amount
    // representing a total amount of money.
    //Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be
    // made up by any combination of the coins, return -1.
    //You may assume that you have an infinite number of each kind of coin.
    //Example 1:
    //Input: coins = [1,2,5], amount = 11
    //Output: 3
    //Explanation: 11 = 5 + 5 + 1
    //Example 2:
    //Input: coins = [2], amount = 3
    //Output: -1
    //Example 3:
    //Input: coins = [1], amount = 0
    //Output: 0
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount + 1];
        Arrays.fill(minCoins, amount + 1);
        minCoins[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    minCoins[i] = Math.min(minCoins[i], 1 + minCoins[i - coins[j]]);
                }
            }
        }

        return minCoins[amount] != amount + 1 ? minCoins[amount] : -1;
    }
}

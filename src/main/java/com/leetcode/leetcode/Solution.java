package com.leetcode.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.IntSupplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
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
        Deque<String> stack = new LinkedList<>();
        for (String str : s.split("")) {
            if (!stack.isEmpty() && stack.peekLast().equals(str)) {
                stack.removeLast();
            } else {
                stack.addLast(str);
            }
        }

        return String.join("", stack.toArray(String[]::new));
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
        int numerator = 0, denominator = 1;

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
        int xor = x ^ y, distance = 0;

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
            return root1 == null ? root2 : root1;
        }

        return mergeNodes(root1, root2);
    }

    private TreeNode mergeNodes(TreeNode root1, TreeNode root2) {
        if (root1 != null && root2 != null) {
            root1.val += root2.val;
            root1.left = mergeNodes(root1.left, root2.left);
            root1.right = mergeNodes(root1.right, root2.right);
        }

        if (root1 == null) {
            return root2;
        }

        return root1;
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
        int left = 0, right = numbers.length - 1;
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

        return new int[] {1, 2};
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
}

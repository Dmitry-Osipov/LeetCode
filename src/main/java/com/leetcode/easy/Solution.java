package com.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.PatternSyntaxException;

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
}

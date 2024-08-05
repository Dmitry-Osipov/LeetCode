package com.leetcode.easy;

import java.util.Arrays;

public class SolutionTest {
    public static void main(String[] args) {
        twoSum();
        twoSum2();
        System.out.println("----------------------------");
        reverseWords();
        System.out.println("----------------------------");
        findPeakElement();
        System.out.println("----------------------------");
        majorityElement();
        majorityElement2();
        System.out.println("----------------------------");
        containsDuplicate();
        System.out.println("----------------------------");
        reverseString();
        System.out.println("----------------------------");
        fib();
        System.out.println("----------------------------");
        newReverseWords();
        System.out.println("----------------------------");
        isSymmetric();
        System.out.println("----------------------------");
        isSameTree();
        System.out.println("----------------------------");
        levelOrder();
        System.out.println("----------------------------");
        recoverTree();
        System.out.println("----------------------------");
        isValidBST();
        System.out.println("----------------------------");
        inorderTraversal();
        System.out.println("----------------------------");
        numTrees();
        System.out.println("----------------------------");
        generate();
        System.out.println("----------------------------");
        singleNumber();
        System.out.println("----------------------------");
        getRow();
        System.out.println("----------------------------");
        isMatch();
        System.out.println("----------------------------");
        climbStairs();
        System.out.println("----------------------------");
        countBits();
        System.out.println("----------------------------");
        strStr();
        System.out.println("----------------------------");
        maxSubArray();
        System.out.println("----------------------------");
        hasPathSum();
        System.out.println("----------------------------");
        minDepth();
        System.out.println("----------------------------");
        isBalanced();
        System.out.println("----------------------------");
        topKFrequent();
        System.out.println("----------------------------");
        kthDistinct();
        System.out.println("----------------------------");
        findMedianSortedArrays();
        System.out.println("----------------------------");
        groupAnagrams();
    }

    public static void twoSum() {
        var solution = new Solution();
        System.out.println(Arrays.equals(solution.twoSum(new int[] {2, 7, 11, 15}, 9), new int[] {0, 1}));
        System.out.println(Arrays.equals(solution.twoSum(new int[] {3, 2, 4}, 6), new int[] {1, 2}));
        System.out.println(Arrays.equals(solution.twoSum(new int[] {3, 3}, 6), new int[] {0, 1}));
    }

    public static void twoSum2() {
        var solution = new Solution();
        System.out.println(Arrays.equals(solution.twoSum2(new int[] {2, 7, 11, 15}, 9), new int[] {0, 1}));
        System.out.println(Arrays.equals(solution.twoSum2(new int[] {3, 2, 4}, 6), new int[] {1, 2}));
        System.out.println(Arrays.equals(solution.twoSum2(new int[] {3, 3}, 6), new int[] {0, 1}));
    }

    public static void reverseWords() {
        var solution = new Solution();
        System.out.println(solution.reverseWords("how are you"));
        System.out.println(solution.reverseWords("a good   example"));
        System.out.println(solution.reverseWords("  hello world   "));
    }

    public static void findPeakElement() {
        var solution = new Solution();
        System.out.println(solution.findPeakElement(new int[] {1, 2}));
        System.out.println(solution.findPeakElement(new int[] {1}));
        System.out.println(solution.findPeakElement(new int[] {1, 2, 3, 4, 5, 1}));
    }

    public static void majorityElement() {
        var solution = new Solution();
        System.out.println(solution.majorityElement(new int[] {3, 2, 3}));
        System.out.println(solution.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));
    }

    public static void majorityElement2() {
        var solution = new Solution();
        System.out.println(solution.majorityElement2(new int[] {3, 2, 3}));
        System.out.println(solution.majorityElement2(new int[] {2, 2, 1, 1, 1, 2, 2}));
    }

    public static void containsDuplicate() {
        var solution = new Solution();
        System.out.println(solution.containsDuplicate(new int[] {1, 2, 3, 1}));
        System.out.println(solution.containsDuplicate(new int[] {1, 2, 3, 4}));
    }

    public static void reverseString() {
        var solution = new Solution();
        var res1 = new char[] {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(res1);
        System.out.println(Arrays.toString(res1));
    }

    public static void fib() {
        var solution = new Solution();
        System.out.println(solution.fib(1));
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(4));
        System.out.println(solution.fib(5));
        System.out.println(solution.fib(6));
        System.out.println(solution.fib(7));
    }

    public static void newReverseWords() {
        var solution = new Solution();
        System.out.println(solution.newReverseWords("Let's take LeetCode contest"));
        System.out.println(solution.newReverseWords("Mr Ding"));
        System.out.println(solution.newReverseWords("hehhhhhhe"));
    }

    public static void isSymmetric() {
        var solution = new Solution();
        Solution.TreeNode successRoot = new Solution.TreeNode(1,
                new Solution.TreeNode(2,
                        new Solution.TreeNode(3), new Solution.TreeNode(4)),
                new Solution.TreeNode(2,
                        new Solution.TreeNode(4), new Solution.TreeNode(3)));
        System.out.println(solution.isSymmetric(successRoot));

        Solution.TreeNode failureRoot = new Solution.TreeNode(1,
                new Solution.TreeNode(2,
                        null, new Solution.TreeNode(3)),
                new Solution.TreeNode(2,
                        null, new Solution.TreeNode(3)));
        System.out.println(solution.isSymmetric(failureRoot));
    }

    public static void isSameTree() {
        var solution = new Solution();
        Solution.TreeNode successRoot1 = new Solution.TreeNode(1,
                new Solution.TreeNode(2,
                        new Solution.TreeNode(3), new Solution.TreeNode(4)),
                new Solution.TreeNode(2,
                        new Solution.TreeNode(3), new Solution.TreeNode(4)));
        Solution.TreeNode successRoot2 = new Solution.TreeNode(1,
                new Solution.TreeNode(2,
                        new Solution.TreeNode(3), new Solution.TreeNode(4)),
                new Solution.TreeNode(2,
                        new Solution.TreeNode(3), new Solution.TreeNode(4)));
        System.out.println(solution.isSameTree(successRoot1, successRoot2));

        Solution.TreeNode failureRoot1 = new Solution.TreeNode(1,
                new Solution.TreeNode(2,
                        null, new Solution.TreeNode(3)),
                new Solution.TreeNode(2,
                        new Solution.TreeNode(3), null));
        Solution.TreeNode failureRoot2 = new Solution.TreeNode(1,
                new Solution.TreeNode(2,
                        null, new Solution.TreeNode(3)),
                new Solution.TreeNode(2,
                        null, new Solution.TreeNode(3)));
        System.out.println(solution.isSameTree(failureRoot1, failureRoot2));
    }

    public static void levelOrder() {
        var solution = new Solution();
        Solution.TreeNode root = new Solution.TreeNode(1,
                new Solution.TreeNode(2,
                        new Solution.TreeNode(3), new Solution.TreeNode(4)),
                new Solution.TreeNode(2,
                        new Solution.TreeNode(4), new Solution.TreeNode(3)));
        System.out.println(solution.levelOrder(root));
    }

    public static void recoverTree() {
        var solution = new Solution();
        Solution.TreeNode root = new Solution.TreeNode(3,
                new Solution.TreeNode(2), new Solution.TreeNode(1));
        solution.recoverTree(root);
        System.out.println(root);
    }

    public static void isValidBST() {
        var solution = new Solution();
        Solution.TreeNode successRoot = new Solution.TreeNode(2,
                new Solution.TreeNode(1), new Solution.TreeNode(3));
        System.out.println(solution.isValidBST(successRoot));

        Solution.TreeNode failureRoot = new Solution.TreeNode(5,
                new Solution.TreeNode(1),
                new Solution.TreeNode(4,
                        new Solution.TreeNode(3), new Solution.TreeNode(6)));
        System.out.println(solution.isValidBST(failureRoot));
    }

    public static void inorderTraversal() {
        var solution = new Solution();
        Solution.TreeNode root = new Solution.TreeNode(1,
                null, new Solution.TreeNode(2, new Solution.TreeNode(3), null));
        System.out.println(solution.inorderTraversal(root));
    }

    public static void numTrees() {
        var solution = new Solution();
        System.out.println(solution.numTrees(3));
        System.out.println(solution.numTrees(1));
    }

    public static void generate() {
        var solution = new Solution();
        System.out.println(solution.generate(5));
    }

    public static void singleNumber() {
        var solution = new Solution();
        System.out.println(solution.singleNumber(new int[]{1, 1, 1, 2}));
        System.out.println(solution.singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    public static void getRow() {
        var solution = new Solution();
        System.out.println(solution.getRow(3));
    }

    public static void isMatch() {
        var solution = new Solution();
        System.out.println(solution.isMatch("aa", "a"));
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", ".*"));
    }

    public static void climbStairs() {
        var solution = new Solution();
        System.out.println(solution.climbStairs(2));
        System.out.println(solution.climbStairs(3));
    }

    public static void countBits() {
        var solution = new Solution();
        System.out.println(Arrays.toString(solution.countBits(2)));
        System.out.println(Arrays.toString(solution.countBits(5)));
    }

    public static void strStr() {
        var solution = new Solution();
        System.out.println(solution.strStr("codecodewars", "ar"));
        System.out.println(solution.strStr("leeleeettcode", "cde"));
    }

    public static void maxSubArray() {
        var solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{1}));
        System.out.println(solution.maxSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(solution.maxSubArray(new int[]{-1}));
        System.out.println(solution.maxSubArray(new int[]{-3, -2, -2, -3}));
    }

    public static void hasPathSum() {
        var solution = new Solution();
        Solution.TreeNode successRoot = new Solution.TreeNode(5,
                new Solution.TreeNode(4,
                        new Solution.TreeNode(11,
                                new Solution.TreeNode(7), new Solution.TreeNode(2)), null),
                new Solution.TreeNode(8,
                        new Solution.TreeNode(13), new Solution.TreeNode(4,
                        null, new Solution.TreeNode(1))));
        System.out.println(solution.hasPathSum(successRoot, 22));

        Solution.TreeNode failureRoot =
                new Solution.TreeNode(1, new Solution.TreeNode(2), new Solution.TreeNode(3));
        System.out.println(solution.hasPathSum(failureRoot, 5));
    }

    public static void minDepth() {
        var solution = new Solution();
        Solution.TreeNode root = new Solution.TreeNode(5,
                new Solution.TreeNode(4,
                        new Solution.TreeNode(11,
                                new Solution.TreeNode(7), new Solution.TreeNode(2)), null),
                new Solution.TreeNode(8,
                        new Solution.TreeNode(13), new Solution.TreeNode(4,
                        null, new Solution.TreeNode(1))));
        System.out.println(solution.minDepth(root));
    }

    public static void isBalanced() {
        var solution = new Solution();
        Solution.TreeNode root = new Solution.TreeNode(3,
                new Solution.TreeNode(3), new Solution.TreeNode(20,
                new Solution.TreeNode(20), new Solution.TreeNode(7)));
        System.out.println(solution.isBalanced(root));
    }

    public static void topKFrequent() {
        var solution = new Solution();
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{1}, 1)));
        System.out.println(Arrays.toString(solution.topKFrequent(new int[]{-1, -1}, 1)));
    }

    public static void kthDistinct() {
        var solution = new Solution();
        System.out.println(solution.kthDistinct(new String[]{"d", "b", "c", "b", "c", "a"}, 2));
        System.out.println(solution.kthDistinct(new String[]{"aaa", "aa", "a"}, 1));
        System.out.println(solution.kthDistinct(new String[]{"a", "b", "a"}, 3));
    }

    public static void findMedianSortedArrays() {
        var solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(solution.findMedianSortedArrays(new int[1], new int[0]));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}));
        System.out.println(solution.findMedianSortedArrays(new int[0], new int[]{1}));
    }

    public static void groupAnagrams() {
        var solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(solution.groupAnagrams(new String[]{"a"}));
        System.out.println(solution.groupAnagrams(new String[]{""}));
    }
}

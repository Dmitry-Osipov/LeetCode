package com.leetcode.leetcode;

import java.util.Arrays;

@SuppressWarnings("java:S2187")
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
        System.out.println("----------------------------");
        myAtoi();
        System.out.println("----------------------------");
        areNumbersAscending();
        System.out.println("----------------------------");
        isSubsequence();
        System.out.println("----------------------------");
        tribonacci();
        System.out.println("----------------------------");
        addTwoNumbers();
        System.out.println("----------------------------");
        lengthOfLongestSubstring();
        System.out.println("----------------------------");
        intToRoman();
        System.out.println("----------------------------");
        containsNearbyDuplicate();
        System.out.println("----------------------------");
        removeElements();
        System.out.println("----------------------------");
        numUniqueEmails();
        System.out.println("----------------------------");
        findMaxAverage();
        System.out.println("----------------------------");
        moveZeroes();
        System.out.println("----------------------------");
        isPerfectSquare();
        System.out.println("----------------------------");
        addDigits();
        System.out.println("----------------------------");
        checkRecord();
        System.out.println("----------------------------");
        postorderTraversal();
        System.out.println("----------------------------");
        middleNode();
        System.out.println("----------------------------");
        checkIfExist();
        System.out.println("----------------------------");
        search();
        System.out.println("----------------------------");
        peakIndexInMountainArray();
        System.out.println("----------------------------");
        findComplement();
        System.out.println("----------------------------");
        findNumbers();
        System.out.println("----------------------------");
        removeDuplicates();
        System.out.println("----------------------------");
        firstBadVersion();
        System.out.println("----------------------------");
        guessNumber();
        System.out.println("----------------------------");
        isPowerOfFour();
        System.out.println("----------------------------");
        canPlaceFlowers();
        System.out.println("----------------------------");
        maxDepth();
        System.out.println("----------------------------");
        backspaceCompare();
        System.out.println("----------------------------");
        fractionAddition();
        System.out.println("----------------------------");
        hasCycle();
        System.out.println("----------------------------");
        isPowerOfTwo();
        System.out.println("----------------------------");
        hammingDistance();
        System.out.println("----------------------------");
        missingNumber();
        System.out.println("----------------------------");
        binaryTreePaths();
        System.out.println("----------------------------");
        sortedArrayToBST();
        System.out.println("----------------------------");
        mergeTrees();
        System.out.println("----------------------------");
        flipAndInvertImage();
        System.out.println("----------------------------");
        twoSumMedium();
        System.out.println("----------------------------");
        isAlienSorted();
        System.out.println("----------------------------");
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

    public static void myAtoi() {
        var solution = new Solution();
        System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("    -42"));
        System.out.println(solution.myAtoi("1337c0d3"));
        System.out.println(solution.myAtoi("0-1"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));
        System.out.println(solution.myAtoi("+1"));
        System.out.println(solution.myAtoi("    +12 123"));
    }

    public static void areNumbersAscending() {
        var solution = new Solution();
        System.out.println(solution.areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println(solution.areNumbersAscending("hello world 5 x 5"));
        System.out.println(solution.areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
    }

    public static void isSubsequence() {
        var solution = new Solution();
        System.out.println(solution.isSubsequence("abc", "ahbgdc"));
        System.out.println(solution.isSubsequence("axc", "ahbgdc"));
        System.out.println(solution.isSubsequence("acb", "ahbgdc"));
    }

    public static void tribonacci() {
        var solution = new Solution();
        System.out.println(solution.tribonacci(1));
        System.out.println(solution.tribonacci(2));
        System.out.println(solution.tribonacci(3));
        System.out.println(solution.tribonacci(4));
        System.out.println(solution.tribonacci(25));
    }

    public static void addTwoNumbers() {
        var solution = new Solution();
        System.out.println(solution.addTwoNumbers(new Solution.ListNode(0), new Solution.ListNode(1)));
        System.out.println(solution.addTwoNumbers(
                new Solution.ListNode(0,
                        new Solution.ListNode(1)),
                new Solution.ListNode(1,
                        new Solution.ListNode(1))));
    }

    public static void lengthOfLongestSubstring() {
        var solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
    }

    public static void intToRoman() {
        var solution = new Solution();
        System.out.println(solution.intToRoman(3749));
        System.out.println(solution.intToRoman(58));
        System.out.println(solution.intToRoman(1994));
    }

    public static void containsNearbyDuplicate() {
        var solution = new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[] {1, 2, 3, 1}, 3));
        System.out.println(solution.containsNearbyDuplicate(new int[] {1, 0, 1, 1}, 1));
        System.out.println(solution.containsNearbyDuplicate(new int[] {1, 2, 3, 1, 2, 3}, 2));
    }

    public static void removeElements() {
        var solution = new Solution();
        Solution.ListNode head = new Solution.ListNode(1, new Solution.ListNode(2, new Solution.ListNode(6, new Solution.ListNode(3, new Solution.ListNode(4, new Solution.ListNode(5, new Solution.ListNode(6)))))));
        System.out.println(solution.removeElements(head, 6));
    }

    public static void numUniqueEmails() {
        var solution = new Solution();
        System.out.println(solution.numUniqueEmails(new String[] {"test.email+alex@leetcode.com",
                "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
        System.out.println(solution.numUniqueEmails(new String[]{"a@leetcode.com", "b@leetcode.com",
                "c@leetcode.com"}));
    }

    public static void findMaxAverage() {
        var solution = new Solution();
        System.out.println(solution.findMaxAverage(new int[] {1, 12, -5, -6, 50, 3}, 4));
        System.out.println(solution.findMaxAverage(new int[] {5}, 1));
    }

    public static void moveZeroes() {
        var solution = new Solution();
        int[] array1 = new int[] {0, 1, 0, 3, 12};
        int[] array2 = new int[] {0};
        solution.moveZeroes(array1);
        solution.moveZeroes(array2);
        System.out.println(Arrays.toString(array1));
        System.out.println(Arrays.toString(array2));
    }

    public static void isPerfectSquare() {
        var solution = new Solution();
        System.out.println(solution.isPerfectSquare(16));
        System.out.println(solution.isPerfectSquare(14));
        System.out.println(solution.isPerfectSquare(1));
        System.out.println(solution.isPerfectSquare(Integer.MAX_VALUE));
    }

    public static void addDigits() {
        var solution = new Solution();
        System.out.println(solution.addDigits(38));
        System.out.println(solution.addDigits(0));
        System.out.println(solution.addDigits(Integer.MAX_VALUE));
    }

    public static void checkRecord() {
        var solution = new Solution();
        System.out.println(solution.checkRecord("PPALLP"));
        System.out.println(solution.checkRecord("PPALLL"));
        System.out.println(solution.checkRecord("A"));
        System.out.println(solution.checkRecord("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPAPPPP" +
                "PPPPPPPPPPPPPPPPPPPPPLLPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPLLPPPPPPPPPPPPPPPPPPPPLPLP" +
                "LPLPLPPPPPPPPPPPPPPPPPPPPPPPPPPPPA"));
    }

    public static void postorderTraversal() {
        var solution = new Solution();
        Solution.TreeNode root = new Solution.TreeNode(1, null,
                new Solution.TreeNode(2,
                        new Solution.TreeNode(3), null));
        System.out.println(solution.postorderTraversal(root));
    }

    public static void middleNode() {
        var solution = new Solution();
        System.out.println(solution.middleNode(new Solution.ListNode(1, new Solution.ListNode(2, new Solution.ListNode(3, new Solution.ListNode(4, new Solution.ListNode(5)))))));
        System.out.println(solution.middleNode(new Solution.ListNode(1, new Solution.ListNode(2, new Solution.ListNode(3, new Solution.ListNode(4, new Solution.ListNode(5, new Solution.ListNode(6))))))));
    }

    public static void checkIfExist() {
        var solution = new Solution();
        System.out.println(solution.checkIfExist(new int[] {10, 2, 5, 3}));
        System.out.println(solution.checkIfExist(new int[] {3, 1, 7, 11}));
        System.out.println(solution.checkIfExist(new int[] {7, 1, 14, 11}));
        System.out.println(solution.checkIfExist(new int[] {7, 15, 3, 4, 30}));
    }

    public static void search() {
        var solution = new Solution();
        System.out.println(solution.search(new int[] {-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(solution.search(new int[] {-1, 0, 3, 5, 9, 12}, 2));
    }

    public static void peakIndexInMountainArray() {
        var solution = new Solution();
        System.out.println(solution.peakIndexInMountainArray(new int[] {0, 1, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[] {0, 2, 1, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[] {0, 10, 5, 2}));
        System.out.println(solution.peakIndexInMountainArray(new int[] {3, 4, 5, 1}));
        System.out.println(solution.peakIndexInMountainArray(new int[] {3, 5, 3, 2, 0}));
        System.out.println(solution.peakIndexInMountainArray(new int[] {24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
        System.out.println(solution.peakIndexInMountainArray(new int[] {18, 29, 38, 59, 98, 100, 99, 98, 90}));
    }

    public static void findComplement() {
        var solution = new Solution();
        System.out.println(solution.findComplement(5));
        System.out.println(solution.findComplement(1));
    }

    public static void findNumbers() {
        var solution = new Solution();
        System.out.println(solution.findNumbers(new int[]{12, 345, 2, 6, 7896}));
        System.out.println(solution.findNumbers(new int[]{555, 901, 482, 1771}));
    }

    public static void removeDuplicates() {
        var solution = new Solution();
        System.out.println(solution.removeDuplicates("abbaca"));
        System.out.println(solution.removeDuplicates("azxxzy"));
    }

    public static void firstBadVersion() {
        var solution = new Solution();
        System.out.println(solution.firstBadVersion(5));
    }

    public static void guessNumber() {
        var solution = new Solution();
        System.out.println(solution.guessNumber(10));
    }

    public static void isPowerOfFour() {
        var solution = new Solution();
        System.out.println(solution.isPowerOfFour(16));
        System.out.println(solution.isPowerOfFour(5));
        System.out.println(solution.isPowerOfFour(1));
        System.out.println(solution.isPowerOfFour(0));
        System.out.println(solution.isPowerOfFour(4));
        System.out.println(solution.isPowerOfFour(64));
    }

    public static void canPlaceFlowers() {
        var solution = new Solution();
        System.out.println(solution.canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 1));
        System.out.println(solution.canPlaceFlowers(new int[] {1, 0, 0, 0, 1}, 2));
        System.out.println(solution.canPlaceFlowers(new int[] {0, 1, 0, 0, 0}, 2));
        System.out.println(solution.canPlaceFlowers(new int[] {0, 0, 1, 0, 1}, 1));
        System.out.println(solution.canPlaceFlowers(new int[] {1, 0, 1, 0, 0}, 1));
    }

    public static void maxDepth() {
        var solution = new Solution();
        Solution.TreeNode symmetricalRoot = new Solution.TreeNode(3,
                new Solution.TreeNode(9,
                        new Solution.TreeNode(5), null),
                new Solution.TreeNode(20,
                        null, new Solution.TreeNode(7)));
        System.out.println(solution.maxDepth(symmetricalRoot));
        Solution.TreeNode unsymmetricalRoot = new Solution.TreeNode(3,
                new Solution.TreeNode(9),
                new Solution.TreeNode(20,
                        new Solution.TreeNode(15),
                        new Solution.TreeNode(7)));
        System.out.println(solution.maxDepth(unsymmetricalRoot));
    }

    public static void backspaceCompare() {
        var solution = new Solution();
        System.out.println(solution.backspaceCompare("ab#c", "ad#c"));
        System.out.println(solution.backspaceCompare("ab##", "c#d#"));
        System.out.println(solution.backspaceCompare("a#c", "b"));
        System.out.println(solution.backspaceCompare("#ab", "b"));
        System.out.println(solution.backspaceCompare("xywrrmp", "xywrrmu#p"));
    }

    public static void fractionAddition() {
        var solution = new Solution();
        System.out.println(solution.fractionAddition("-1/2+1/2"));
        System.out.println(solution.fractionAddition("-1/2+1/2+1/3"));
        System.out.println(solution.fractionAddition("1/3-1/2"));
        System.out.println(solution.fractionAddition("1/1-1/2+5/10"));
    }

    public static void hasCycle() {
        var solution = new Solution();
        System.out.println(solution.hasCycle1(new Solution.ListNode(1, new Solution.ListNode(2))));
        System.out.println(solution.hasCycle2(new Solution.ListNode(1, new Solution.ListNode(2))));
    }

    public static void isPowerOfTwo() {
        var solution = new Solution();
        int count = 0;
        for (int i = 0; i < 33; i++) {
            if (solution.isPowerOfTwo(i)) {
                count++;
            }
        }
        System.out.println(count == 6);
    }

    public static void hammingDistance() {
        var solution = new Solution();
        System.out.println(solution.hammingDistance(1, 4));
        System.out.println(solution.hammingDistance(3, 1));
    }

    public static void missingNumber() {
        var solution = new Solution();
        System.out.println(solution.missingNumber(new int[]{3, 0, 1}));
        System.out.println(solution.missingNumber(new int[]{0, 1}));
        System.out.println(solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(solution.missingNumber(new int[]{1}));
        System.out.println(solution.missingNumber(new int[]{0}));
    }

    public static void binaryTreePaths() {
        var solution = new Solution();
        System.out.println(solution.binaryTreePaths(new Solution.TreeNode(1,
                new Solution.TreeNode(2,
                        null, new Solution.TreeNode(5)),
                new Solution.TreeNode(3))));
    }

    public static void sortedArrayToBST() {
        var solution = new Solution();
        System.out.println(solution.sortedArrayToBST(new int[] {-10, -3, 0, 5, 9}));
        System.out.println(solution.sortedArrayToBST(new int[] {1, 3}));
    }

    public static void mergeTrees() {
        var solution = new Solution();
        System.out.println(solution.mergeTrees(
                new Solution.TreeNode(1,
                        new Solution.TreeNode(3,
                                new Solution.TreeNode(5), null),
                        new Solution.TreeNode(2)),
                new Solution.TreeNode(2,
                        new Solution.TreeNode(1,
                                null, new Solution.TreeNode(4)),
                        new Solution.TreeNode(3, null, new Solution.TreeNode(7)))
                ));
    }

    public static void flipAndInvertImage() {
        var solution = new Solution();
        System.out.println(Arrays.deepToString(solution.flipAndInvertImage1(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}})));
        System.out.println(Arrays.deepToString(solution.flipAndInvertImage2(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}})));
    }

    public static void twoSumMedium() {
        var solution = new Solution();
        System.out.println(Arrays.toString(solution.twoSumMedium(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(solution.twoSumMedium(new int[]{2, 3, 4}, 6)));
        System.out.println(Arrays.toString(solution.twoSumMedium(new int[]{-1, 0}, -1)));
    }

    public static void isAlienSorted() {
        var solution = new Solution();
        System.out.println(solution.isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
        System.out.println(solution.isAlienSorted(new String[]{"kuvp", "q"}, "ngxlkthsjuoqcpavbfdermiywz"));
        System.out.println(solution.isAlienSorted(new String[]{"fxasxpc","dfbdrifhp","nwzgs","cmwqriv","ebulyfyve","miracx","sxckdwzv","dtijzluhts","wwbmnge","qmjwymmyox"}, "zkgwaverfimqxbnctdplsjyohu"));
    }
}

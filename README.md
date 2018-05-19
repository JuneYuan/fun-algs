1. LeetCode, LintCode已完成题目
2. 2017校招笔试面试题目部分整理
3. 基础数据结构与算法笔记

记录每一个题目的**算法**（怎么做，见 `Solution` 列）和**想法**（为什么这么做，见 `Notes` 列）。

As follows.

---
## PART I. LeetCode / LintCode 已完成题目列表

LeetCode

| # | Title | Description | Notes | Solution | Difficulty | Data Structure | Algorithms |
|---| ----- | ----------- | ----- | -------- | ---------- | -------------- | ---------- |
| 1 | [Two Sum]() | 寻找数组中和为给定值的两个数 | [📒]() | [Java]() | M | HashTable |  |
| 2 | [Add Two Numbers]() | 链表表示的两数字之和 | [📒]() | [Java]() | M | Linked List | Math |
| 3 | [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters) | 最长不重复子串 |  | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/string/P3.java) | M | String | Two Pointers |
| 4 | [Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays) | 两有序数组合并后的中位数 | []() | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/array/P4.java) | H | Array | Divide Conquer(DC) |
| 5 | [Longest Palindromic Substring](Longest Palindromic Substring) | 最长回文字串 | [`TO OPTIMIZE`]() | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/string/P5.java) | M | String |  |
| 6 | [Zigzag](https://leetcode.com/problems/longest-substring-without-repeating-characters) | 之字形遍历字符串 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p6-zigzag) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/string/P6.java) | E | String |  |
| 7 | [Reverse Integer](https://leetcode.com/problems/longest-substring-without-repeating-characters) | 整数逆置 |  | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/misc/P7.java) | E |  |  |
| 8 | [String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi) | 经典的字符串转整数 |  | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/misc/P8.java) | E |  |  |
| 15 | [3Sum](https://leetcode.com/problems/3sum) | 数组中和为0的三个元素 | [`TODO`]() | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/array/P15.java) | M | Array | Two Pointers |
| 21 | [Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists) | 合并两个已排序链表 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p21-merge-two-sorted-lists-合并两个已排序链表) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/linkedlist/P21.java) | E | Linked List |  |
| 26 | [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array) | 数组元素去重 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p26-remove-duplicates-from-sorted-array-数组元素去重) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/array/P26.java) | E | Array | Two Pointers |
| 28 | [Implement strStr()](https://leetcode.com/problems/implement-strstr) | 查找子串 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p28-strstr-查找子串) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/string/P28.java) | E | DS | Algs |
| 33 | [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array) | 旋转数组的二分查找 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p33-search-in-rotated-sorted-array-旋转数组的二分查找) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/binarySearch/P33.java) | H | Array | Binary Search |
| 38 | [Count and Say](https://leetcode.com/problems/count-and-say) | 找第n个数的字符串表示 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p38-count-and-say-找第n个数的字符串表示) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/string/P38.java) | E | String |  |
| 39 | [Combination Sum](https://leetcode.com/problems/combination-sum) | 和为目标值的全部组合 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p39-combination-sum) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/search/P39.java) | M | Array | Backtracking |
| 41 | [First Missing Positive](https://leetcode.com/problems/first-missing-positive) |  | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p41-first-missing-positive) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/array/P41.java) | H | Array | Sort |
| 44 | [Wildcard Matching](https://leetcode.com/problems/wildcard-matching) | 通配符 | [`TODO`]() | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/string/P44.java) | H | String | DP, Greedy, Backtracking |
| 46 | [Permutations](https://leetcode.com/problems/permutations) | 全排列 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p46-permutations-全排列) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/search/P46.java) | M | Array | Backtracking |
| 49 | [Group Anagrams](https://leetcode.com/problems/anagrams) | 变位词 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p49-group-anagrams-变位词) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/string/P49.java) | M | String, Hash Table |  |
| 53 | [Maximum Subarray](https://leetcode.com/problems/maximum-subarray) | 求连续子数组的最大和（最大子区间和） | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p53-maximum-subarray-求连续子数组的最大和最大子区间和) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/P53.java) | M | Array | DP, D&C |
| 54 | [Spiral Matrix](https://leetcode.com/problems/spiral-matrix) | 螺旋遍历矩阵 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p54-spiral-matrix-螺旋遍历矩阵对偶问题将自然数以螺旋方式填入方阵) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/array/P54.java) | M | Array |  |
| 58 | [Length of Last Word](https://leetcode.com/problems/length-of-last-word) |  | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p58-length-of-last-word) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/string/P58.java) | E | String |  |
| 77 | [Combinations](https://leetcode.com/problems/combinations/) | 求组合数 | [`TODO`]() | [`TODO`]() | M | Array | DFS |
| 78 | [Subsets](https://leetcode.com/problems/subsets) | 求子集 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p78-subsets-求子集) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/search/P78.java) | M | Array | Backtracking |
| 82 | [Remove Duplicates from Sorted List II]() | 链表去重复2 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p82-remove-duplicates-from-sorted-list-ii) | [Java](P82.java) | M | LinkedList |  |
| 83 | [Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list) | 链表去重复 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p83-remove-duplicates-from-sorted-list) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/linkedlist/P83.java) | E | LinkedList |  |
| 86 | [Partition List](https://leetcode.com/problems/partition-list) | 链表分区 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p86-partition-list) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/linkedlist/P86.java) | M | LinkedList | Two Pointers |
| 87 | [Scramble String](https://leetcode.com/problems/scramble-string) |  | []() | [`TODO`]() | H | String | DP |
| 108 | [Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree) | 从有序数列构造平衡二叉树 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p108-converted-sorted-array-to-binary-search-tree-从有序数列构造平衡二叉树) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/binaryTree/P108.java) | M | Tree | DFS |
| 110 | [Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree) | 判断平衡二叉树 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p110-balanced-binary-tree) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/binaryTree/P110.java) | E | Tree | DFS |
| 125 | [Valid Palindrome](https://leetcode.com/problems/valid-palindrome) | 判断回文 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p125-valid-palindrome-判断回文) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/string/P125.java) | E | String |  |
| 127 | [Word Ladder](https://leetcode.com/problems/word-ladder) | 单词演变 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#127-word-ladder-单词演变) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/search/P127.java) | M | Queue | BFS |
| 128 | [Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence) | 最大连续子数组 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p128-longest-consecutive-sequence-最大连续子数组) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/array/P128.java) | H | Array, UF |  |
| 130 | [Surrounded Regions](https://leetcode.com/problems/surrounded-regions) | 被包围区域 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p130-surrounded-regions) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/search/P130.java) | M | UF | BFS |
| 137 | [Single Number II](https://leetcode.com/problems/single-number-ii) | 找单数（3n+1） | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p137-single-number-ii-找单数3n1) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/bits/P137.java) | M |  | Bits |
| 141 | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle) | 判断单链表是否有环 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p141-linked-list-cycle-判断单链表是否有环) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/linkedlist/P141.java) | E | LinkedList | Two Pointers |
| 160 | [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists) | 两条单链表相交求交点 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p160-intersection-of-two-linked-lists-两条单链表相交求交点) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/linkedlist/P160.java) | E | LinkedList |  |
| 190 | [Reverse Bits](https://leetcode.com/problems/reverse-bits) | 整数按二进制序列反转后对应的数 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p190-reverse-bits) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/bits/P190.java) | E | DS | Bit Manipulation |
| 206 | [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list) | 逆置单链表 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p206-reverse-linked-list-逆置单链表) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/linkedlist/P206.java) | E | LinkedList |  |
| 217 | [Contains Duplicate](https://leetcode.com/problems/contains-duplicate) | 数组元素查重 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p217-contains-duplicate-数组元素查重) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/array/P217.java) | E | Array, HashTable |  |
| 223 | [Rectangle Area](https://leetcode.com/problems/rectangle-area) | 求两矩形覆盖的面积 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p223-rectangle-area-求两矩形覆盖的面积) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/math/P223.java) | E |  | Math |
| 322 | [Coin Change](https://leetcode.com/problems/coin-change) | 换零钱 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p322-coin-change-换零钱) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/dp/P322.java) | M |  | DP |
| 378 | [Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix) | 寻找第k小的数 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p378-kth-smallest-element-in-a-sorted-matrix) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/datastruct/P378.java) | M | Heap | Binary Search |
| 397 | [Integer Replacement](https://leetcode.com/problems/integer-replacement/) | 整数n变到1 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p397-integer-replacement-整数n变到1) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/search/P397.java) | E | Tree | DFS, BFS, DP |

| # | [title]() | zh | [📒]() | [Java]() | M | DS | algs |


LintCode

| # | Title | Description | Notes | Solution | Difficulty | Data Structure | Algorithms |
|---| ----- | ----------- | ----- | -------- | ---------- | -------------- | ---------- |
| 31 | [Partition Array](http://www.lintcode.com/problem/partition-array) | 数组划分 | [📒]() | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/lintcode/array/P31.java) | M | Array | Two Pointers |
| 55 | [Compare Strings](http://www.lintcode.com/problem/compare-strings) | 判断两字符串中字母是否子集关系 | [📒]() | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/lintcode/string/P55.java) | E | String |  |
| 82 | [Single Number](http://www.lintcode.com/problem/single-number) | 找单数 （2n+1） | [📒]() | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/lintcode/bits/P82.java) | E |  | Bits |
| 84 | [Single Number II]() | 找单数（2n+2） | [📒]() | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/lintcode/bits/P84.java) | M |  | Bits |
| 92 | [Backpack](http://www.lintcode.com/problem/single-number) | 背包问题 | []() | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/lintcode/dp/P92.java) | E |  | DP |
| 109 | [Triangle](http://www.lintcode.com/problem/triangle) | 数字三角形 | [📒]() | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/lintcode/dp/P109.java) | E |  | DP |
| 110 | [Minimum Path Sum](http://www.lintcode.com/en/problem/minimum-path-sum/) | 矩阵最小路径和 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LintCode.md#p110-minumum-path-sum-矩阵最小路径和dp) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/lintcode/dp/P110.java) | E |  | DP |
| 114 | [Unique Paths](http://www.lintcode.com/problem/unique-paths) | 矩阵中路径总数 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LintCode.md#p114-unique-paths-矩阵中路径总数) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/lintcode/dp/P114.java) | E |  | DP |
| 115 | [Unique Paths II](http://www.lintcode.com/problem/unique-paths-ii) | 有障碍物的矩阵求路径总数 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LintCode.md#p115-unique-paths-ii-有障碍物的矩阵求路径总数) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/lintcode/dp/P115.java) | E |  | DP |
| 125 | [Backpack II](http://www.lintcode.com/problem/backpack-ii) | 01背包 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LintCode.md#p125-backpack-ii-01背包) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/lintcode/dp/P125.java) | M |  | DP |
| 138 | [Subarray Sum](http://www.lintcode.com/problem/subarray-sum) | 求元素和为零的子序列 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LintCode.md#p138-zero-sum-subarray-求元素和为零的子序列) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/lintcode/array/P138.java) | E | Array |  |
| 141 | [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle) | 检测链表是否有环 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p141-linked-list-cycle-判断单链表是否有环) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/linkedlist/P141.java) | E | LinkedList | Two Pointers |
| 142 | [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii) | 链表环路起始结点 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p142-linked-list-cycle-ii) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/linkedlist/P142.java) | M | LinkedList | Two Pointers |
| 146 | [LRU Cache](https://leetcode.com/problems/lru-cache) | LRU算法 | [`TODO`]() | [`TODO`]() | H | LinkedList |  |
| 158 | [Two Strings Are Anagrams](http://www.lintcode.com/en/problem/two-strings-are-anagrams/) | 判断两字符串是否变位词 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LintCode.md#p158-two-strings-are-anagrams) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/lintcode/string/P158.java) | E | String |  |
| 237 | [Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list) | 删除链表某节点 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p237-delete-node-in-a-linked-list) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/linkedlist/P237.java) | E | LinkedList |  |
| 401 | [Binary Watch](https://leetcode.com/problems/binary-watch) | 二进制手表 | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/LeetCode.md#p401-binary-watch) | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/leetcode/misc/P401.java) | E |  | Misc |

| # | [title]() | zh | [📒]() | [Java]() | M | DS | algs |


---
## PART II. 2017校招笔试面试题目整理

| Problem | Corp. | Solution | Notes | Data Structure | Algorithms |
| ------------- | ----- | -------- | ----- | -------------- | ---------- |
| 判断连续数 | 58集团 | []() | []() | Array |  |
| 幸运数1 | 京东 | []() | []() |  | Math |
| 采购单 | 京东 | []() | []() | Array |  |
| 幸运数2 | 京东 | []() | []() |  | Math |
| 爬山 | 京东 | []() | []() | Array |  |
| 最大子区间和 | 滴滴 | []() | []() | Array | Greedy, DP |
| 餐桌分配 | 滴滴 | []() | []() | Array, Heap |  |
| 数组分为两堆后和相差的最小值 | 猿辅导 | [`TO UPDATE`]() | []() | Array | DP |
| 数组分为两堆后平均值相差的最大值 | 猿辅导 | []() | []() | Array | Math |
| 子矩阵的中位数 | 猿辅导 | []() | []() | Array | Heap |
| 最强大脑 | 奇虎360 | [`TO UPDATE`]() | []() | String |  |
| 内存分配 | 奇虎360 | []() | []() |  |  |
| 一圈红包 | 美团 | []() | []() | Array | DP |
| 多叉书的层次遍历 | 美团 | []() | []() | Tree | BFS |
| 经纬度编码（标准二分查找） | 腾讯 | []() |  |  | Binary Search |
| 高楼扔鸡蛋问题| 腾讯 | []() |  |  | DP |
| 经纬度编码（标准二分查找） | 腾讯 | []() |  |  | Binary Search |
| 编程实现生产者消费者模型 | 美图 | []() | []() | Stack |  |
| 求一个数组任意两元素之和的最大值 | 美图 | []() | []() | Array |  |
| 输出二叉树每层最后一个节点 | 京东 | []() | []() | DS | Algs |
| 求组合数C(n, m) | 京东 | [`TODO`]() | []() |  |  |
| 整数n变到1的最少步骤 | 创新工场 | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/exam/ChuangXin_nToOne.java) | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/Interview.md#创新工场涂鸦-sep-13-tue) | Array | BFS, DP |
| 求第n个素数 | 链家 | [`TO UPDATE`]() | []() |  | Math |
| 求某规律字符串数组的第k项 | 链家 | [`TO UPDATE`]() | []() |  | Misc |
| Full Sets on Fabric | 链家 | []() | []() |  |  |
| Big Home | 百度 | [`TO UPDATE`]() | []() | Array | Union Find |
| 树上摘苹果 | 百度 | []() | []() | Tree | DP |
| 括号匹配 | 百度 | []() | []() | Stack |  |
| 保留最大的数 | 搜狐 | []() | []() |  | Math |
| 袋鼠过河 | 搜狐 | []() | []() | Array | DP |
| 彩色宝石项链 | 搜狐 | [`TODO`]() | []() | Array |  |
| 统计二进制中1的个数 | 一点资讯 | [`TO UPDATE`]() | []() |  | Bits |
| “矩阵方格加权最短路径和” | 一点资讯 | []() | []() | Graph | MST?, DP? |
| 最长拼接字符串 | Hulu | [`TO UPDATE`]() | []() | String |  |
| 合法的命令与参数组合 | Hulu | []() | []() |  | ? |
| 爱探索的葫芦娃 | Hulu | [`TO UPDATE`]() | [`TO UPDATE`]() | UF |  |
| 数串拼接成的最大数值 | 猪八戒 | [`TODO`]() | [`TO UPDATE`]() | Array |  |
| 进制转换 | 滴滴 | [`TO UPDATE`]() | []() |  | Math |
| Combination Sum | 滴滴 | [`TODO`]() | []() | Array | DFS, ? |
| [求树的高度](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/Interview.md#小米笔试-sep-23-fri) | 小米 | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/exam/Xiaomi1_treeHeight.java) |  | Tree | Backtracking |
| [手机号码替身](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/Interview.md#小米笔试-sep-23-fri) | 小米 | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/exam/Xiaomi2_.java) | []() |  | Misc |
| [倒序输出一个句子中的单词](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/Interview.md#小米笔试-sep-23-fri) | 小米 | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/exam/Xiaomi3_reverseSentence.java) |  | String |  |
| [导弹防御系统](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/Interview.md#小米笔试-sep-23-fri) | 小米 | []() | [`TODO`]() | Array | ? |
| 二叉树中序遍历非递归 | 一点资讯 | []() | []() | Tree, Stack | DFS |
| 建堆及其查找的复杂度 | 一点资讯 | []() | []() | Heap |  |
| LRU算法实现 | 滴滴 | []() | []() | LinkedHashMap |  |
| BST非递归插入 | 滴滴 | []() | []() | BST | Algs |
| 玩家使用经验丹升级 | 完美世界 | [`TO UPDATE`]() | []() |  | Math |
| 进程协作打印字符 | 完美世界 | [`TO UPDATE`]() | []() |  |  |
| String Shifting | 头条 | []() | []() | String | KMP |
| 字典序数字 | 头条 | []() | []() | Array | Misc |
| 新最大子区间和 | 一点资讯 | [`TO UPDATE`]() | []() | Array |  |
| 丧尸攻击 | 一点资讯 | [`TO UPDATE`]() | []() | Array |  |
| 字符串序列找规律 | 七牛 | []() | []() | String |  |
| 给小朋友派糖 | 链家 | []() |  | Array, Hash |  |
| 求两个日期之间的天数 | 中软融鑫 | []() | []() |  |  |
| 倒序输出一句话中的单词 | 中软融鑫 | []() | []() | String |  |
| 压缩字符串 | Zenjoy | []() | []() | String, Array |  |
| 由二叉树的层次遍历求其中序遍历 | 链家 | []() | []() | Tree | BFS |
| 下一个对称整数 | 去哪儿 | []() | []() |  |  |
| 两字符串是否有相同字符集构成 | 去哪儿 | []() | []() | String |  |
| 销售员最多销售天数 | Amazon | []() | []() | Array |  |
| 有序循环链表的插入操作 | Amazon | []() | []() | LinkedList |  |
| 最长重复子串 | 新浪 | []() | []() | String |  |

| desc | Corp | Code | Notes | DS | Algs |


---
## PART III. Basis（基础数据结构与算法笔记）

| Category | Title | Implementation | Notes |
| -------- | ----- | -------------- | ----- |
| Basic Data Structure | Heap | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/basis/datastruct/MaxHeap.java) | [`TODO`]() |
| Basic Sorting | Quick Sort | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/basis/sorting/QuickSort.java) | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/basis.md#quick-sort) |
| Basic Algorithm | Binary Search | [Java](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/src/basis/algorithm/BinarySearch.java) | [📒](https://github.com/SmartJuneThx/AlgrithmsPractice/blob/master/basis.md#binary-search) |

|  | title | [Java]() | [📒]() |

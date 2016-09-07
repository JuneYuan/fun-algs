# LintCode notes

### P31 Array Partitioning 数组划分
方法一：自左向右
用下标`i`遍历数组`nums`，同时用下标`right`保存分界点（>=k的索引）。遍历结束，`right`为所求结果。

方法二：两根指针
快排partition经典代码

```
	int left = 0, right = nums.length - 1;
	while (left <= right) {
		// 从左向右，直到找到 >=k 的索引为止
		while (left <= right && nums[left] < k) 
			++left;
		// 从右向左，直到找到 <k 的索引为止
		while (left <= right && nums[right] >= k)
			--right;
		// 注意进行越界检查！
		if (left <= right) {
			int tmp = nums[left];
			nums[left] = nums[right];
			nums[right] = tmp;
			++left;
			--right;
		}
	}
	return left;
```

### P55 Compare Strings
问字符串A是否包含了字符串B中的所有字符，P158判断变位词的变形题。

先遍历 A 和 B 统计各字符出现的频次，然后比较频次大小即可。万能哈希表。

### P82 Single Number 找单数 （2n+1）
共2n + 1个数，有且仅有一个数落单，要找出这个数。根据异或运算特性`x ^ x = 0和x ^ 0 = x`，可将给定数组的所有数依次异或，最后保留的即为结果。

### P84 Single Number III 找单数（2n+2）
LintCode P82 找单数（2n+1）的follow up。
1. 思路：按P82（2n+1找单数）解法，遍历数组，依次异或，最后可求得`ret = x1 ^ x2`。要想分别求得x1和x2，只需`x1 = ret ^ x2`和`x2 = ret ^ x1`。看起来似乎是死循环，其实利用`ret`对原数组进行分组，即可做到。**分组依据是：**x1与x2不等，所以ret的二进制序列必存在某一位是1，根据这一位是0还是1，可将原数组的剩余`2n`个元素分为两组。至此，问题就转化成了两个`2n+1找单数`。
2. 求一个数二进制序列最低位的1：`x - (x & (x - 1))`。

时间复杂度：两次遍历，O(n)。

### P92 Backpack 同P125（01背包）

### P110 Minumum Path Sum 矩阵最小路径和（DP）
1. 定义状态：`F(x, y)`表示从起点(0, 0)到达位置(x, y)的最小路径和
2. 转移方程：`F(x, y) = grid[x][y] + Min{F(x-1, y), F(x, y-1)}`
3. 注意初始化起点、首行、首列
4. 所求结果：`F(m-1, n-1)`

### P114 Unique Paths 矩阵中路径总数
动态规划矩阵类问题的通用方法：
1. 状态：`F(x, y)`表示从位置(x, y)到达终点的路径总数
2. 转移方程：`F(x, y) = F(x+1, y) + F(x, y+1)`
3. 初始化终点、末尾行、末尾列
4. 所求结果：`F(0, 0)`

### P115 Unique Paths II 有障碍物的矩阵求路径总数
WA：虽然注意到了尾行、尾列初始化的问题，但还是漏掉了右下角元素（`grid[m-1][n-1] == 1`时，结果应为0）。

### P125 Backpack II 01背包


### P138 Zero Sum Subarray 求元素和为零的子序列

#### 方法一：两重循环

遍历`i = 0..len`，对于每一个`i`，把它作为子区间的左边界，遍历`j = i..len`作为子区间的右边界，看区间和是否为0
```
	int currSum = 0;
	for (int i = 0; i < nums.length; i++) {
		for (int j = i; j < nums.length; j++) {
			currSum += nums[j];
```

#### 方法二：比较子串和(TLE)

思路：注意到，子串和为0，就意味着，**存在不同的`x1`，`x2`，使得`Sigma(0..x1) = Sigma(0..x2)`**。

使用`ArrayList sums`记录数组中从0到索引`i`的和，在将值push进`sums`之前，先检查其中是否已经存在这个值，如果存在，则将相应索引加入最终结果并返回。

时间复杂度：**与方法一相同的！（而且提交后超时了）**根本原因在于`sums.indexOf(curSum)`操作的时间复杂度为线性。

与这种方法类似的有哈希表实现，哈希表的查找在理想情况下可认为是 O(1)。

#### 方法三：哈希表

与方法二几乎一样，只是把存储`sums`的数据结构从`ArrayList`换成了`HashMap`，查找更快。



### P158 Two Strings Are Anagrams 判断两字符串是否变位词

方法一：hashmap 统计字频

对于`比较字符数量`的问题，常用方法为遍历两个字符串，统计各字符出现频次，看是否相等。有很多简单字符串类面试题都是此题的变形题。Python标准库直接支持`为hashable对象计数`。
1. 初始化含有256个字符的计数器数组。
1. 对字符串 s 中的字符，计数增1，字符串 t 中的字符减1，再遍历letterCount数组看有无非0值（若有则不是变位词）。

判断互为变位词
```
	final int alphabetNum = 256;
	int[] letterCnt = new int[alphabetNum];
	for (int i = 0; i < s.length(); i++) {
		++letterCnt[s.charAt(i)];
		--letterCnt[t.charAt(i)];
	}
	for (int i = 0; i < alphabetNum; i++) {
		if (letterCnt[i] != 0)  return false;
	}
	return true;
```

判断字符串A是否字符串B的父集
```
	final int alphabetNum = 26;
	int[] letterCnt = new int[alphabetNum];
	for (int i = 0; i &lt; A.length(); i++) {
		++letterCnt[A.charAt(i) - 'A'];
	}
	for (int i = 0; i &lt; B.length(); i++) {
		--letterCnt[B.charAt(i) - 'A'];
		if (letterCnt[B.charAt(i) - 'A'] < 0)   return false;
	}
	return true;
```

方法二：排序字符串
对字符串先排序，若排序后的字符串内容相同，则其互为变位词。

Bug
1. `++letterCnt[s.charAt(i)];`错写成了`++letterCnt[s.charAt(i) - 'a'];`，导致Runtime Error. （因为字符串中可能包含比‘a’小的字符，从而出现负数下标）。
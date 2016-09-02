# NOTES

---

# LeetCode Notes

### P6 Zigzag
一层循环：每个Unit。注：一长一短为一个单元，包含numRows + (numRows-2)个字符
二层循环：A. 该unit的长列；B. 该unit的短列

WA原因：
1. 当numRows为1时，计算unitLen = numRows + (numRows-2)得0，除数为零运行错误。
2. 题目理解，对“之”字形没理解对
3. 处理末尾自负个数不足unitLen得情形，考虑不周，可能出现数组访问越界。
4. 整数运算结果取浮点数：3/5得0.0，1.0*3/5才得0.6

### P7 Reverse Integer
1. 建议获取逆序字符串时，for循环的判断条件设为`i <= j`。原因：考虑参数x = 0的情形，这时若判断条件为`i < j`，则逆序字符序列`rseq`会为空值运行报异常。
2. 数据溢出问题

### P8 String to Integer (atoi)
Lessons
1. 用整型表示符号位，便于后期相乘相加
2. 用预先定义的ans变量存结果，避免调用Long.parseLong()抛异常导致没有结果可返回
3. 处理溢出：可以限制接受的字符位数（int类型最长占10位，加符号位1位，不会超过11位）
4. 读取字符过程中自己计算结果，比调用Long.parseLong()快很多（为啥）

Bugs

根据str得到validStr的过程，涉及几个if...else...屡屡出错。

WAcases

Input: "+", "+-2", "-2147483648"

### P21 Merge Two Sorted Lists 合并两个已排序链表
思（tao）路（lu）：
1. 使用`dummy`节点可避免判断合并后的表头节点来自`l1`还是`l2`；
2. 使用`curr`节点来记录下一个待插入节点的前驱；
3. 当`l1`或`l2`有一个为空时，退出循环，并取非空链表的头部作为`curr`节点的后继。

源码分析：
1. 异常处理，已包含在`dummy.next`中

### P26 Remove Duplicates from Sorted Array
1. 两根指针。一个指针(下标)遍历数组，另一个指针(下标)负责将不重复的数置于原数组的正确位置。

2. 很简单，但出现编译错误——
```
int ans;
for (int i = 1, ans = i; ...) {...}
```

### P28 strStr
在源字符串source中查找子串target。
1. 双重for循环
2. KMP

### P38 Count and Say （找第n个数的字符串表示）
表示规则：对于连续字符串，表示为重复次数+数本身。

#### 方法一：直接遍历
模拟手工操作，扫描字符串，为`每个单元`计数、输出即可（每个单元：如"111221"包括"111"、"22"、"1"共三个单元）。

#### 方法二：递归 
`// TODO`

### P41 First Missing Positive
方法：
1. 使用**类似桶排序**的方法：将值放在它应该在的位置
2. 再扫描一次得出哪个位置有缺少值。

### P49 Group Anagrams （变位词）
寻找`字符串数组`中的变位词，基础版是判断`两个字符串`是否变位词。

#### 方法一：双重for循环（判断两两之间是否互为变位字符串，TLE）
1. strs长度小于等于1时，直接返回。
2. 使用与 strs 等长的布尔数组，表示某字符串是否已被添加到最终的返回结果中。
3. **双重遍历strs，注意避免重复添加。**
4. 私有方法`isAnagrams`用于判断两个字符串是否互为变位词（hashmap 统计字频）。

时间复杂度：`isAnagrams`最坏为O(2L)，双重for循环为O(n2)，整体为O(Ln2)。


#### 方法二：排序＋hashmap
（这也是一开始的思路）
1. 遍历字符串数组strs，建立key为字符串、value为相应变位词集的hashmap。
1. Java 中对 String 排序可先将其转换为 char[], 排序后再转换为新的 String
```
	char[] strChar = str.toCharArray();
	Arrays.sort(strChar);
	String strSorted = String.valueOf(strChar);
```

时间复杂度：遍历字符串数组，需O(n)，对单个字符串排序O(LlogL)，整体为O(nLlogL)。

### P53 Maximum Subarray 求连续子数组的最大和

#### 方法一：Kadane's algorithm / 贪心
逐个遍历数组元素并将其加入累加和`sum`，如果累加和大于记录的最大和`maxSum`，则更新`maxSum`。如果`sum`小于等于0，表明之前的子数组不会提高后续数组的累加和，故抛弃之前的子数组，将`sum`重新置为0。这样遍历数组即可得到maxSum。

#### 方法二：分治 / DP
`TODO`
不是太懂

### P58 Length of Last Word
1. 不仅需要考虑`s == null || s.length() == 0`的情况，还要考虑s只包含空格的情况，所以首先要`trim()`去除头尾的空格。

### P125 Valid Palindrome
两步走：
1. 找到最左边和最右边的下一个合法字符（字母或数字）
2. 一致转换为小写进行比较

字符的判断尽量使用语言提供的API。

### 127 Word Ladder 单词演变
典型的**广度优先搜索**题目。
1. 题意关键：一次只能改动一个字符；改动的中间结果必须出现在词典中。
1. 思路：首先将 start 入队，随后弹出该节点，比较其和 end 是否相同；再从 dict 中选出所有距离为1的单词入队，并将所有与当前节点距离为1且未访问过的节点（需要使用哈希表）入队，方便下一层遍历时使用，直至队列为空。
1. 给定数据结构特征选用合适的实现，遇到哈希表时多用其查找的O(1) 特性。
1. Bug：`while(qLen-- > 0)`写成了`while(qLen-- >＝ 0)`，导致异常，查了很久。
2. BFS遍历方式，这道题里，只能是一段一段地遍历，像这样
```
		while (!q.isEmpty()) {
		    // Operation... @_@看这里
		    int qLen = q.size();
		    while (qLen-- > 0) {
		    	// Operation...
		    	q.offer(nextWord);
		    }
		}
```
而不能是一个一个地遍历，像这样
```
		int i = 0;
		while (i < seq.size()) {
			// Operation...
			seq.add(new Pair(newX, newY));
		
			i++;
		}
```

### P137 Single Number II 找单数（3n+1）
#### 解法一：逐位处理
1. 思路：`2n+1`可以利用二进制异或运算特性，`3n+1`呢？——三个相同的数相加，用二进制表示，则结果的每一位都能被3整除。所以用一个`Integer.size()`大小的数组记录每一位累加的结果即可。

		for (int i = 0; i < Integer.SIZE; i++) 
			for (int j = 0; j < nums.length; j++) 
时间复杂度：`O(3n+1)*32`（注：32代表整型变量的比特数）。			
2. 求整数`x`从低位到高位的第`i`个比特：`(x >> i) & 1`。

#### 解法二：算是动态规划吧
可以推广到`K*N + L`问题。定义数组`x[]`，长度为`K`。遍历整个数组，对于读到的每一个值`a`而言，`x[i]`的含义如下：它的每一个二进制位，表示目前为止该二进制位值为1的数有`i`个。得状态转化关系：`x[j] = (x[j - 1] & a) | (x[j] & ~a)`。
> "The first part indicates the carries from previous one. The second part indicates the bits not carried to next one."


### P217 Contains Duplicate 数组元素查重
利用HashTable查找的O(1)特性。遍历数组元素，每次插入集合，若不成功，则return true；全部插入成功，返回false。

### P223 Rectangle Area 求两矩形覆盖的面积
计算两个矩形的总面积然后减去重叠的部分就得到了总面积，关键在于重叠部分面积的计算。

### P322 Coin Change 换零钱
典型动态规划题目。
1. 用贪心会错，因为测试数据不一定都像`[1, 2, 5]`一样有`单元货币`，贪心判定为无解的，实际可能有解。（考虑样例`coins = [186,419,83,408]`，`amount = 6249`，用贪心，6249 = 419*14 + 186*2 + 11，无解，返回-1，实际则应返回20）
2. 动态规划：定义`dp[i]`表示`amount为i时最少需要的硬币数`。那么用 i 依次减去每个硬币的面值，看剩下总额最少需要多少硬币数，即递推公式`dp(i) = Min(dp(i), Min(dp(i - coins[0..N])) + 1)`，N为coins[]数组长度。

### P378 Kth Smallest Element in a Sorted Matrix
在行列均排好序的矩阵中找第k小的数字，难度Medium。

#### 方法一：大顶堆解决第K小问题
用大根堆来存储当前最小的k个数字——遍历矩阵，如果遍历位置数字大于等于堆顶元素，跳过该行继续遍历，否则将数字存入堆中并删除堆顶数字（保证堆中有k个数字）。最终堆顶数字即是第k小的数字。
参考：[基于堆实现的优先级队列：PriorityQueue 解决 Top K 问题](http://my.oschina.net/leejun2005/blog/135085)

#### 方法二：小根堆
逐次取出最小的数字来找出最终结果。
1. 将第一行元素存入小根堆，最小元素必定在堆顶（matrix[0][0]）
2. 然后删除堆顶数字并用它同列的下一数字代替，这样当前最小的数字依然在堆顶
3. 遍历k次后即可得到第k小的数字
4. 由于需要记录数字的坐标，这里用内部类包含了数字值和两个坐标。内部类要实现Comparable接口
1. 注意：`Comparable`接口实现，编译提示参数类型错误。正确写法应在类声明中`使用范型`
```
    private class Node implements Comparable<Node> {
		……
    	
		@Override
		public int compareTo(Node o) {
			return this.val - o.val;
		}
    }
```

#### 方法三：
二分查找。在二分查找循环中，统计矩阵中小于等于中间值的数字个数，拿它和k比较来确定第k小的数字在左半部分还是右半部分。


--------

# LintCode notes

### P31 Array Partitioning
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


### P138 Subarray Sum
求元素和为零的子序列

方法一：两重循环

内层循环应从`int j = i`开始。

方法二：比较子串和(TLE)

使用`int curSum`保存到索引`i`处的累加和，`ArrayList sums`保存不同索引处的和。执行`sums.add(curSum)`之前先检查`curSum`是否为0，再检查`curSum`是否已经存在于`sums`中。**时间复杂度与方法一相同的！**根本原因在于`sums.indexOf(curSum)`操作的时间复杂度为线性。

与这种方法类似的有哈希表实现，哈希表的查找在理想情况下可认为是 O(1)。

方法三：哈希表

与方法二几乎一样，只是吧存储`sums`的数据结构从`ArrayList`换成了`HashMap`，查找更快。

### P158 Two Strings Are Anagrams
判断两字符串是否变位词。

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
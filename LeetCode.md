# LeetCode Notes

### P1 Two Sum 寻找数组中和为给定值的两个数
方法一：最傻的办法，枚举
双重for循环，枚举所有`C N 2`种组合。简单粗暴，但超时。
方法二：HashMap
找两数之和为`target`，其实并不需要真的去“捉”两个数出来，求和，与`target`比对。因为问题可以转化到找一个数，而找一个数，可以直接遍历，还有更快的哈希。
转化方式：`A[i] + A[j] = target` <==> `A[i] = target - A[j]`
这种方法可写成简单的两次循环（一次遍历建好map，一次遍历查找“补数”是否存在）；也可优化到只进行一次遍历。

### P2 Add Two Numbers 模拟链表加法

### P3 Longest Substring Without Repeating Characters 最长不重复子串

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
1. 使用`dummy`节点，可避免判断合并后的表头节点来自`l1`还是`l2`；
2. 使用`curr`节点来记录下一个待插入节点的前驱，自然`curr`应初始化为`dummy`；

源码分析：
1. 异常处理，已包含在`dummy.next`中。
2. 对非空的`l1, l2`循环处理，将较小者链接到`curr.next`，向后递推`curr`
3. 最后处理`l1`或`l2`有一个为空：退出`while`循环，将非空链表头链接到`curr.next`
4. 返回`dummy.next`，即最终的首元素

### P26 Remove Duplicates from Sorted Array 数组元素去重
1. 两根指针。一个指针(下标)遍历数组，另一个指针(下标)负责将不重复的数置于原数组的正确位置。

2. 很简单，但出现编译错误——
```
int ans;
for (int i = 1, ans = i; ...) {...}
```

### P28 strStr 查找子串
在源字符串source中查找子串target。
1. 双重for循环
2. KMP

### P33 Search in Rotated Sorted Array 旋转数组的二分查找
思路可以参考二分查找，只是这里原本有序的数组被分成前后两段并颠倒过了，所以中间元素的比对更加复杂。**对于旋转数组可通过画图来辅助分析。**

这里分别用`l`, `m`,`r`表示二分查找过程中左端、中间、右端的元素下标，然后考虑如下两种方法。

#### 方法一：直接比较target与A[m]
旋转之后，有两个不确定因素会影响二分法下一步搜索区间的选取：1.`m`与断点`p`的大小关系；2. `target`落在左半边还是右半边。于是可以讨论所有可能情况——

若`target == A[m]`，直接返回`m`，否则

1. `m > p`，**隐含条件`A[m] < A[L]`**
![](http://ww4.sinaimg.cn/large/6b9392ddgw1f7l8b4xk3xj20b806nt96.jpg)
当`target < A[m]`，搜索区间应为`[L, m - 1]`；
当`target > A{m]`，还需讨论，
 + 当`target < A[L]`，搜索区间应为`[m + 1, r]`;
 + 当`target >= A[L]`，搜索区间应为`[L, m - 1]`。
1. `m < p`，隐含条件**`A[m] > A[L]`**
![](http://ww3.sinaimg.cn/large/6b9392ddgw1f7l8cam3eij20bl07a0t7.jpg)
当`target < A[m]`，还需讨论
 + 当`target < A[L]`，搜索区间应为`[m + 1, r]`；
 + 当`target >= A[L]`，搜索区间应为`[L, m - 1]`;
当`target > A[m]`，搜索区间应为`[m + 1, r]`。

重新整理上述两种情况，写出二分查找代码，就成了
```
	int lb = 0, ub = A.length - 1;
	while (lb <= ub) {
		int mid = (lb + ub) / 2;
		if (A[mid] == target)	return mid;
		
		// 目标值小于A[m]
		if (target < A[mid]) {
			// 第一个图的情形：m > p, A[m] < A[L]
			if (A[mid] < A[lb])		ub = mid - 1;
			// 第二个图的情形：m < p, A[m] > A[L]
			else {
				if (target < A[lb])	lb = mid + 1;
				else				ub = mid - 1;
			}
		} 
		// 目标值大于A[m]
		else {
			// 第一个图的情形：m > p, A[m] < A[L]
			if (A[mid] < A[lb]) {
				if (target < A[lb])	lb = mid + 1;
				else				ub = mid - 1;
			}
			// 第二个图的情形：m < p, A[m] > A[L]
			else					lb = mid + 1;
		}
	}
```

#### 方法二：比较`A[L]`与`A[m]`，可以有效简化判断
仍对于上图两种情况分析，
1. `m > k` <==> `A[m] < A[L]` <==> `[m, r]`部分是单调的，所以，要么`target`落在区间`[m, r]`，这就成了标准的二分，要么`target`落在区间`[L, m]`；
2. `m < k` <==> `A[m] > A[L]` <==> `[L, m]`部分是单调的，这样，问题也被分解成了两种子情况。

#### 补充 `TODO`
需要注意的是**循环条件**和**边界更新**的写法。

### P38 Count and Say 找第n个数的字符串表示
表示规则：对于连续字符串，表示为重复次数+数本身。

#### 方法一：直接遍历
模拟手工操作，扫描字符串，为`每个单元`计数、输出即可（每个单元：如"111221"包括"111"、"22"、"1"共三个单元）。

#### 方法二：递归 
`// TODO`

### P41 First Missing Positive 
方法：
1. 使用**类似桶排序**的方法：将值放在它应该在的位置
2. 再扫描一次得出哪个位置有缺少值。

### P46 Permutations 全排列
#### 方法一：按定义，递归地求
类比成N个球要放进N个空箱子的不同放法。

#### 方法二：模拟字典顺序，迭代地求

### P49 Group Anagrams 变位词
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

### P53 Maximum Subarray 求连续子数组的最大和（最大子区间和）
#### 方法一：Kadane's algorithm / 贪心
逐个遍历数组元素并将其加入累加和`sum`，如果累加和大于记录的最大和`maxSum`，则更新`maxSum`。如果`sum`小于等于0，表明之前的子数组不会提高后续数组的累加和，故抛弃之前的子数组，将`sum`重新置为0。这样遍历数组即可得到maxSum。
重新理解`“贪心”`，不是都得像“找零钱”那样的过程，才叫贪心。

#### 方法二：DP1（区间和）
`TODO`
不是太懂

#### 方法三：DP2（局部与全局）
`TODO`

### P54 Spiral Matrix 螺旋遍历矩阵（对偶问题：将自然数以螺旋方式填入方阵）
一开始想到三种思路：
1. 构造`N*M`大小的`result`，遍历`result`，计算每个元素应取自哪行哪列
2. 顺序遍历`matrix`，计算每个元素应落在`result`的哪个位置
3. 直接按照题意写代码，螺旋方式遍历`matrix`，将取到的元素逐个加入`result`中。想想觉得这种方法代码非常好写。

#### 注意
1. 异常处理
2. 采用循环控制语句取`matrix`中元素加入`result`时，控制条件一定要`&& cnt < N * M`，否则可能无法及时退出循环，并得到错误结果。

### P58 Length of Last Word
1. 不仅需要考虑`s == null || s.length() == 0`的情况，还要考虑s只包含空格的情况，所以首先要`trim()`去除头尾的空格。

### P125 Valid Palindrome 判断回文
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

### P378 Kth Smallest Element in a Sorted Matrix 寻找第k小的数
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


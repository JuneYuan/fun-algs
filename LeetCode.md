# LeetCode Notes

### P1 Two Sum 寻找数组中和为给定值的两个数
方法一：最傻的办法，枚举
双重for循环，枚举所有`C N 2`种组合。简单粗暴，但超时。
方法二：HashMap
找两数之和为`target`，其实并不需要真的去“捉”两个数出来，求和，与`target`比对。因为问题可以转化到找一个数，而找一个数，可以直接遍历，还有更快的哈希。
转化方式：`A[i] + A[j] = target` <==> `A[i] = target - A[j]`
这种方法可写成简单的两次循环（一次遍历建好map，一次遍历查找“补数”是否存在）；也可优化到只进行一次遍历。

### P2 Add Two Numbers 模拟整数加法
处理循环条件、更新节点数据以及进位`acc`，比较容易出错。

还有一些代码写得太冗余——
```
            ListNode tmp = new ListNode(0);
            tmp.val = add % 10;
            sum.next = tmp;
```

=> `p.next = new ListNode(add % 10)`就可以了。。。

还有
```
acc = (add >= 10) ? 1 : 0
```
=> 不就是`acc = add / 10`么。。。


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

### P39 Combination Sum
和`P46 Permutations`十分类似，区别在于剪枝函数不同。这里允许一个元素被多次使用，故递归时传入的索引值不自增，而是在 for 循环中控制。

### P41 First Missing Positive 
方法：
1. 使用**类似桶排序**的方法：将值放在它应该在的位置
2. 再扫描一次得出哪个位置有缺少值。

### P46 Permutations 全排列
#### 方法一：按定义，递归地求
类比成N个球要放进N个空箱子的不同放法。

说明

为什么单独处理nums.length == 1的情况？——因为这种情况若不单独处理，则进入for循环后`numsNew`是空数组`[]`，`resTemp = permute(numsNew)`随之也是空数组`[]`，导致无法进入循环体中的`ret.add(temp)`，最后返回的ret为[]，答案错误。

#### 方法二：类似Subsets求子集问题的做法
只取元素个数等于父集的那些结果

#### 方法三：模拟字典顺序，迭代地求

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

### P78 Subsets 求子集
原问题可以转化为数学中的组合问题。

#### 解法一：对每个子集唯一编码，迭代处理
一个集合的子集数目是`2^n`（因为每个元素都有加入、不加入子集两种可能，总共n个元素）。`0 ～ 2^n - 1`这些数值刚好可以对每个子集进行唯一编码。利用类似`bit map`的原理，对某个子集来说，如果二进制编码的`index`位为1，就将`nums[index]`加入该子集。

#### 解法二：DFS枚举
使用不同的统计方法，写出了两种`dfs`函数

思路一：考虑某个子集`S`，任意一个元素，可能加入`S`、也可能不加入`S`。针对两种情况，分别递归处理。递归到不能再递归，就完成了一趟枚举，得到了一个子集。

思路二：不一定要枚举完每一个数，枚举到第`i`位时，当即就把它加入最后的答案。这是正确的，因为，子集的子集一定也是最终集合的子集。

注意：将临时`list`添加到最终结果时，应新生成一个对象，否则最终返回结果将随着`list`变化而变化。

**借助图形的递归分析，非常有助于理解回溯法。**以数组`[1, 2, 3]`进行分析。下图所示为`list`及`result`动态变化的过程，箭头向下表示`list.add()`及`result.add()`操作，箭头向上表示`list.remove()`操作。

![](http://ww3.sinaimg.cn/mw690/6b9392ddgw1f7xtyx77mqj218g0xcn1y.jpg)

### P82 Remove Duplicates from Sorted List II
1. P83保留重复值节点的一个，与这道题删除全部重复节点，区别在于不能确定链表头是否删除。若采用一般方式，需要较多的`if`条件语句；更好的方法是，**引入dummy node来处理链表头节点不确定的问题**。
```
ListNode dummy = new ListNode(0);
dummy.next = head;
```
考虑链表`A->B->C`，删除B时，需要处理`A`和`C`，将`A`的`next`指向`C`，所以删除节点的操作需要涉及三个链表节点。且不能删除当前节点，只能改变当前节点的`next`指向的节点。
1. 源码分析
`curr`迭代访问整个链表，若下一节点值存在重复，就逐个删掉所有重复元素，删除过程，借助`runner`指针来完成；否则继续遍历。


### P83 Remove Duplicates from Sorted List
使用两个指针：`curr`迭代访问整个链表，`runner`用于检查后续节点是否与`curr`重复了。

**复杂度分析**

遍历链表一次，时间复杂度为O(n)，使用中间变量进行遍历，空间复杂度为O(1).

### P86 Partition List
1. 起初想着参照快排的“快慢指针”写法，结果WA，因为题目说"You should preserve the original relative order of the nodes in each of the two partitions", 而那样写会打破顺序。
2. 直接创建两个链表，一个存放小于`x`的元素，一个存放大于等于`x`的元素。迭代访问整个链表，将元素插入`left`或`right`链表，遍历完成后，合并两个链表并返回。《CC150》还提供了头插法维护两个链表的版本，但是不适用于这道题目的要求。
3. 使用`dummy`避免头节点处理的麻烦，是很可取的。

### P108 Converted Sorted Array To Binary Search Tree 从有序数列构造平衡二叉树
思路：折半取中

中序遍历`二叉搜索树`可得到升序`nums[]`，这道题是反过来，由升序`nums[]`逆推出来`二叉搜索树`。题目还要求是一颗`平衡二叉搜索树`，那么只要将`nums[]`不断均分为左右两半部分即可。

处理过程可采用递归。

### P110 Balanced Binary Tree
递归函数`height(TreeNode )`，或`height(TreeNode , int )`边界条件要仔细斟酌。

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
2. BFS遍历方式，这道题里，只能是**一段一段**地遍历，像这样
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
而不能是**一个一个**地遍历，像这样
```
		int i = 0;
		while (i < seq.size()) {
			// Operation...
			seq.add(new Pair(newX, newY));
		
			i++;
		}
```

### P128 Longest Consecutive Sequence 最大连续子数组
首先想到排序 + 动态规划来做，但是题目要求时间复杂度为O(n)，排序无法满足。接下来考虑空间换时间，哈希表。题目要求返回数值上形成的最长连续序列长度，不关心位置是否连续，也很符合哈希表的用法。

由于给定一个数，其相邻数要么比它小1，要么大1，那么只需要往左往右搜索直到在数组中找不到数为止。结合哈希表查找为O(1)的特性即可满足要求。

### P130 Surrounded Regions

#### 思路一：模拟
手工操作的话，可分为两步：1. 定位被包围的`'O'`区域；2. 把这些`'O'`改为`'X'`.

第二步好说，第一步定位怎么做呢？——`所有的'O' = 被包围的'O' U 未被包围的'O'`，所以得到了`未被包围的'O'`，也就得到了`被包围的'O'`。而`任一个'O'未被包围当且仅当它与最外围的'O'连通`。不妨在搜索`未被包围的'O'`的过程中，将它们每一个都暂时修改为`#`，那么搜索结束后，`board`上的所有元素分为3类：
 + 原本就是`'X'`的 <==> `board[i][j] == 'X'`
 + 未被包围的`'O'`，即与最外围`'O'`连通的`'O'` <==> `board[i][j] == '#'`
 + 被包围的`'O'` <==> `以上两类的补集`

#### 思路二：并查集

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

### P190 Reverse Bits
/\* 无符号数映射成有符号数，相当于从 Domain `[0, 2^32 - 1]` ~ Range `[-2^31, 2^31 - 1]`. \*/

步骤分解为：输入`n` -> `n`的二进制原码 -> `n`二进制原码的逆序 -> 输出按补码解读出来的int值

1. 前两步：`n` -> `n`的二进制原码
循环取出`n`的二进制表示的最低到最高位即可
```
        for (int i = 0; i < 32; i++) {
            char bit = ((n >> i) & 1) == 0 ? '0' : '1';
            tcBits.append(bit);
        }
```
2. 第三步，`按补码解读一个二进制序列`
若符号位为0，直接调用`Long.parseLong()`即可，这里因为`n`的取值可能超出`int`表示范围，所以使用`long`; 若符号位为1，则`取反码再加一`可得到所求结果的绝对值，乘以`-1`返回，即可。
```
        if (tcBits.charAt(0) == '0') {
        	result = Long.parseLong(tcBits.toString(), 2);
        } else {
        	StringBuilder smBits = new StringBuilder();  // 原码
        	
            for (int i = 0; i < 32; i++) {
                char bit = tcBits.charAt(i) == '0' ? '1' : '0';
                smBits.append(bit);
            }
            
            result = Long.parseLong(smBits.toString(), 2) + 1;
            result *= (-1);
        }
```

### P141 Linked List Cycle
快慢指针检测链表是否有环：fastRunner一次移动两步，slowRunner一次移动一步，好比两辆赛车绕着同一赛道以不同速度前进，最总必然会相遇。

fastRunner会不会刚好“越过” slowRunner，而没有相遇呢？——不会。反证：假设fastRunner越过了slowRunner，当前slowRunner处于位置`i`，fastRunner处于位置`i + 1`，那么考虑前一步，slowRunner已经处于`i - 1`，fastRunner呢，也是处于`i - 1`，就是说，两者已经相遇了。

### P142 Linked List Cycle II
由检测链表是否存在环的问题演变而来，结论比较简单，推理过程略麻烦，详见《CC150》 P126.

### P206 Reverse Linked List
题目建议完成迭代和递归两种实现。

#### 迭代实现
头插法实现单链表就地逆置。循环进行头插的核心代码如下：
```
        while (head != null) {
            ListNode next = head.next;  // 保存head下一节点，用于更新循环变量
            head.next = dummy;          // 这句和下句就是头插
            dummy = head;
            
            head = next;                // 更新循环变量
        }
```

#### 递归实现
1. 退出条件
 + 原链表为空，直接返回`null`
 + 原链表只有一个元素，返回该元素
2. 递推关系
`reverseList(head) = reverseList(head.next) ⨁ head`, 其中作为函数参数出现的`head`和`head.next`都表示链表，最后一个`head`表示节点，`⨁`表示link.

这个完成之后，`head`成了最后一个节点，但`head.next`还保留着原来的数据，所以需要“善后”：
```
head.next.next = head;  // 相当于⨁的作用
head.next = null;  // 断开head与原链表后续节点之间的link（尾部插入节点）。
```

### P217 Contains Duplicate 数组元素查重
利用HashTable查找的O(1)特性。遍历数组元素，每次插入集合，若不成功，则return true；全部插入成功，返回false。

### P223 Rectangle Area 求两矩形覆盖的面积
计算两个矩形的总面积然后减去重叠的部分就得到了总面积，关键在于重叠部分面积的计算。

### P237 Delete Node in a Linked List
1. Foolish approach: Repeatedly copy data of `next Node` to current Node, and delete `next Node` only when it is `the last Node`.
2. Wiser approach: Copy data of `next Node` to current Node, and delete `next Node` directly (once is enough).

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

### P397 Integer Replacement 整数n变到1
搜索问题。

#### 方法一：DFS
直接按照题意，写出递归代码。由于`n`取值可能为`MAX_INT`，这时`N + 1`会溢出，注意处理。
```
    private int dfs(int N, int depth) {
    	if (N == 1)	return depth;
    	
    	if ((N & 1) == 0) {
    		return dfs(N >> 1, depth + 1);
    	} else {
    		int len1 = dfs(N - 1, depth + 1);
    		int len2 = dfs(N + 1, depth + 1);
    		return Math.min(len1, len2);
    	}
    }
```

#### 方法二：BFS
所有可能的路径形成了一棵树（准确说还是一颗二叉树），层次遍历这棵树，遇到值为1的节点时停止遍历，输出路径长度即可。

可对比`P127 Word Ladder 单词演变`

#### 方法三：DP
动态规划也可以做，不过对于这道题不是非常合适。

**定义状态dp(i): **表示正整数i变换到1需要的最少步数

转化方程有两种思路来写——

**正向转化方程：**`dp(i) = min{dp(i下一步可能变换到的值)} + 1`，具体跟`i`的奇偶性有关。举例：dp(20) = dp(10) + 1; dp(15) = min{dp(14), dp(16)} + 1.

**逆向转化方程：**`dp(可能通过一步变换得到i的那些值) = dp(i) + 1`，具体跟i的奇偶性有关。举例：dp(14) = dp(7) + 1; dp(15, 17, 32) = dp(16) + 1. 思路有点像素数筛法，根据`dp(i)`就把那些一步能到达`i`的值确定下来了。

逆向方程写起代码来更容易踩坑，比如：

1. 给`dp[2 * i]`, `dp[i + 1]`赋值时要检查下标是否越界
2. 已经赋过值的，不能重新赋值（否则就把最优解覆盖掉了）
3. `i`为偶数时，不仅要为`dp(2 * i)`填值，还要注意判断，若`i`为2的幂，则需将`dp(2 * i - 1)`赋值为`dp(2 * i) + 1`

### P401 Binary Watch
思路：枚举所有可能的`“时间：小时”`，连同其对应的LED亮灯个数，存进一个`map`当中。对于输入的`n`，只需要遍历`map`取出所有亮灯数等于`n`的时间即可。

注意：常用的格式化字符串`String.format()`。比如这道题中，`String.format("%04d", 99)  //0099`


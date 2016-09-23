# Exam / Interview problems 

2017校招笔试、面试算法题目记录。


### 58集团 Sep 2, Fri
**判断连续数** `TODO LeetCode哪道题？`
海哥帮找的代码

### 京东 Sep 5, Mon  `TODO 思路解法还没有写`
1. **幸运数：**十进制各位数值之和＝二进制各位数值之和的数。输入`N`，输出`(0, N]`的幸运数个数。
1. **采购单**
balabala
![](http://ww2.sinaimg.cn/mw690/6b9392ddgw1f7oxg074yqj20kk0idwni.jpg)

> ![](http://ww3.sinaimg.cn/large/6b9392ddgw1f7oxdk8ot2j21kw166wrn.jpg)
1. **幸运数**：只由4和9组成的数。输入`k`，输出从小到大排，处于第k个的幸运数。
思路：要先缓存。
1. **爬山**
思路：先考虑一个问题模型，起始值0，结束值也为0，中间有若干个值，每个值相比前一个值可以`+1`、`-1`、`+0`，求可能出现的最大值。

### 滴滴出行 Sep 6, Tue  `TODO 思路解法还没有写`
1. **最大子区间和**
见LeetCode P53。
1. **餐桌分配**
> `N`张桌子，数组`seats[]`为每个桌子可容纳的最大人数。
`M`批客人，数组`headCnt[]`为每批客人的人数，数组`spend[]`为相应的消费金额。求一个餐桌分配方案，使预计消费总额最大。
![](http://ww1.sinaimg.cn/large/6b9392ddgw1f7ox06s2ulj20bb0b1q3w.jpg)

### 猿辅导面试 Sep 10, Sat  `TODO 思路解法还没有写`
1. 求|sum(A) - sum(B)|最小值，`nums[i]`范围`[0, 100]`，`N`不超过10000.  
思路：记数组的总和为`total`，最理想的情况，`|sum(A) - sum(B)| ＝ 0`，即`sum(A) = halfTotal = total / 2`，若不存在，退而考虑有没有`sum(A) = halfTotal - 1`。
确定了一个集合的所有元素，也就确定了另一个集合。不妨以集合A为讨论对象，数组中的每个元素，要么加入A，要么不加入。这就跟01背包问题很类似了。
定义状态`DP(i)`为：处理到数组第`i`个元素时，`sum(A)`所有可能的取值，那么`DP(i)`将是一个集合。
所求结果：令`sum(A)`等于，众多`DP(i)`中最接近`halfTotal`的那一个值，计算结果即可
转移方程：`DP(i) = DP(i - 1) ∪ DP(i - 1) ⊕ A[i]`，其中符号`⊕`表示，左边集合中每个元素取值都增加`A[i]`。
**重新理解`动态规划DP转移方程`，不是非得写成`dp(i) = Max(dp(i - 1), sth)`式子的，才叫动态规划或者背包。**
这道题使用`Set`存储`possibleSumA`时出了问题：`java.util.ConcurrentModificationException`。原因：对集合进行迭代的时候，如果同时对其进行修改，就会抛出java.util.ConcurrentModificationException异常。
2. 求|avg(A) - avg(B)|最大值，条件同上
3. 输出`N*N`矩阵的所有`m*m`子矩阵的中位数

### 奇虎360 Sep 10, Sat
1. **最强大脑（字符串匹配）**
> ![](http://ww1.sinaimg.cn/mw690/6b9392ddgw1f7pp73pnx4j20eb0g2tcs.jpg)

> ![](http://ww1.sinaimg.cn/mw690/6b9392ddgw1f7pp9ql4yxj20e60dddiw.jpg)


1. 内存分配
> ![](http://ww4.sinaimg.cn/mw690/6b9392ddgw1f7ppcr6mxfj20dt0bsmzi.jpg)
![](http://ww2.sinaimg.cn/mw690/6b9392ddgw1f7ppd9qnxzj20d408kabh.jpg)


### 美团 Sep 11, Sun
1. **一圈红包（DP）**
![](http://ww1.sinaimg.cn/mw690/6b9392ddgw1f7pplntpbxj20pg0blaev.jpg)
1. **多叉树的层次遍历（BFS）**
![](http://ww4.sinaimg.cn/mw690/6b9392ddgw1f7ppl0xm6mj20l309rabs.jpg)

### 腾讯 Sep 11, Sun
1. **经纬度编码（标准二分查找）**
这道题对应的是找一个值的lowerBound情形。
1. **Two Prime Sum（LeetCode P2 "Two Sum"衍生）**
1. **楼层扔鸡蛋问题……最坏情况最小次数（DP）** `TODO`
Google经典面试题，题解能看懂，但感觉对问题的把握还不够。
需要重点理解“策略”和“运气好坏”？

### 美图 Sep 12, Mon
题目来自两套试卷

1. 求算术表达式的值
1. 小白鼠检测毒药瓶
先考虑最多情况，取100只鼠，无脑检测。
1. 求一系列bitCount()函数相加的和
1. `for (int i = 0; i < 5; i++)  fork()`问最终的进程个数。
思路：细胞分裂模型，`2^n`
1. 走方格 `TODO`
1. 编程实现生产者消费者模型 `TODO`
这里考`栈的实现`和`多线程同步`。
1. 实现sprintf(String dest, String format [, String arg1] [, ...])
1. 求一个数组任意两元素之和的最大值
1. 大小为几G的文件，每行是一个数字，没有重复，要求从小到大输出所有数字。

### 58面试 Sep 13, Tue
两面都考了排序。一面：自己挑一个排序算法介绍原理。二面：写快排。

### 京东二面 Sep 13, Tue
1. 二叉树的层次遍历，LeetCode找原题？
1. 求组合数C(n, m)
思路：Billyuan讲的subSet？全排列类似方式？Hodor说的递推公式

### 创新工场（涂鸦） Sep 13, Tue
王子遇到的面试题。
问题：
给定一个整数`N ≥ 1`，若为奇数可对其`+1`或`-1`，若为偶数，可用其除以2，目标是得到1。求所需要的最少操作步骤。

思路：
见LeetCode P397 Integer Replacement

思路一：可类比LeetCode P127 Word Ladder，用`BFS`做。
思路二：归纳手工操作过程，直接翻译成代码。 `TODO`

### 链家笔试 Sep 


### 滴滴校招笔试 Sep 23, Fri
1. 十进制数M转换为N进制数
**注意考虑输入为负数**
2. 求数组中和为target的所有可能元素组合数，只输出得数，不需要输出具体是哪些元素
 LeetCode P39, 40 Combination Sum
 这道题超时，好像应该采用迭代解法 `TODO`
 

### 小米笔试 Sep 23, Fri 
1. 求一棵树的高度。输入：总的节点数N，和每一对父子关系。输出：树高。
解法：递归地求，`depth(root) = 1 + Math.max(depth(root.chL), depth(root.chR))`.
需注意：根节点是要自行找出来的。方法：建树时记录每个节点的入度，入度为1的节点即为根。
1. 手机号码替身。
映射规则：f(x) = （(x + 8) % 10）的英文大写单词，其中x为手机号码的某一位。
输入：若干个f(x)的组成的字符串f(x1)f(x2)...，比如ZEROTWOONE
输出：上述x所能形成的最小数值
1. 把一个句子中的单词倒序输出
Easy, ignore
1. 敌方有N枚导弹先后投来，防御系统发射炮弹有如下特点：1）第一枚炮弹可达到任意高度；2）任一枚炮弹的高度不能超过前一枚
思路：求最大不升自序列。 `TODO`

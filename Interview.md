# Interview problems 

2017校招笔试、面试算法题目记录。


### 腾讯 Sep 11, Sun
1. **经纬度编码（标准二分查找）**
这道题对应的是找一个值的lowerBound情形。
1. **Two Prime Sum（LeetCode P2 "Two Sum"衍生）**
1. **楼层扔鸡蛋问题……最坏情况最小次数（DP）**

### 美团 Sep 11, Sun
1. **一圈红包（DP）**
![](http://ww1.sinaimg.cn/mw690/6b9392ddgw1f7pplntpbxj20pg0blaev.jpg)
1. **多叉树的层次遍历（BFS）**
![](http://ww4.sinaimg.cn/mw690/6b9392ddgw1f7ppl0xm6mj20l309rabs.jpg)


### 奇虎360 Sep 10, Sat
1. **最强大脑（字符串匹配）**
> ![](http://ww1.sinaimg.cn/mw690/6b9392ddgw1f7pp73pnx4j20eb0g2tcs.jpg)

> ![](http://ww1.sinaimg.cn/mw690/6b9392ddgw1f7pp9ql4yxj20e60dddiw.jpg)


1. 内存分配
> ![](http://ww4.sinaimg.cn/mw690/6b9392ddgw1f7ppcr6mxfj20dt0bsmzi.jpg)
![](http://ww2.sinaimg.cn/mw690/6b9392ddgw1f7ppd9qnxzj20d408kabh.jpg)


### 猿辅导 Sep 10, Sat  `TODO 思路解法还没有写`
1. 求|sum(A) - sum(B)|最小值，`nums[i]`范围`[0, 100]`，`N`不超过10000.
2. 求|avg(A) - avg(B)|最大值，条件同上
3. 输出`N*N`矩阵的所有`m*m`子矩阵的中位数

### 滴滴出行 Sep 6, Tue  `TODO 思路解法还没有写`
1. **最大子区间和**
见LeetCode P53。
1. **餐桌分配**
> `N`张桌子，数组`seats[]`为每个桌子可容纳的最大人数。
`M`批客人，数组`headCnt[]`为每批客人的人数，数组`spend[]`为相应的消费金额。求一个餐桌分配方案，使预计消费总额最大。
![](http://ww1.sinaimg.cn/large/6b9392ddgw1f7ox06s2ulj20bb0b1q3w.jpg)


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
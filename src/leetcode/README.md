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

### P49 Group Anagrams
方法一：双重for循环
1. strs长度小于等于1时，直接返回
2. 使用与strs等长的boolean数组来记录字符串数组strs中的字符串是否被添加到最终的返回结果中。
3. **双重遍历strs，注意避免重复添加即可**
4. 私有方法`isAnagrams`用于判断两个字符串是否互为变位词。

方法二：排序＋hashmap

（这也是一开始的思路）
遍历字符串数组strs，建立key为字符串、value为相应变位词集的hashmap。（注：遍历到的每一个字符串str，要按字符排好序后才能作为key。Java中可先将str转为char[]，排序后再转为新的String。）

### P58 Length of Last Word
1. 不仅需要考虑`s == null || s.length() == 0`的情况，还要考虑s只包含空格的情况，所以首先要`trim()`去除头尾的空格。

### P125 Valid Palindrome
两步走：
1. 找到最左边和最右边的下一个合法字符（字母或数字）
2. 一致转换为小写进行比较

自负的判断尽量使用语言提供的API



### 第14章 观察者模式

        package observer.coupled 双向耦合的代码
        package observer.decouple1 解耦实践一（分离出抽象的观察者）
        package observer.decouple2 解耦实践二（增加了抽象的通知者接口）
        

class Solution {
public:
    void reverseWords(string &s) {
        int idx = 0;  // 顺次遍历s的每个下标
        int pos = 0;  // 记录正在遍历的那个单词的起始下标（是不断累加的）
        int len = 0;  // 正在遍历的那个单词的长度（是会定期置0的）
        
        while (true) {
            while (idx < s.size() && s[idx] == ' ') {
                ++idx;  // 可以去除leading, trailing, 以及单词中间的空格
            }
            if (idx == s.size()) {
                break;  // 字符串结束，退出循环
            }
            
            if (pos) {
                s[pos++] = ' ';  // 
            }
            while (idx < s.size() && s[idx] != ' ') {
                s[pos + (len++)] = s[idx++];  // 
            }
            reverse(s.begin() + pos, s.begin() + pos + len);
            pos += len;
            len = 0;
        }
        
        s = s.substr(0, pos);
        reverse(s.begin(), s.end());
    }
};
# 题目链接

https://leetcode.cn/problems/maximum-length-substring-with-two-occurrences/description/

## 解题思路

不定长滑动窗口

## 复杂度分析

时间复杂度：$O(n+∣Σ∣)$

空间复杂度：$O(∣Σ∣)$，∣Σ∣ 为字符集合的大小

## 代码

```python
class Solution(object):
    def maximumLengthSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        ans = left = 0   # 记录最大长度，left是滑动窗口左边界
        cnt = defaultdict(int)   # 哈希表，记录窗口内每个字符的出现次数
        # i 是右边界，c 是当前字符
        for i, c, in enumerate(s):
            cnt[c] += 1  # 当前字符计数 +1

            while cnt[c] > 2:  # 如果当前字符出现超过 2 次，移动左边界直到符合条件
                cnt[s[left]] -= 1  # 左边界字符计数 -1
                left += 1  # 左边界右移
            
            # 更新最大子串长度
            ans = max(ans, i - left + 1)
            
        return ans
```

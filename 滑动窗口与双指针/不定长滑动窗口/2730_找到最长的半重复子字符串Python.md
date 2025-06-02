# 题目链接

https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/description/

## 复杂度分析

时间复杂度：$O(N)$

空间复杂度：$O(1)$

## 代码

```python
class Solution(object):
    def longestSemiRepetitiveSubstring(self, s):
        ans = 1
        left = 0
        same_cnt = 0
        for right in range(1, len(s)):
            if s[right] == s[right - 1]:
                same_cnt += 1
            if same_cnt > 1:
                left += 1
                while s[left] != s[left - 1]:
                    left += 1
                same_cnt = 1
            ans = max(ans, right - left + 1)
        return ans
```

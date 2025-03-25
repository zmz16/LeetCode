# 题目链接

https://leetcode.cn/problems/maximize-the-confusion-of-an-exam/description/

## 解题思路

最大滑动窗口

## 复杂度分析

时间复杂度：$O(n)$

空间复杂度：$O(1)$

## 代码

```python
from collections import defaultdict


class Solution(object):
    def maxConsecutiveAnswers(self, answerKey, k):
        """
        :type answerKey: str
        :type k: int
        :rtype: int
        """
        ans = 0
        left = 0
        cnt = defaultdict(int)

        for right, c in enumerate(answerKey):
            cnt[c] += 1
            # 如果当前窗口中 'T' 的数量和 'F' 的数量都超过 k，就需要收缩窗口。
            while cnt['T'] > k and cnt['F'] > k:
                cnt[answerKey[left]] -= 1
                left += 1
            ans = max(ans, right - left + 1)

        return ans
```

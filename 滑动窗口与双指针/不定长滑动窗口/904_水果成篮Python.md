# 题目链接

https://leetcode.cn/problems/fruit-into-baskets/description/

## 解题思路

滑动窗口+哈希表

## 复杂度分析

时间复杂度：$O(N)$

空间复杂度：$O(1)$，在任意时刻，哈希表中至多有 3 个键值对（3 种不同元素）

## 代码

```python
from collections import defaultdict


class Solution(object):
    def totalFruit(self, fruits):
        """
        :type fruits: List[int]
        :rtype: int
        """
        ans = left = 0
        cnt = defaultdict(int)
        for right, c in enumerate(fruits):
            cnt[c] += 1  # 进入窗口
            while len(cnt) > 2:  # 不满足要求
                out = fruits[left]
                cnt[out] -= 1   # 左边界元素离开窗口
                if cnt[out] == 0:
                    del cnt[out]
                left += 1
            ans = max(ans, right - left + 1)
        return ans
```

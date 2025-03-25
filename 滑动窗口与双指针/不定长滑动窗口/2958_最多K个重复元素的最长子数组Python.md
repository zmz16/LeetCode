# 题目链接

https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/submissions/615304211/

## 解题思路

不定长滑动窗口+哈希表（defaultdict）

## 复杂度分析

时间复杂度：$O(N)$

空间复杂度：$O(N)$

## 代码

```python
from collections import defaultdict


class Solution(object):
    def maxSubarrayLength(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        ans = 0
        left = 0
        cnt = defaultdict(int)

        for right, c in enumerate(nums):
            cnt[c] += 1
            while cnt[c] > k:
                out = nums[left]  # 获取左边界元素
                cnt[out] -= 1    # 左边界元素次数减一
                if cnt[out] == 0:  # 如果计数归零，删除键
                    del cnt[nums[left]]
                left += 1
            ans = max(ans, right - left + 1)

        return ans

```

# 题目链接

https://leetcode.cn/problems/maximum-erasure-value/description/

## 解题思路

不定长滑动窗口+哈希表

## 复杂度分析

时间复杂度：$O(n)$

空间复杂度：$O(n)$

## 代码

```python
from collections import defaultdict


class Solution(object):
    def maximumUniqueSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = left = sum_ = 0
        cnt = defaultdict(int)
        for right, c in enumerate(nums):
            cnt[c] += 1
            sum_ += c
            
            while cnt[c] > 1:
                cnt[nums[left]] -= 1
                sum_ -= nums[left]
                if cnt[nums[left]] == 0:
                    del cnt[nums[left]]
                left += 1
            ans = max(ans, sum_)
            
        return ans

```

# 题目链接

https://leetcode.cn/problems/max-consecutive-ones-iii/description/

## 解题思路

滑动窗口

## 复杂度分析

时间复杂度：$O(n)$

空间复杂度：$O(1)$

## 代码

```python
class Solution(object):
    def longestOnes(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        ans = 0
        left = 0
        cnt0 = 0  # 统计0的个数

        for right, c in enumerate(nums):
            cnt0 += 1 - c
            while cnt0 > k:
                cnt0 -= 1 - nums[left]
                left += 1
            ans = max(ans, right - left + 1)

        return ans

```

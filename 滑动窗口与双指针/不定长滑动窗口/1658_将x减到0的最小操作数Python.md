# 题目链接

https://leetcode.cn/problems/minimum-operations-to-reduce-x-to-zero/solutions/2048811/ni-xiang-si-wei-pythonjavacgo-by-endless-b4jt/

## 解题思路

逆向思维+滑动窗口

## 复杂度分析

时间复杂度：$O(n)$

空间复杂度：$O(1)$

## 代码

```python
class Solution(object):
    def minOperations(self, nums, x):
        """
        :type nums: List[int]
        :type x: int
        :rtype: int
        """
        target = sum(nums) - x
        if target < 0:
            return -1   # 全部移除也无法满足要求

        ans = -1
        s = left = 0
        for right, x in enumerate(nums):
            s += x
            while s > target:
                s -= nums[left]
                left += 1
            if s == target:
                ans = max(ans, right - left + 1)

        return -1 if ans < 0 else len(nums) - ans

```

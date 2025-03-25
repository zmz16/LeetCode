# 题目链接

https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/description/

## 解题思路

不定长滑动窗口

## 复杂度分析

时间复杂度：$O(n)$

空间复杂度：$O(1)$

## 代码

```python
class Solution(object):
    def longestSubarray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        ans = left = 0
        cnt = 0
        for i, c in enumerate(nums):
            if c == 0:
                cnt += 1
            while cnt > 1:
                if nums[left] == 0:
                    cnt -= 1
                left += 1
            ans = max(ans, i - left + 1)
        # 题目要求删除一个 0 后全为 1 的最长子数组，所以最终返回 ans - 1
        return ans - 1
```

# 题目链接

https://leetcode.cn/problems/maximum-beauty-of-an-array-after-applying-operation/

## 解题思路

排序+滑动窗口

### 原问题等价于：

排序后，找最长的连续子数组，其最大值减最小值 ``≤2k``。由于数组是有序的，相当于子数组的最后一个数减去子数组的第一个数 ``≤2k``。

这可以用 滑动窗口 解决。枚举 nums[right] 作为子数组的最后一个数，一旦 nums[right]−nums[left]>2k，就移动左端点 left。

左端点停止移动时，下标在 [left,right] 的子数组就是满足要求的子数组，用子数组长度 right−left+1 更新答案的最大值。

作者：灵茶山艾府
链接：https://leetcode.cn/problems/maximum-beauty-of-an-array-after-applying-operation/solutions/2345805/pai-xu-shuang-zhi-zhen-by-endlesscheng-hbqx/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

## 复杂度分析

时间复杂度：$O(N \log n)$

空间复杂度：$O(1)$

## 代码

```python
class Solution(object):
    def maximumBeauty(self, nums, k):
        ans = 0
        left = 0
        nums.sort()
        for right in range(len(nums)):
            while nums[right] - nums[left] > 2 * k:
                left += 1
            ans = max(ans, right - left + 1)
        return ans
```

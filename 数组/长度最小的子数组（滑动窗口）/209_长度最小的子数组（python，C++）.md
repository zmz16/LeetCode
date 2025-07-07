# 题目链接

https://leetcode.cn/problems/minimum-size-subarray-sum/description/

## python

```python
class Solution:
    def minSubArrayLen(self, target: int, nums: List[int]) -> int:
        ans = inf
        s = 0
        left = 0
        for right, x in enumerate(nums):
            s += x
            while s >= target:
                ans = min(ans, right - left + 1)
                s -= nums[left]
                left += 1
        return ans if ans <= len(nums) else 0
        
```

## C++

```c++
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int l = 0;
        int ans = INT_MAX;
        int sum = 0;
        for (int r = 0; r < nums.size(); r++) {
            sum += nums[r];
            while (sum >= target) {
                ans = min(ans, r - l + 1);
                sum -= nums[l];
                l++;
            }
        }
        return ans == INT_MAX ? 0 : ans;
    }
};
```

- 时间复杂度：O(n)
- 空间复杂度：O(1)

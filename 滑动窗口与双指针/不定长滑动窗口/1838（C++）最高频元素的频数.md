# 题目链接

https://leetcode.cn/problems/frequency-of-the-most-frequent-element/solutions/883538/1838-zui-gao-pin-yuan-su-de-pin-shu-shua-ub57/

## 复杂度分析

时间复杂度：$O(n \log n)$

空间复杂度：$O(\log n)$

## 代码

```c++
class Solution {
public:
    int maxFrequency(vector<int>& nums, int k) {
        sort(nums.begin(), nums.end());
        int n = nums.size();
        int l = 0, ans = 1;
        long long sum = 0;
        for (int r = 1; r < n; r++) {
            sum += (nums[r] - nums[r - 1]) * (l - r);
            while (sum > k) {
                sum -= nums[r] - nums[l];
                l++;
            }
            ans = max(ans, r - l + 1);
        }
        return ans;
    }
};
```
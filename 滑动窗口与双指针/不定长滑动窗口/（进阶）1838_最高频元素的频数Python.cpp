#include <vector>
#include <algorithm>

using namespace std; // 使用std命名空间，或者使用std::前缀

// 时间复杂度：O(nlogn)
// 空间复杂度：O(logn)

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
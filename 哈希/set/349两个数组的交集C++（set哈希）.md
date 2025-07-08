## 题目链接

https://leetcode.cn/problems/intersection-of-two-arrays/description/

## C++

```C++
class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> num_set(nums1.begin(), nums1.end());
        vector<int> ans;

        for (int x : nums2) {
            if (num_set.erase(x)) {  // 如果存在则删除
                ans.push_back(x);   // 末尾添加新元素
            }
        }
        return ans;
    }
};
```
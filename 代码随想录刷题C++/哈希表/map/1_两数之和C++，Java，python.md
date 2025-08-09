# 题目链接

https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked

## C++

```c++
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int, int> res;

        for (int i = 0; i < nums.size(); i++) {
            auto item = res.find(target - nums[i]);
            if (item != res.end()) {
                return {item->second, i};
            }
            res[nums[i]] = i;
        }
        return {};
    }
};
```

## Java

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int another = target - nums[i];
			if (map.containsKey(another)) {
                return new int[] { map.get(another), i };
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}
```

## Python

```python
class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        idx = {}
        for j, x in enumerate(nums):
            if target - x in idx:
                return [idx[target - x], j]
            idx[x] = j
```
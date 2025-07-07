# 题目链接

https://leetcode.cn/problems/move-zeroes/description/?envType=study-plan-v2&envId=top-100-liked

## 代码

### Java

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
        	if (nums[right] != 0) {
        		swap(nums, left, right);
        		left++;
        	}
        	right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
    	int temp = nums[left];
    	nums[left] = nums[right];
    	nums[right] = temp;
	}
}
```

### Python

#### 原地栈

```python
class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        stack_size = 0
        for i, x in enumerate(nums):
            if x != 0:
                nums[stack_size] = x
                stack_size += 1
        for i in range(stack_size, len(nums)):
            nums[i] = 0
```

#### 双指针

```python
class Solution(object):
    def moveZeroes(self, nums):
        i0 = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                # 交换当前元素和i0位置的元素
                nums[i], nums[i0] = nums[i0], nums[i]
                i0 += 1  # 移动零指针到下一个位置
```
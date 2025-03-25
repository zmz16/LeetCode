# 题目链接

https://leetcode.cn/problems/get-equal-substrings-within-budget/description/

## 复杂度分析

时间复杂度：$O(N)$

空间复杂度：$O(N)$

## 代码

```python
class Solution(object):
    def equalSubstring(self, s, t, maxCost):
        """
        :type s: str
        :type t: str
        :type maxCost: int
        :rtype: int
        """
        n = len(s)
        diff = [abs(ord(sc) - ord(tc)) for sc, tc in zip(s, t)]
        # zip：按对应位置生成由元组组成的迭代器
        # ord：返回字符的ASCII码值
        maxLength = start = end = 0
        tol = 0   # 窗口内的开销和

        while end < n:
            tol += diff[end]  # 计算窗口内的开销和
            while tol > maxCost:  # 判断是否大于最大允许开销
                tol -= diff[start]  # 离开窗口
                start += 1  # 窗口左侧边界右移，直到小于等于最大允许开销
            # 更新最大窗口值
            maxLength = max(maxLength, end - start + 1)
            end += 1  # 右边界扩大窗口

        return maxLength

```

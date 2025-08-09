# 题目链接

https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked

## 解题思路

**滑动窗口**

## Python

### 方法一

```python
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        # 初始化结果指针，默认值为无效值（ans_left = -1表示尚未找到有效窗口）
        ans_left, ans_right = -1, len(s)
        cnt_s = Counter()  # s 子串字母的出现次数
        cnt_t = Counter(t)  # t 中字母的出现次数
        left = 0

        for right, c in enumerate(s):
            cnt_s[c] += 1
            # 当当前窗口包含t的所有字符时（cnt_s >= cnt_t）
            while cnt_s >= cnt_t:  # 涵盖
                # 如果当前窗口比之前找到的更小，则更新结果
                if right - left < ans_right - ans_left:
                    ans_left, ans_right = left, right
                # 尝试缩小窗口：左边界右移
                cnt_s[s[left]] -= 1
                left += 1
        # 返回结果（如果找到有效窗口则返回子串，否则返回空字符串）
        return "" if ans_left < 0 else s[ans_left: ans_right + 1]
```

### 优化

```python
class Solution:
    def minWindow(self, s: str, t: str) -> str:
        ans_left, ans_right = -1, len(s)
        cnt = defaultdict(int)  # 比Counter更快
        for c in t:
            cnt[c] += 1
        less = len(cnt)  # 有 less 种字母的出现次数 < t 中的字母出现次数

        left = 0
        for right, c in enumerate(s):
            cnt[c] -= 1
            if cnt[c] == 0:
                less -= 1
            while less == 0:
                if right - left < ans_right - ans_left:
                    ans_left, ans_right = left, right
                x = s[left]
                if cnt[x] == 0:
                    less += 1
                cnt[x] += 1
                left += 1
        return "" if ans_left < 0 else s[ans_left: ans_right + 1]
```

## C++

### 方法一

```C++
class Solution {
    bool is_covered(int cnt_s[], int cnt_t[]) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cnt_s[i] < cnt_t[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cnt_s[i] < cnt_t[i]) {
                return false;
            }
        }
        return true;
    }
public:
    string minWindow(string s, string t) {
        int cnt_s[128]{};
        int cnt_t[128]{};
        for (char c : t) {
            cnt_t[c]++;
        }

        int m = s.size();
        int ans_left = -1, ans_right = m;
        int left = 0;
        for (int right = 0; right < m; right++) {
            cnt_s[s[right]]++;
            while (is_covered(cnt_s, cnt_t)) {
                if (right - left < ans_right - ans_left) {
                    ans_left = left;
                    ans_right = right;
                }
                cnt_s[s[left]]--;
                left++;
            }
        }
        return ans_left < 0 ? "" : s.substr(ans_left, ans_right - ans_left + 1);
    }
};
```

### 优化

```C++
class Solution {
public:
    string minWindow(string s, string t) {
        int cnt[128]{};
        int less = 0;
        for (char c : t) {
            if (cnt[c] == 0) {
                less++;
            }
            cnt[c]++;
        }

        int m = s.size();
        int ans_left = -1, ans_right = m;
        int left = 0;
        for (int right = 0; right < m; right++) {
            char c = s[right];
            cnt[c]--;
            if (cnt[c] == 0) {
                less--;
            }
            while (less == 0) {
                if (right - left < ans_right - ans_left) {
                    ans_left = left;
                    ans_right = right;
                }
                char x = s[left];
                if (cnt[x] == 0) {
                    less++;
                }
                cnt[x]++;
                left++;
            }
        }
        return ans_left < 0 ? "" : s.substr(ans_left, ans_right - ans_left + 1);
    }
};
```
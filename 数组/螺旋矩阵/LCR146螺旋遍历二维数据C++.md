## 题目链接

https://leetcode.cn/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/

## C++

```C++
class Solution {
    static constexpr int DIRS[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 右下左上
public:
    vector<int> spiralArray(vector<vector<int>>& matrix) {
        if (matrix.empty()) {
            return {};
        }
       int m = matrix.size(), n = matrix[0].size();
        vector<int> ans(m * n);
        int i = 0, j = 0, di = 0;
        for (int k = 0; k < m * n; k++) {
            ans[k] = matrix[i][j];
            matrix[i][j] = INT_MAX;  // 标记，表示已经访问过
            int x = i + DIRS[di][0];
            int y = j + DIRS[di][1];  // 下一步的位置
            // 如果 (x, y) 出界或者已经访问过
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] == INT_MAX) {
                di = (di + 1) % 4;
            }
            i += DIRS[di][0];
            j += DIRS[di][1];
        }
        return ans; 
    }
};
```

- 时间复杂度：O(mn)
- 空间复杂度：O(1)
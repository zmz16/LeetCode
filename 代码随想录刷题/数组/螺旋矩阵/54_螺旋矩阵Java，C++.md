# 题目链接：

https://leetcode.cn/problems/spiral-matrix/description/

时间复杂度：O(mn)

空间复杂度：O(mn)

## Java

```java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length ==0) {
        	return order;
        }
        
        int rows = matrix.length, cols = matrix[0].length;
        boolean[][] visit = new boolean[rows][cols];
        int total = rows * cols;
        int row = 0, col = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        
        for (int i = 0; i < total; i++) {
        	order.add(matrix[row][col]);
        	visit[row][col] = true;
        	int nextRow = row + directions[directionIndex][0];
        	int nextCol = col + directions[directionIndex][1];
        	if (nextRow < 0 || nextRow >= rows || nextCol < 0 || nextCol >= cols || visit[nextRow][nextCol]) {
        		directionIndex = (directionIndex + 1) % 4;
        	}
        	
        	row += directions[directionIndex][0];
        	col += directions[directionIndex][1];
        }
        
        return order;
    }
}
```

## C++

```C++
class Solution {
    static constexpr int DIRS[4][2] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};  // 右下左上
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
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
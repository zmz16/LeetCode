# 题目链接

https://kamacoder.com/problempage.php?pid=1053

## C++

```cpp
#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int main() {
	int v, e;   // 顶点数和边数
	cin >> v >> e;

	int v1, v2, val;
	vector<vector<int>> grid(v + 1, vector<int>(v + 1, 10001));
	for (int i = 0; i < e; i++) {   // 无向图
		cin >> v1 >> v2 >> val;
		grid[v1][v2] = val;
		grid[v2][v1] = val;
	}

	// 所有节点到最小生成树的最小距离
	vector<int> minDist(v + 1, 10001);
	// 节点是否在最小生成树里
	vector<bool> isInTree(v + 1, false);

	// 我们只需要循环 n-1次，建立 n - 1条边，就可以把n个节点的图连在一起
	for (int i = 1; i < v; i++) {
		// 1. 选距离生成树最近节点
		int cur = -1;   // 选中哪个节点加入最小生成树
		int minVal = INT_MAX;
		for (int j = 1; j <= v; j++) {   // 顶点编号，下标从1开始
			if (!isInTree[j] && minDist[j] < minVal) {
				minVal = minDist[j];
				cur = j;
			}
		}

		// 2. 最近节点加入生成树
		isInTree[cur] = true;   // 当前节点加入最小生成树

		// 更新非生成树节点到生成树的距离
		for (int j = 1; j <= v; j++) {
			if (!isInTree[j] && grid[cur][j] < minDist[j]) {
				minDist[j] = grid[cur][j];
			}
		}
	}

	// 统计结果
	int result = 0;
	for (int i = 2; i <= v; i++) {
		result += minDist[i];
	}
	cout << result << endl;
	return 0;
}
```
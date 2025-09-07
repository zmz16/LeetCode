# 题目链接

https://kamacoder.com/problempage.php?pid=1053

## C++

```cpp
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

struct Edge {
	int l;
	int r;
	int val;
};

int n = 10001;   // 节点数量
vector<int> father(n, -1);   // 按照节点大小定义数组大小

// 并查集初始化
void init() {
	for (int i = 1; i <= n; i++) {
		father[i] = i;
	}
}

// 并查集里寻根的过程
int find(int u) {
	return u == father[u] ? u : father[u] = find(father[u]);
}

// 判断u和v是否找到同一个根
bool isSame(int u, int v) {
	u = find(u);
	v = find(v);
	return u == v;
}

// 将 v->u 这条边加入并查集
void join(int u, int v) {
	u = find(u);
	v = find(v);
	if (u == v) return;
	father[v] = u;
}

int main() {
	int v, e;   // 顶点数和边数
	cin >> v >> e;

	int v1, v2, val;
	vector<Edge> edges;   // 存边

	for (int i = 0; i < e; i++) {   // 无向图
		cin >> v1 >> v2 >> val;
		edges.push_back({ v1, v2, val });
	}
	
	sort(edges.begin(), edges.end(), [](const Edge& a, const Edge& b) {
		return a.val < b.val;
		});

	init();

	int result = 0;

	for (Edge edge : edges) {
		int x = find(edge.l);
		int y = find(edge.r);

		if (x != y) {
			result += edge.val;
			join(x, y);   // 两个节点加入到同一个集合
		}
	}

	cout << result << endl;
	return 0;
}
```
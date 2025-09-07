# 题目链接

https://kamacoder.com/problempage.php?pid=1047

## C++

```cpp
#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int main() {
    int n, m;
    cin >> n >> m;

    int s, t, val;
    vector<vector<int>> graph(n + 1, vector<int>(n + 1, INT_MAX));
    for (int i = 0; i < m; i++) {
        cin >> s >> t >> val;
        graph[s][t] = val;
    }

    vector<int> minDist(n + 1, INT_MAX);
    vector<bool> visited(n + 1, false);
    minDist[1] = 0;   // 起始点到自身的距离为0

    for (int i = 1; i <= n; i++) {   // 遍历所有节点
        int minVal = INT_MAX;
        int cur = 1;

        // 1、选距离源点最近且未访问过的节点
        for (int j = 1; j <= n; j++) {
            if (!visited[j] && minDist[j] < minVal) {
                minVal = minDist[j];
                cur = j;
            }
        }

        // 2、标记该节点已被访问
        visited[cur] = true;

        // 3、第三步，更新非访问节点到源点的距离（即更新minDist数组）
        for (int j = 1; j <= n; j++) {
            if (!visited[j] && graph[cur][j] != INT_MAX && minDist[cur] + graph[cur][j] < minDist[j]) {
                minDist[j] = minDist[cur] + graph[cur][j];
            }
        }
    }

    if (minDist[n] == INT_MAX) {
        cout << -1 << endl;
    }
    else {
        cout << minDist[n] << endl;
    }
    return 0;
}
```
# 题目链接

https://kamacoder.com/problempage.php?pid=1047

## C++

```cpp
#include <iostream>
#include <vector>
#include <climits>
#include <list>
#include <queue>

using namespace std;

// 小顶堆
class mycomparison {
public:
    bool operator()(const pair<int, int>& lhs, const pair<int, int>& rhs) {
        return lhs.second > rhs.second;
    }
};

// 定义一个结构体来表示带权重的边
struct Edge{
    int to;   // 临接顶点
    int val;   // 权值

    Edge(int t, int v): to(t), val(v) {}   // 构造函数
};
 
int main() {
    int n, m;
    cin >> n >> m;

    int s, t, val;
    vector<list<Edge>> graph(n + 1);
    for (int i = 0; i < m; i++) {
        cin >> s >> t >> val;
        graph[s].push_back(Edge(t, val));
    }

    vector<int> minDist(n + 1, INT_MAX);
    vector<bool> visited(n + 1, false);

    // 优先队列中存放 pair<节点，源点到该节点的权值>
    priority_queue<pair<int, int>, vector<pair<int, int>>, mycomparison> pq;
    // 初始化队列，源点到源点的距离为0，所以初始为0
    pq.push(pair<int, int>(1, 0));

    minDist[1] = 0;   // 起始点到自身的距离为0

    while (!pq.empty()) {   // 遍历所有节点
        // 1. 第一步，选源点到哪个节点近且该节点未被访问过 （通过优先级队列来实现）
        // <节点， 源点到该节点的距离>
        pair<int, int> cur = pq.top();
        pq.pop();

        if (visited[cur.first]) {
            continue;
        }

        // 2、标记该节点已被访问
        visited[cur.first] = true;

        // 3、第三步，更新非访问节点到源点的距离（即更新minDist数组）
        for (Edge edge : graph[cur.first]) {
            if (!visited[edge.to] && minDist[cur.first] + edge.val < minDist[edge.to]) {
                minDist[edge.to] = minDist[cur.first] + edge.val;
                pq.push(pair<int, int>(edge.to, minDist[edge.to]));
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
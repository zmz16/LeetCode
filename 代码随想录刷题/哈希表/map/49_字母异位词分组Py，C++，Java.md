# 题目链接

https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-100-liked

## Java

```Java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
    	// 创建一个哈希表，键是排序后的字符串，值是对应的字母异位词列表
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        // 遍历字符串数组
        for (String str : strs) {
        	// 将字符串转换为字符数组
        	char[] array = str.toCharArray();
        	// 对字符数组进行排序
        	Arrays.sort(array);
        	// 将排序后得字符数组转换为字符串，作为哈希表得键
        	String key = new String(array);
        	// 获取键对应得字母异位列表，如果不存在则创建一个新列表
        	List<String> list = map.getOrDefault(key, new ArrayList<String>());
        	// 将当前字符串添加到列表中
        	list.add(str);
        	// 更新哈希表
        	map.put(key, list);
        }
        // 将哈希表中的所有值（字母异位词列表）转换为一个列表并返回
        return new ArrayList<List<String>>(map.values());
    }
}
```

## Python

```python
class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        d = defaultdict(list)
        for s in strs:
            d[''.join(sorted(s))].append(s)
        return list(d.values())
        
```

## C++

```C++
class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> m;
        for (string & s : strs) {
            string sorted_s = s;
            ranges::sort(sorted_s);
            m[sorted_s].push_back(s);
        }

        vector<vector<string>> ans;
        ans.reserve(m.size());
        for (auto & [_, value] : m) {
            ans.push_back(value);
        }
        return ans;
    }
};
```

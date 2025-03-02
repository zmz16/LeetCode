class Solution {
    public int numIdenticalPairs(int[] nums) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}

class Solution {
    public int numIdenticalPairs(int[] nums) {
        int ans = 0;  // 存储“好对”的数量
        Map<Integer, Integer> cnt = new HashMap<>(); // 使用哈希表记录每个数字出现的次数
        for (int x : nums) {
        	int c =cnt.getOrDefault(x, 0); // 获取 x 已经出现的次数，如果不存在（第一次出现）返回0
        	ans += c;  //累加结果
        	cnt.put(x, c + 1);  // 更新x的出现次数
        }
        return ans;
    }
}
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int temp = 0;
        for (int num : nums) {
            // 如果 x == 0，说明当前连续 1 的序列中断，将 cur 重置为 0。如果 x == 1，说明当前连续 1 的序列仍在继续，将 cur 加 1。
            temp = (num == 0 ? 0 : temp + 1);  
            // 每次更新 cur 后，用 Math.max(max, cur) 更新 max，确保 max 始终记录最大值。
            max = Math.max(max, temp);  
        }
        return max;
    }
}
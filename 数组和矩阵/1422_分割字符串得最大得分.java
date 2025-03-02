class Solution {
    public int maxScore(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 1; i < n; i++) {  // 所有可能的分割点
            int score = 0;
            for (int j = 0; j < i; j++) {  // 左子字符串
                if (s.charAt(j) == '0') {
                    score++;
                }
            }
            for (int j = i; j < n; j++) {  // 右子字符串
                if (s.charAt(j) == '1'){
                    score++;
                } 
            }
            ans = Math.max(ans, score);  //判断最大值
        }
        return ans;
    }
}
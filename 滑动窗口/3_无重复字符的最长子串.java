class Solution {
    public int lengthOfLongestSubstring(String s) {
    	char[] ss = s.toCharArray();
    	HashSet<Character> set = new HashSet<Character>();
    	int ans = 0;
    	for (int left = 0, right = 0; right < s.length(); right++) {
    		char ch = ss[right];
    		while (set.contains(ch)) {
    			set.remove(ss[left]);
    			left++;
    		}
    		set.add(ss[right]);
    		ans = Math.max(ans, right - left + 1);
    	}
    	return ans;
    }
}
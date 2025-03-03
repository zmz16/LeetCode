class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int m = p.length(), n = s.length();
        
        if (n < m) {
        	return new ArrayList<Integer>();
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < m; i++) {
        	sCount[s.charAt(i) - 'a']++;
        	pCount[p.charAt(i) - 'a']++;
        }
        
        if (Arrays.equals(sCount, pCount)) {
        	ans.add(0);
        }
        
        for (int i = 0 ; i < n - m; i++) {
        	sCount[s.charAt(i) - 'a']--;
        	sCount[s.charAt(i + m) - 'a']++;
        	
        	if (Arrays.equals(sCount, pCount)) {
        		ans.add(i + 1);
        	}
        }
        return ans;
    }
}
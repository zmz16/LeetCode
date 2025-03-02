class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int cnt = 0;
        HashSet<Character> vowels = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        for (int i = left; i <= right; i++) { 
            String word = words[i];
            int n = word.length();
            if (vowels.contains(word.charAt(0)) && vowels.contains(word.charAt(n-1))) {
                cnt++;
            }
        }
        return cnt;
    }
}
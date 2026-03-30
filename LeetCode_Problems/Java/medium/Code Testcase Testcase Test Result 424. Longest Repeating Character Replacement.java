class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        int[] counts = new int[26];

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);
            counts[c - 'A']++;

            maxFreq = Math.max(maxFreq, counts[c - 'A']);

            while ((right - left + 1) - maxFreq > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}

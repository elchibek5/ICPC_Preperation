class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = s.length() - 1;
        
        while (l < r) {
            while (l < r && !isVowel(chars[l])) {
                l++;
            }

            while (l < r && !isVowel(chars[r])) {
                r--;
            }

            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;

            l++;
            r--;
        }
        
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}

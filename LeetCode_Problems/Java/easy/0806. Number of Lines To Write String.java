class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        // "abcdefghijklmnopqrstuvwxyz"
        // abcdefghij  // 100 pixels wide
        // klmnopqrst  // 100 pixels wide
        // uvwxyz      // 60 pixels wide
        int line = 1;
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int wordWidth = widths[c - 'a'];
            
            if (total + wordWidth <= 100) {
                total += wordWidth;
            } else {
                total = wordWidth;
                line++;
            }
        }

        return new int[]{line, total};
    }
}

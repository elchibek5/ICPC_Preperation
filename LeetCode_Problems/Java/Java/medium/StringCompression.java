class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int write = 0;
        int read = 0;

        while (read < n) {
            char current = chars[read];
            int count = 0;

            while (read < n && chars[read] == current) {
                read++;
                count++;
            }

            chars[write++] = current;

            if (count > 1) {
                String s = Integer.toString(count);
                for (char digit : s.toCharArray()) {
                    chars[write++] = digit;
                }
            }
        }
        return write;
    }
}

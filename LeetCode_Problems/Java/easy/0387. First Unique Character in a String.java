class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> characters = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (characters.containsKey(c)) {
                characters.put(c, characters.get(c) + 1);
            } else { 
                characters.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (characters.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}

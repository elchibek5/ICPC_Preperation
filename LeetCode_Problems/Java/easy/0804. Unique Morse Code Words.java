class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] dict = {
            ".-","-...","-.-.","-..",".","..-.","--.","....","..",
            ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-","-.--","--.."
        };

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder combined = new StringBuilder();

            for (char c : word.toCharArray()) {
                int r = c - 'a';

                combined.append(dict[r]);
            }

            set.add(combined.toString());
        }
        return set.size();
    }
}

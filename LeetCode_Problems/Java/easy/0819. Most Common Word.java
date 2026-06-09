class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[^a-z]+");
        Set<String> bannedWords = new HashSet<>(Arrays.asList(banned));
        HashMap<String, Integer> freq = new HashMap<>();

        String ans = "";
        int max = 0;

        for (String word : words) {
            if (!bannedWords.contains(word) && !word.isEmpty()) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);

                if (freq.get(word) > max) {
                    max = freq.get(word);
                    ans = word;
                }
            }
        }

        return ans;
    }
}

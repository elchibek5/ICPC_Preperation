class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        StringBuilder combined = new StringBuilder();

        for (String chunk : chunks) {
            combined.append(chunk);
        }

        String text = combined.toString();
        String[] rawWords = text.split("[\\s]+");
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : rawWords) {
            word = word.replaceAll("^-+", "");
            word = word.replaceAll("-+$", "");

            String[] splitWords = word.split("-{2,}");
            for (String processedWord : splitWords) {
                if (processedWord.length() == 0) continue;

                map.put(processedWord, map.getOrDefault(processedWord, 0) + 1);
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            answer[i] = map.getOrDefault(queries[i], 0);
        }

        return answer;
    }
}

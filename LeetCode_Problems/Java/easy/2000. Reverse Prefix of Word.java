class Solution {
    public String reversePrefix(String word, char ch) {
        int count = 0;

        int idx = word.indexOf(ch);

        if (idx == -1) {
            return word;
        }

        StringBuilder answer = new StringBuilder();
        String prefix = word.substring(0, idx + 1);
        answer.append(prefix).reverse();
        answer.append(word.substring(idx + 1));

        return answer.toString();

    }
}

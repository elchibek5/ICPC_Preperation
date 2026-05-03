class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        HashMap<Character, Integer> construct = new HashMap<>();

        for (char c : magazine.toCharArray()) {
            construct.put(c, construct.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!construct.containsKey(c) || construct.get(c) == 0) {
                return false;
            }
            construct.put(c, construct.get(c) - 1);
        }
        return true;
    }
}

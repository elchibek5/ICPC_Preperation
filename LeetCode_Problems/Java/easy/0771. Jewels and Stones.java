class Solution {
    public int numJewelsInStones(String jewels, String stones) {

        HashMap<Character, Integer> letters = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < stones.length(); i++) {
            char c = stones.charAt(i);

            letters.put(c, letters.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < jewels.length(); i++) {
            char c = jewels.charAt(i);

            ans += letters.getOrDefault(c, 0);
        }

        return ans;
    }
}

class Solution {
    public int mostFrequentEven(int[] nums) {
        Map <Integer, Integer> freq = new HashMap<>();

        for (int n : nums) {
            if (n % 2 == 0) freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        
        int ans = -1;
        int maxFreq = 0;

        for (int n : freq.keySet()) {
            int count = freq.get(n);

            if (count > maxFreq || (count == maxFreq && n < ans)) {
                ans = n;
                maxFreq = count;
            }
        }
        return ans;
    }
}

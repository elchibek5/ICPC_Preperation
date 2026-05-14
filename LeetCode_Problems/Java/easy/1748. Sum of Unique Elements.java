class Solution {
    public int sumOfUnique(int[] nums) {
        int sum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (int key : map.keySet()) {
            if (map.get(key) == 1) {
                sum += key;
            }
        }

        return sum;
    }
}

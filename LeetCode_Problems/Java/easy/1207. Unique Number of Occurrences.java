class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Set<Integer> check = new HashSet<>();

        for (int count : map.values()) {
            check.add(count);
        }

        return check.size() == map.size();
    }
}

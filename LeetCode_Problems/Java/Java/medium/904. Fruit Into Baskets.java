class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, i;
        int maxFruits = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);

            if (map.size() > 2) {
                int fruitAtLeft = fruits[left];
                // reduce the count by 1
                map.put(fruitAtLeft, map.get(fruitAtLeft) - 1);

                if (map.get(fruitAtLeft) == 0) {
                    map.remove(fruitAtLeft);
                }

                left++;
            }
        }

        return i - left;
    }
}

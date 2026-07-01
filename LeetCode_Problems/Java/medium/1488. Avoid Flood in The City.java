class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];

        Map<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1;
            } else {
                int lake = rains[i];
                ans[i] = -1;

                if (lastRain.containsKey(lake)) {
                    int lastFilledIndex = lastRain.get(lake);

                    Integer idealDryDay = dryDays.higher(lastFilledIndex);

                    if (idealDryDay == null) {
                        return new int[]{};
                    }

                    ans[idealDryDay] = lake;
                    dryDays.remove(idealDryDay);
                }

                lastRain.put(lake, i);
            }
        } 

        return ans;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int c : freq) {
            if (c > 0) maxHeap.offer(c);
        }

        Queue<int[]> cooldown = new LinkedList<>();

        int time = 0;

        while (!maxHeap.isEmpty() || !cooldown.isEmpty()) {
            time++;

            if (!maxHeap.isEmpty()) {
                int left = maxHeap.poll() - 1;
                if (left > 0) {
                    cooldown.offer(new int[]{left, time + n});
                }
            }

            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) {
                maxHeap.offer(cooldown.poll()[0]);
            }
        }

        return time;




        // int maxFreq = 0;
        // for (int f : freq) {
        //     maxFreq = Math.max(maxFreq, f);
        // }

        // int countOfMax = 0;
        // for (int f : freq) {
        //     if (f == maxFreq) {
        //        countOfMax++; 
        //     }
        // }
        // // The key is here
        // int ans = (maxFreq - 1) * (n + 1) + countOfMax;

        // return Math.max(ans, tasks.length);
        
    }
}

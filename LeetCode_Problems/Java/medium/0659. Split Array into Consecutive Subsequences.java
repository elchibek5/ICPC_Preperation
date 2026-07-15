class Solution {
    public boolean isPossible(int[] nums) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]); 
            }
            return Integer.compare(a[1], b[1]);  
        });

        for (int num : nums) {

            while (!heap.isEmpty() && heap.peek()[0] + 1 < num) {
                int[] deadChain = heap.poll();
                if (deadChain[1] < 3) {
                    return false; 
                }
            }

            if (!heap.isEmpty() && heap.peek()[0] + 1 == num) {
                int[] sub = heap.poll();
                sub[0] = num; 
                sub[1]++;    
                heap.offer(sub);
            } else {
                heap.offer(new int[]{num, 1});
            }
        }

        while (!heap.isEmpty()) {
            if (heap.poll()[1] < 3) {
                return false;
            }
        }

        return true;
    }
}

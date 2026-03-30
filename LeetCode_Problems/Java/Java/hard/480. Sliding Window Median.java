class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        double[] result = new double[nums.length - k + 1];
        
        int balance = 0; // Relative size: maxHeap.size() - minHeap.size()

        for (int i = 0; i < nums.length; i++) {
            // 1. ADD
            if (maxHeap.isEmpty() || nums[i] <= maxHeap.peek()) {
                maxHeap.offer(nums[i]);
                balance++;
            } else {
                minHeap.offer(nums[i]);
                balance--;
            }

            // 2. REMOVE
            if (i >= k) {
                int outNum = nums[i - k];
                map.put(outNum, map.getOrDefault(outNum, 0) + 1);

                if (outNum <= maxHeap.peek()) {
                    balance--;
                } else {
                    balance++;
                }
            }

            // 3. REBALANCE
            if (balance > 1) { 
                minHeap.offer(maxHeap.poll());
                balance -= 2;
            } else if (balance < 0) { 
                maxHeap.offer(minHeap.poll());
                balance += 2;
            }
            
            // 4. THE FIX: "Eager" Cleaning
            while (!maxHeap.isEmpty() && map.getOrDefault(maxHeap.peek(), 0) > 0) {
                int top = maxHeap.poll();
                map.put(top, map.get(top) - 1);
            }
            while (!minHeap.isEmpty() && map.getOrDefault(minHeap.peek(), 0) > 0) {
                int top = minHeap.poll();
                map.put(top, map.get(top) - 1);
            }

            // 5. RESULT
            if (i >= k - 1) {
                if (k % 2 == 1) {
                    result[i - k + 1] = (double) maxHeap.peek();
                } else {
                    result[i - k + 1] = ((double) maxHeap.peek() + minHeap.peek()) / 2.0;
                }
            }
        }
        return result;
    }
}

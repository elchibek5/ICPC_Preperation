class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
            
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] res = new int[k];
        int idx = k - 1;
        while (!minHeap.isEmpty()) {
            res[idx--] = minHeap.poll().getKey();
        }
        return res;
    }
}

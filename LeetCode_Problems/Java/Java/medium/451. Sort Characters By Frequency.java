class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> queue = new PriorityQueue<>((a, b) -> 
            Integer.compare(map.get(b), map.get(a)));
        
        for (char c : map.keySet()) {
            queue.add(c);
        }
        
        StringBuilder sb = new StringBuilder();

        while (queue.size() > 0) {
            char c = queue.poll();
            int count = map.get(c);

            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        } 

        return sb.toString();
    }
}

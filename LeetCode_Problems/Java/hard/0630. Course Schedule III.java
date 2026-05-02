class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> Integer.compare(a[1], b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        int time = 0;
        
        for (int[] course : courses) {
            int duration = course[0];
            int deadline = course[1];

            time += duration;
            pq.offer(duration);

            if (time > deadline) {
                time -= pq.poll();
            }
        }

        return pq.size();
    }
}

class RecentCounter {
    private Deque<Integer> q;

    public RecentCounter() {
        q = new ArrayDeque<>();
    }

    public int ping(int t) {
        q.addLast(t);

        int min = t - 3000;
        while (!q.isEmpty() && q.peekFirst() < min) {
            q.pollFirst();
        }

        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */

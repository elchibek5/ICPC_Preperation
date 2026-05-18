class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;

        Map<Integer, List<Integer>> portals = new HashMap<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = portals.getOrDefault(arr[i], new ArrayList<>());
            list.add(i);
            portals.put(arr[i], list);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n - 1) return steps;

                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }

                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }

                if (portals.containsKey(arr[curr])) {
                    for (int nextIdx : portals.get(arr[curr])) {
                        if (!visited[nextIdx]) {
                            visited[nextIdx] = true;
                            queue.offer(nextIdx);
                        }
                    }

                    portals.remove(arr[curr]);
                }
            }

            steps++;
        }

        return -1;
    }
}

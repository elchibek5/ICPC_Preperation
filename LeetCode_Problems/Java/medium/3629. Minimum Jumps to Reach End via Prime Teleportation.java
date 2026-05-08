class Solution {
    public int minJumps(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return 0;

        Map<Integer, List<Integer>> primeToIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            List<Integer> factors = getPrimeFactors(val);

            for (int p : factors) {
                primeToIndices.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        queue.offer(0);
        visited[0] = true;
        int jumps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int curr = queue.poll();

                if (curr == n - 1) {
                    return jumps;
                }

                if (curr + 1 < n && !visited[curr + 1]) {
                    visited[curr + 1] = true;
                    queue.offer(curr + 1);
                }

                if (curr - 1 >= 0 && !visited[curr - 1]) {
                    visited[curr - 1] = true;
                    queue.offer(curr - 1);
                }

                int val = nums[curr];
                if (isPrime(val)) {
                    List<Integer> targets = primeToIndices.get(val);
                    if (targets != null) {
                        for (int targetIdx : targets) {
                            if (!visited[targetIdx]) {
                                visited[targetIdx] = true;
                                queue.offer(targetIdx);
                            }
                        }

                        primeToIndices.remove(val);
                    }
                }
            }
            jumps++;
        }

        return -1;
    }

    private List<Integer> getPrimeFactors(int val) {
        List<Integer> factors = new ArrayList<>();
        int d = 2;
        int temp = val;
        while (d * d <= temp) {
            if (temp % d == 0) {
                factors.add(d);
                while (temp % d == 0) {
                    temp /= d;
                }
            }

            d++;
        }

        if (temp > 1) {
            factors.add(temp);
        }
        return factors;
    }

    private boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

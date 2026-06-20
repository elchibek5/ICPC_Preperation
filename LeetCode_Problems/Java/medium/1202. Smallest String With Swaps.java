class DSU {
    int[] parent;

    public DSU(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            parent[rootI] = rootJ;
        }
    }
}

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        DSU dsu = new DSU(n);

        for (List<Integer> pair : pairs) {
            dsu.union(pair.get(0), pair.get(1));
        }

        Map<Integer, PriorityQueue<Character>> groups = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);

            if (!groups.containsKey(root)) {
                groups.put(root, new PriorityQueue<>());
            }

            groups.get(root).add(s.charAt(i));
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            char smallest = groups.get(root).poll();
            result.append(smallest);
        }

        return result.toString();
    }
}

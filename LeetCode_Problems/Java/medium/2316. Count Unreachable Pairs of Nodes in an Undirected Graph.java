class DSU {
    int[] parent;
    int[] size;

    public DSU(int n) {
        parent = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int i) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            if (size[rootI] >= size[rootJ]) {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            } else {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
        }
    }
}

class Solution {
    public long countPairs(int n, int[][] edges) {
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            int nodeA = edge[0];
            int nodeB = edge[1];
            dsu.union(nodeA, nodeB);
        }

        long unreachablePairs = 0;
        long remainingNodes = n;

        for (int i = 0; i < n; i++) {
            if (dsu.parent[i] == i) {
                long currentIslandSize = dsu.size[i];
                remainingNodes -= currentIslandSize;
                unreachablePairs += (currentIslandSize * remainingNodes);
            }
        }

        return unreachablePairs;
    }
}

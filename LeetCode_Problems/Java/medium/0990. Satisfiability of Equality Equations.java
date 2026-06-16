class DSU {
    int[] parent;

    public DSU() {
        parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
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
            parent[rootI] = rootJ;
        }
    }
}

class Solution {
    public boolean equationsPossible(String[] equations) {
        DSU dsu = new DSU();

        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                dsu.union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int first = dsu.find(eq.charAt(0) - 'a');
                int second = dsu.find(eq.charAt(3) - 'a');
                if (first == second) return false;
            }
        }

        return true;
    }
}

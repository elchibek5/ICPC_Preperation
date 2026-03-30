/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {        
        class NodeWithPosition {
            TreeNode node;
            int row;
            int col;

            public NodeWithPosition(TreeNode node, int row, int col) {
                this.node = node;
                this.row = row;
                this.col = col;
            }
        }
        Queue<NodeWithPosition> queue = new LinkedList<>();
        queue.offer(new NodeWithPosition(root, 0, 0));

        Map<Integer, List<int[]>> colMap = new TreeMap<>();
        while (!queue.isEmpty()) {
            NodeWithPosition current = queue.poll();
            int row = current.row;
            int col = current.col;
            int val = current.node.val;

            colMap.putIfAbsent(col, new ArrayList<>());
            colMap.get(col).add(new int[]{row, val});

            if (current.node.left != null) {
                queue.offer(new NodeWithPosition(current.node.left, row + 1, col - 1));
            }
            if (current.node.right != null) {
                queue.offer(new NodeWithPosition(current.node.right, row + 1, col + 1));
            }
        }
        List<List<Integer>> result = new ArrayList<>();

        for (List<int[]> nodes : colMap.values()) {
            nodes.sort((a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                return Integer.compare(a[1], b[1]);
            });

            List<Integer> col = new ArrayList<>();
            for (int[] pair : nodes) {
                col.add(pair[1]);
            }

            result.add(col);
        }
        return result;
    }
}

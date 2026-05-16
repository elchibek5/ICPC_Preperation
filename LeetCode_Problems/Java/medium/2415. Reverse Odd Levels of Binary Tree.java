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
    public TreeNode reverseOddLevels(TreeNode root) {
        if (root == null)
            return root;

        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.offer(root);
        int level = 0;

        while (!stack.isEmpty()) {
            int size = stack.size();
            List<TreeNode> currentLevelNode = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = stack.poll();
                currentLevelNode.add(node);

                if (node.left != null) stack.offer(node.left);
                if (node.right != null) stack.offer(node.right);

            }

            if (level % 2 != 0) {
                int left = 0;
                int right = currentLevelNode.size() - 1;

                while (left < right) {
                    int temp = currentLevelNode.get(right).val;
                    currentLevelNode.get(right).val = currentLevelNode.get(left).val;
                    currentLevelNode.get(left).val = temp;

                    left++; right--;
                }
            }

            level++;
        }

        return root;
    }
}

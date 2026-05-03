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
    public boolean isBalanced(TreeNode root) {
        boolean[] balanced = new boolean[]{true};
        check(root, balanced);
        return balanced[0];
        }

        private int check(TreeNode node, boolean[] balanced) {
            if (node == null) return 0;

            int left = check(node.left, balanced);
            int right = check(node.right, balanced);

            if (Math.abs(left - right) > 1) {
                balanced[0] = false;
            }
            return 1 + Math.max(left, right);
        }
}

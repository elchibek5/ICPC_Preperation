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
    int globalTotal = 0;

    public int findTilt(TreeNode root) {
        call(root);
        return globalTotal;
    }

    private int call(TreeNode node) {
        if (node == null) return 0;

        int leftSum = call(node.left);
        int rightSum = call(node.right); 

        int currentTilt = Math.abs(leftSum - rightSum);
        globalTotal += currentTilt;

        return leftSum + rightSum + node.val;

    }
}

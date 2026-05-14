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
    List<String> result = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root != null) {
            helper(root, "");
        }
        
        return result;
    }

    private void helper(TreeNode node, String path) {
        if (node == null) return;

        path += node.val;

        if (node.left == null && node.right == null) {
            result.add(path);
            return;
        }

        if (node.left != null) {
            helper(node.left, path + "->");
        }

        if (node.right != null) {
            helper(node.right, path + "->");
        }
    }
}

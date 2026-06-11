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
    public int pathSum(TreeNode root, int targetSum) {

        List<Integer> currentPath = new ArrayList<>();
        return dfs(root, targetSum, currentPath);
    }

    private int dfs(TreeNode node, int targetSum, List<Integer> currentPath) {
        if (node == null) return 0;

        currentPath.add(node.val);

        int pathsFound = 0;
        long currentSum = 0;

        for (int i = currentPath.size() - 1; i >= 0; i--) {
            currentSum += currentPath.get(i);
            if (currentSum == targetSum) {
                pathsFound++;
            }
        }

        pathsFound += dfs(node.left, targetSum, currentPath);
        pathsFound += dfs(node.right, targetSum, currentPath);

        currentPath.remove(currentPath.size() - 1);

        return pathsFound;

    }
}

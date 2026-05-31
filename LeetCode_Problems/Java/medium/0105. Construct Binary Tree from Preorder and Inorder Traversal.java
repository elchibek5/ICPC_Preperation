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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderIndexMap);
    }

        private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, 
                                     int inStart, int inEnd, 
                                     Map<Integer, Integer> inorderIndexMap) {
            if (preStart > preEnd || inStart > inEnd) {
                return null;
            }

            int rootValue = preorder[preStart];
            TreeNode root = new TreeNode(rootValue);

            int rootIndexInorder = inorderIndexMap.get(rootValue);
            int leftSubtreeSize = rootIndexInorder - inStart;

            root.left = buildTreeHelper(preorder, preStart + 1, preStart + leftSubtreeSize,
             inStart, rootIndexInorder - 1, inorderIndexMap);

            root.right = buildTreeHelper(preorder, preStart + leftSubtreeSize + 1, preEnd, 
                                     rootIndexInorder + 1, inEnd, 
                                     inorderIndexMap);

            return root;
        }
    }

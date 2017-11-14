/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    int max;
    public int maxDepth(TreeNode root) {
        // write your code here
        
        if (root == null) {
            return 0;
        }
        // divide conquer
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        
        if (left > right) {
            return left + 1;
        }else {
            return right + 1;
        }
    }
    
    public int maxDepthTraverse(TreeNode root) {
    // traverse
        max = 0;
        helper(root, 1);
        return max;
    }
    
    private void helper(TreeNode node, int current) {
        if (node == null) {
            return;
        }
        
        if (max < current) {
            max = current;
        }
        
        helper(node.left, current + 1);
        helper(node.right, current + 1);
    }
}
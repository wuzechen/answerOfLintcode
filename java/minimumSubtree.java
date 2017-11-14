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
    /*
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    
    private int minSum = Integer.MAX_VALUE;
    private TreeNode minNode = null;
     
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        // check edge
        if (root == null) {
            return null;
        }
        
        helper(root);
        
        return minNode;
    }
    
    // recursion def
    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        int left = helper(node.left);
        int right = helper(node.right);
        
        int root = node.val + left + right;
        if (minSum == Integer.MAX_VALUE || root <= minSum) {
            minSum = root;
            minNode = node;
        }
        
        return root;
    }
}
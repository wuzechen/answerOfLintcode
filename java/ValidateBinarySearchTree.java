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
    
    private class resultType {
        boolean isBST;
        int min;
        int max;
        public resultType(boolean isBST, int min, int max) {
            this.isBST = isBST;
            this.min = min;
            this.max = max;
        }
    }
    
    /*
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }

        return helper(root).isBST;
    }
    
    private resultType helper(TreeNode node){
        if (node == null) {
            return new resultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        
        resultType left = helper(node.left);
        resultType right = helper(node.right);
        
        if (!left.isBST || !right.isBST) {
            return new resultType(false, 0, 0);
        }
        
        if (node.left != null && left.max >= node.val ||
            node.right != null && right.min <= node.val) {
            return new resultType(false, 0, 0);
        }
        
        return new resultType(true, Math.min(left.min,node.val), 
                                    Math.max(right.max,node.val));
    }
}
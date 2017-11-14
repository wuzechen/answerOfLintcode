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
    
    private class Res {
        int depth;
        boolean isBalanced;
        public Res(int depth, boolean isBalanced){
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }
    
    
    /*
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        return helper(root).isBalanced;
    }
    
    private Res helper(TreeNode node) {
        if (node == null) {
            return new Res(0, true);
        }
        
        Res left = helper(node.left);
        Res right = helper(node.right);
        
        if (left.isBalanced == true && right.isBalanced == true &&
        Math.abs(left.depth - right.depth) <= 1) {
            return new Res(Math.max(left.depth,right.depth) + 1, true);
        }else {
            return new Res(0, false);
        }
    }
    
}
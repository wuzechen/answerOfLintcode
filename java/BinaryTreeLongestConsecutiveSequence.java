/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */


public class Solution {
    private int max = 1;
    
    /*
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root){
        if (root == null) {
            return 0;
        }
        
        int left = helper(root.left);
        int right = helper(root.right);
        
        if (left == 0 && right == 0) {
            return 1;
        }
        
        if (left > 0 && left > right && root.val + 1 == root.left.val) {
            if (left + 1 > max) {
                max = left + 1;
                System.out.println("" + max);
            }
            return left + 1;
        }
        
        if (right > 0 && right > left && root.val + 1 == root.right.val) {
            if (right + 1 > max) {
                max = right + 1;
                System.out.println("" + max);
            }
            return right + 1;
        }
        
        if (left > 0 && left == right && root.val + 1 == root.left.val) {
            if (left + 1 > max) {
                max = left + 1;
                System.out.println("" + max);
            }
            return left + 1;
        }
        
        return 1;
    }
}
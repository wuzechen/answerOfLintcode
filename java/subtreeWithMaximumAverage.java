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
     * @return: the root of the maximum average of subtree
     */
     
    private ReturnType maxAvg = null;
    private TreeNode maxSubtreeNode = null;
        
    public TreeNode findSubtree2(TreeNode root) {
        // write your code here
        // check the edge of input 
        if (root == null) {
            return null;
        }
        
        helper (root);
        
        return maxSubtreeNode;
    }
    
    private ReturnType helper(TreeNode root) {
        if (root == null) {
            return new ReturnType(0,0);
        }

        ReturnType leftReturn = helper(root.left);
        ReturnType rightReturn = helper(root.right);
        ReturnType rootReturn = 
        new ReturnType(leftReturn.sum + rightReturn.sum + root.val,
                       leftReturn.nodeNums + rightReturn.nodeNums + 1);
        
       // float rootAvg = rootReturn.sum / rootReturn.nodeNums;
        
        if (maxSubtreeNode == null ||
        rootReturn.sum * maxAvg.nodeNums > maxAvg.sum * rootReturn.nodeNums) {
            maxAvg = rootReturn;
            maxSubtreeNode = root;
        }
        
        return rootReturn;
    }
    
    private class ReturnType {
        public int sum;
        public int nodeNums;
        public ReturnType(int sum, int nodeNums) {
            this.sum = sum;
            this.nodeNums = nodeNums;
        }
    }
}
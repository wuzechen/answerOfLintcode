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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversalDivideConquer(TreeNode root) {
        // write your code here
        if (root == null) {
            return new ArrayList<Integer>();
        }
        
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        
        List<Integer> result = new ArrayList<Integer>();
        
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        
        return result;
    }
    
    // traverse
    public List<Integer> inorderTraversal(TreeNode root) {
        // check the edge
        List<Integer> traverseResult = new ArrayList<Integer>();
        if (root == null) {
            return traverseResult;
        }
        
        helper(root, traverseResult);
        return traverseResult;
    }
    
    private void helper(TreeNode node, List<Integer> traverseResult) {
        if (node == null) {
            return;
        }
        
        helper(node.left, traverseResult);
        traverseResult.add(node.val);
        helper(node.right, traverseResult);
    }
    
}
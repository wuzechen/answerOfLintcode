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
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> result = new ArrayList();
       
        // check the edge of input
        if (root == null) {
            return result;
        }
        
        findAllChild(root, String.valueOf(root.val), result);
        
        return result;
    }
    
    private void findAllChild(TreeNode node, String pathString, List<String> result) {
        if (node == null) {
            return;
        }
        
        if (node.left == null && node.right == null) {
            result.add(pathString);
            return;
        }
        
        if (node.left != null) {
            findAllChild(node.left, pathString + "->" + String.valueOf(node.left.val), result);
        }
        if (node.right != null) {
            findAllChild(node.right, pathString + "->" + String.valueOf(node.right.val), result);
        } 
    }
}
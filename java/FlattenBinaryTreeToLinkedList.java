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
     * @param root: a TreeNode, the root of the binary tree
     * @return: 
     */
    
    private class resultPair {
        public TreeNode head, tail;
        public resultPair(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    } 
     
    public void flatten(TreeNode root) {
        // write your code here
        // check edge of input 
        if (root == null) {
            return;
        }
        
        //traverse way
        root = helper(root).head;
    }
    
    private resultPair helper(TreeNode node) {
        if (node == null) {
            return new resultPair(null, null);
        }
        
        resultPair left = helper(node.left);
        resultPair right = helper(node.right);
        
        node.left = null;
        
        if (left.head == null && right.head == null) {
            return new resultPair(node,node);
        }
        
        if (left.head != null && right.head != null) {
            node.right = left.head;
            left.tail.right = right.head;
            return new resultPair(node,right.tail);
        }
        
        if (left.head != null && right.head == null) {
            node.right = left.head;
            return new resultPair(node,left.tail);
        }
        
        if (left.head == null && right.head != null) {
            node.right = right.head;
            return new resultPair(node,right.tail);
        }
        
        return new resultPair(null, null);       
    }
}
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
        TreeNode LCA;
        boolean aExists;
        boolean bExists;
        public resultType(TreeNode LCA, boolean aExists, boolean bExists) {
            this.LCA = LCA;
            this.aExists = aExists;
            this.bExists = bExists;
        }
    }
    
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || A == null || B == null) {
            return null;
        }
        
        return helper(root,A,B).LCA;
    }
    
    private resultType helper(TreeNode node, TreeNode A, TreeNode B) {
        if (node == null) {
            return new resultType(null, false, false);
        }
        
        resultType left = helper(node.left, A, B);
        resultType right = helper(node.right, A, B);
        
        // lCA in left return left result
        if (left.aExists && left.bExists) {
            return left;
        }
        
        // LCA in right return righte result
        if (right.aExists && right.bExists) {
            return right;
        }
        
        // one node in each side return the true LCA result
        if (left.aExists && right.bExists || right.aExists && left.bExists) {
            return new resultType(node, true, true);
        }
        
        // only A is exists and node is B return LCA result
        if (left.aExists || right.aExists) {
            if (node.val == B.val) {
                return new resultType(node, true, true);
            } else {
                // node is not B return where A exists part
                return left.aExists?left:right;
            }
        }
        
        // only B is exists and node is A return LCA result
        if (left.bExists || right.bExists) {
            if (node.val == A.val) {
                return new resultType(node, true, true);
            } else {
                // node is not A return where B exists part
                return left.bExists?left:right;
            }
        }
        
        // either A nor B exists in child, and node is A
        if (node.val == A.val) {
            // situation node = A = B
            if (node.val == B.val) {
                return new resultType(node, true, true);
            } else {
                // only A in subtree situation
                return new resultType(null, true, false);
            }
        } else if (node.val == B.val) {
            // situation node = B
            return new resultType(null, false, true);
        } else {
            // A and B not in this subtree
            return new resultType(null, false, false);
        }
    }
}
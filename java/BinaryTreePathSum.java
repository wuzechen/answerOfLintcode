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
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // write your code here
         // check the edge
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        
        if (root == null) {
            return result;
        }
        
        helper(root, path, target, 0, result);
        return result;
    }
    
    private void helper(TreeNode root, 
                        List<Integer> path, 
                        int target, 
                        int sum,
                        List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        
        sum += root.val;
        path.add(root.val);
        
        //leaf
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(path));
                path.remove(path.size() - 1);
                return;
            }
        }

        //left 
        if (root.left != null) {
            helper(root.left, path, target, sum, result);
        }
        
        //right
        if (root.right != null) {
            helper(root.right, path, target, sum, result);
        }
        
        path.remove(path.size() - 1);
    }

}
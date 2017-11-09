public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        
        
        
        // first check the edge of input 
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        if (matrix[0].length == 0) {
            return false;
        }
        
        
        // check the head and tail of the line
        for (int i = 0; i < matrix.length; i++) {
            if (target >= matrix[i][0] 
                && target <= matrix[i][matrix[i].length - 1]) {
                // then loop the line 
                for (int j = 0; j < matrix[i].length; j++) {
                    if (target == matrix[i][j]) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}
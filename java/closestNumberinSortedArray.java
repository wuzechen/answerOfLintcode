public class Solution {
    /*
     * @param A: an integer array sorted in ascending order
     * @param target: An integer
     * @return: an integer
     */
    public int closestNumber(int[] A, int target) {
        // write your code here
        int result = -1;
        // first check the edge of A
        if (A == null || A.length == 0) {
            return result;
        }
        
        int diff = Integer.MAX_VALUE;
        //loop array A
        for (int i = 0; i < A.length; i++) {
            if (Math.abs(A[i] - target) < diff) {
                diff = Math.abs(A[i] - target);
                result = i;
            }
        }
        
        return result;
    }
}
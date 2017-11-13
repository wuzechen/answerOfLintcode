public class Solution {
    /*
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        // check the edge of input 
        
        if (A == null || A.length < 3) {
            return -1;
        }
        
        if (A[0] > A[1] || A[A.length - 2] < A[A.length - 1]) {
            return -1;
        }
        
        int head = 1;
        int tail = A.length - 2;
        
        // throw the other side which not fit
        while (head < tail - 1) {
            int mid = (head + tail) / 2;
            if (A[mid] > A[mid -1]) {
                head = mid;
            }else {
                tail = mid;
            }
        }
        
        // then select the bigger one as the peak
        int result = tail;
        if (A[head] > A[tail]) {
            result = head;
        }
        return result;
    }
}
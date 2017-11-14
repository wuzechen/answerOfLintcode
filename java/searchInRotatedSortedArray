public class Solution {
    /*
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        
        // check the edge of input array
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = A.length - 1;
        //find the min numer postion
        while (start + 1 < end) {
            int mid = start + (end - start) / 2; 
            if (A[mid] < A[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }
        int minPostion = 0;
        if (A[start] < A[end]) {
            minPostion = start;
        } else {
            minPostion = end;
        }
        
        // devide into 2 sorted array and brainy search
        if (target >= A[minPostion] && target <= A[A.length - 1]){
            start = minPostion;
            end = A.length - 1;
        }else {
            start = 0;
            end = minPostion - 1;
        }
        
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (A[start] == target) {
            return start;
        } 
        if (A[end] == target) {
            return end;
        }
        
        return -1;
    }
}
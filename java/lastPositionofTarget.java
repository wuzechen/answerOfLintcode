public class Solution {
    /*
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        // write your code here
        int result = -1;
        
        // first check the input param's edge
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // if (target == null) {
        //     return result;
        // }
        
        // then loop the nums array
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                result = i;
            }
        }
        
        return result;
    }
}
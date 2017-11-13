public class Solution {
    
    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        // check the edge of the input array
        if (nums == null) {
            return result;
        }
        
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        
        Arrays.sort(nums);
        // recursion dfs
        dfsNum(result, new ArrayList<Integer>(), nums, 0);
        
        return result;
        
    }
    
    //define of recursion
    private void dfsNum(List<List<Integer>> result,
                        ArrayList<Integer> subSet,
                        int[] nums,
                        int postion) {
        result.add(new ArrayList<Integer>(subSet));
        
        //split of recursion
        for (int i = postion;i < nums.length; i++) {
            subSet.add(nums[i]);
            
            dfsNum(result, subSet, nums, i + 1);
            subSet.remove(subSet.size() - 1);
        }
    
    //exit of recursion    
    }
}
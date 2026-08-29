class Solution {
    void fun(int[]nums, int target, int start,List<Integer> output, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(output));
            return;
        }
        for(int i = start; i< nums.length; i++){
            if(nums[i] > target){
                break;
            }
            output.add(nums[i]);
            fun(nums, target - nums[i], i,output,ans);
            output.remove(output.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        Arrays.sort(nums);
        fun(nums, target, 0, output,ans);
        return ans;
        
    }
}
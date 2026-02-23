class Solution {
    public int[] runningSum(int[] nums) {
        int[] runningsum = new int[nums.length];
        int i;
        int rs=0;
        for(i=0;i<nums.length;i++){
            runningsum[i]=rs+nums[i];
            rs=rs+nums[i];
        }
        return runningsum;
    }
}
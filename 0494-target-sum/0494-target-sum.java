class Solution {
    int n;

    public int find(int i, int target, int[] nums) {
        if(target==0 && i==n) return 1;
        if(i==n) return 0;

        return find(i+1, target+nums[i], nums) + find(i+1, target-nums[i], nums);

    }

    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;

        return find(0,target,nums);
    }
}
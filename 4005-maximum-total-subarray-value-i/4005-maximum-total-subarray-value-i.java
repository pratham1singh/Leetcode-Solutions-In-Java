class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int mx = nums[0], min = nums[0];
        for(int x: nums){
            mx = Math.max(mx, x);
            min = Math.min(min, x);
        }
        return ((long)mx-(long)min)*k;
    }
}
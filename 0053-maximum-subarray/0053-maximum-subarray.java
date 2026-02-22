class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length, sum = 0, ans = Integer.MIN_VALUE;

        for(int x: nums) {
            sum+=x;
            ans = Math.max(ans, sum);
            if(sum<0) sum = 0;
        }

        return ans;
    }
}
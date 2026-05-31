class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length, mdn = -1, ans=0;
        Arrays.sort(nums);

        if(n%2==0) mdn = (nums[n/2] + nums[n/2-1])/2;
        else mdn = nums[n/2];

        for(int x: nums) ans+=(Math.abs(mdn-x));

        return ans;
    }
}
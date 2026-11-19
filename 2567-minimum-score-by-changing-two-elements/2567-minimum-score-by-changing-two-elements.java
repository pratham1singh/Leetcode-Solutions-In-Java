class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;

        if(n<=3) return 0;

        Arrays.sort(nums);

        int a  = nums[0], b = nums[2], c=nums[n-3], d=nums[n-1];

        int ans = c-a;
        ans = Math.min(ans, d-b);
        
        return Math.min(ans, nums[n-2]-nums[1]);
    }
}
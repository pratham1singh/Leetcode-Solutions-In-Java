class Solution {
    int[] ans;
    public int find(int i, int[] nums, int n) {
        if(i>=n) return 0;
        if(ans[i]!=-1) return ans[i];
      
        int with = nums[i] + find(i+2, nums, n);
        int without = find(i+1, nums, n);
        return ans[i] = Math.max(with, without);
    }
    public int rob(int[] nums) {
        int n =nums.length, x=0;
        ans = new int[nums.length];
        if(n==1) return nums[0];
        Arrays.fill(ans,-1);
        x= nums[n-1];
        nums[n-1] =0;
        int a = nums[0] + find(2, nums, nums.length);
        Arrays.fill(ans,-1);
        nums[n-1] = x;

        return Math.max(a, find(1, nums, nums.length));
    }
}
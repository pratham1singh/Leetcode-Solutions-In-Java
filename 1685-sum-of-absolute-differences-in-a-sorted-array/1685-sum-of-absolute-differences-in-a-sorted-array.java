class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n=nums.length,sl=0,sr=0,ans[]= new int[n];

        for(int x:nums)
            sr+=x;
        for(int i=0;i<n;i++){
            ans[i]=Math.abs(i*nums[i]-sl)+Math.abs((n-i)*nums[i]-sr);
            sl+=nums[i];
            sr-=nums[i];
        }
        return ans;
    }
}
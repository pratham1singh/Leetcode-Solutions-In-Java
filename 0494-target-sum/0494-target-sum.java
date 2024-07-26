class Solution {

    int n,target;
    public int find(int i,int value,int nums[]){
        if(i==n&&value==target)
            return 1;
        if(i==n)
            return 0;
        int ans=0;
        ans+=find(i+1,value+nums[i],nums);
        ans+=find(i+1,value-nums[i],nums);
        return ans;
    }
    public int findTargetSumWays(int[] nums, int target) {
        n=nums.length;
        this.target=target;
        return find(0,0,nums);
    }
}
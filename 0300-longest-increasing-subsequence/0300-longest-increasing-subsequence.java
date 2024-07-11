class Solution {
    int solved[][];

    public int find(int i,int pre,int nums[],int n){
        if(i==n)
            return 0;
        else if(pre==-1)
            return Math.max(1+find(i+1,i,nums,n),find(i+1,pre,nums,n));
        else if(solved[i][pre]!=-1)
            return solved[i][pre];
        else if(nums[i]>nums[pre])
            return solved[i][pre]=Math.max(1+find(i+1,i,nums,n),find(i+1,pre,nums,n));
        else
            return solved[i][pre]=find(i+1,pre,nums,n);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        solved= new int[n][n];
        for(int x[]:solved)
            Arrays.fill(x,-1);

        return find(0,-1,nums,n);

    }
}
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length,solved[][]= new int[n+1][n+1];

        for(int i=n-1;i>=0;i--){
            for(int pre=i-1;pre>=-1;pre--){
                if(pre==-1||nums[i]>nums[pre])
                    solved[i][pre+1]=Math.max(1+solved[i+1][i+1],solved[i+1][pre+1]);
                else
                    solved[i][pre+1]=solved[i+1][pre+1];
            }
        }
       
        
        return solved[0][0];

    }
}
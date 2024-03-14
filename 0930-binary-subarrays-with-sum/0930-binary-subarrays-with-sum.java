class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n=nums.length,ans=0;
        for(int i=0;i<n;i++){
            int s=0;
            for(int j=i;j<n;j++){
                s+=nums[j];
                if(s==goal)
                    ans+=1;
                if(s>goal)
                    break;
            }
        }
        return ans;
    }
}
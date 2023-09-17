class Solution {
    public int arrayNesting(int[] nums) {
        int ans=0,i=0,n=nums.length;
        for(i=0;i<n;i++){
            int c=0;
            while(i!=-1&&nums[i]!=-1){
                int x=nums[i];
                nums[i]=-1;
                i=x;
                c+=1;
                
            }
            ans=Math.max(c,ans);
        }
        return ans;

    }
}
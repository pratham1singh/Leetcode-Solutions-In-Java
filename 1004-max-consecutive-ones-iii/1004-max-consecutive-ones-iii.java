class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length,ans=0,i=0,j=0,c=0;
      
        while(j<n){
            if(nums[j]==0&&c<k){
                j+=1;
                c+=1;
            }
            else if(nums[j]==0&&c==k){
                while(i<=j&&nums[i]!=0)
                    i+=1;
                i+=1;
                j+=1;
            }
            else
                j+=1;
            // System.out.println(i+" "+j);
            ans=Math.max(ans,j-i);
        }
        return ans;
    }
}
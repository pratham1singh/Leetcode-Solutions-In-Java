class Solution {
    public long countSubarrays(int[] nums, int k) {
        int mx=nums[0],c=0,n=nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int x:nums)
            if(x>mx)
                mx=x;
        int i=0,j=0;
        if(nums[0]==mx)
            c=1;
        long ans=0;
        while(j<n){
            if(c<k){
                j+=1;
                if(j<n&&nums[j]==mx)
                    c+=1;
            }
            else if(c==k){
                ans+=(1+(n-j-1));
                if(nums[i]==mx)
                    c-=1;
                i+=1;
            }
        }
        return ans;
        
    }
}
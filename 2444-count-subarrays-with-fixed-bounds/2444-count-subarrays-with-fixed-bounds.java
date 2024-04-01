class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n=nums.length,i=0,j=0,mn=0,mx=0,goodRange[]= new int[n];
        long ans=0;
        if(nums[0]==minK)
            mn+=1;
        if(nums[0]==maxK)
            mx+=1;
        
        for(i=n-1;i>=0;i--){
            if(nums[i]<=maxK&&nums[i]>=minK){
                if(i==n-1)
                    goodRange[i]=1;
                else
                    goodRange[i]=goodRange[i+1]+1;
            }
            else
                goodRange[i]=0;
        }
        i=0;
        while(j<n){
           if(mn>0&&mx>0){
               
                int k=0;
                if(j+1<n)
                    k=goodRange[j+1];
                // System.out.println(i+" "+j);
                while(i<=j&&mn>0&&mx>0){
                    ans+=(1+k);
                    if(minK==nums[i])
                        mn-=1;
                    if(maxK==nums[i])
                        mx-=1;
                    i+=1;
                }
                
           }
           else if(nums[j]>maxK||nums[j]<minK){
                j+=1;
                i=j;
                if(j<n){
                    mn=0;
                    mx=0;
                    if(nums[j]==maxK)
                        mx+=1;
                    if(nums[j]==minK)
                        mn+=1;
                }
           }
           else{
                j+=1;
                if(j<n){
                    if(nums[j]==maxK)
                        mx+=1;
                    if(nums[j]==minK)
                        mn+=1;
                }
           }
        }

        return ans;
    }
}
class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n= nums.length;
        int ans[] = new int[n];
        int i=0;
        while(i<n){
            if(i-k<0){
                ans[i]=-1;
            }
            else if(i+k>=n){
                ans[i]=-1;
            }

            i+=1;
        }
        if(2*k<n){
            long s=0;
            i=0;
            while(i<=2*k){
                s+=nums[i];
                i+=1;
            }
            i=k;
            while(i+k<n){
                ans[i]=(int)(s/(2*k+1));
                s-=nums[i-k];
                i+=1;
                if(i+k>=n)
                    break;
                s+=nums[i+k];
            }
        }
        return ans;
    }
}
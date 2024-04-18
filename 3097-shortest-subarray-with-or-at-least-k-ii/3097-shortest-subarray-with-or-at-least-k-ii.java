class Solution {
    public void remove(int arr[],int x){
        int i=0;
        while(x>0){
            if((x&1)==1)
                arr[i]-=1;
            i+=1;
            x=x>>1;
        }
    }
    public void add(int arr[],int x){
        int i=0;
        while(x>0){
            if((x&1)==1)
                arr[i]+=1;
            i+=1;
            x=x>>1;
        }
    }
    public int toNum(int arr[]){
        int ans=0;
        for(int i=0;i<33;i++)
            if(arr[i]>0)
                ans+=(int)Math.pow(2,i);
        return ans;
    }
    public int minimumSubarrayLength(int[] nums, int k) {
        if(k==0)
            return 1;
        int n=nums.length, ans=2*n,arr[]= new int[33],i=0,j=0;
        add(arr,nums[0]);
        while(j<n){
            if(toNum(arr)>=k){
                ans=Math.min(ans,j-i+1);
                remove(arr,nums[i]);
                i+=1;
            }
            else{
                j+=1;
                if(j<n)
                    add(arr,nums[j]);
            }
        }
        if(ans==2*n)
            return -1;
        return ans;
    }
}
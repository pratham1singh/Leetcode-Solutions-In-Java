class Solution {
    public long find(int arr[],int n,int i,long p){
        if(i==n)
            return p;
        else{
            return Math.max(find(arr,n,i+1,p*arr[i]),find(arr,n,i+1,p));
        }
    }
    public long maxStrength(int[] nums) {
        if(nums.length==1)
            return nums[0];
        int n=0,p=0;
        for(Integer x:nums){
            if(x>0)
                p+=1;
            else if(x<0)
                n+=1;
        }
        if(p==0&&n<=1)
            return 0;
        return find(nums,nums.length,0,1);
    }
}
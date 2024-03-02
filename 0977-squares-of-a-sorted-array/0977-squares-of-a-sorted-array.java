class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int ans[]= new int[n],i=0,j=n-1,k=n-1;
        while(i<=j){
            if(nums[i]*nums[i]<nums[j]*nums[j]){
                ans[k]=nums[j]*nums[j];
                j-=1;
                k-=1;
            }
            else{
                ans[k]=nums[i]*nums[i];
                i+=1;
                k-=1;
            }
        }
        return ans;
    }
}
class Solution {
    int n,nums[];
    public int longestINC(int i,int j ){
        if(i==n)
            return 0;
        else if(j==-1)
            return Math.max(longestINC(i+1,j),longestINC(i+1,i));
        else if(nums[j]<nums[i])
            return 1+longestINC(i+1,i);
        else
            return 0;

    }
    public int longestDEC(int i,int j ){
        if(i==n)
            return 0;
        else if(j==-1)
            return Math.max(longestDEC(i+1,j),longestDEC(i+1,i));
        else if(nums[j]>nums[i])
            return 1+longestDEC(i+1,i);
        else
            return 0;

    }
    public int longestMonotonicSubarray(int[] nums) {
        this.nums=nums;
        n=nums.length;
        int a=longestINC(-1,-1),b=longestDEC(-1,-1);
        return Math.max(a,b)+1;
    }
}
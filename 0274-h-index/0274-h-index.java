class Solution {
    public int hIndex(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int ans=0;
        for(int k=n;k>=1;k--){
            int i=0;
            for( i=0;i<n;i++)
                if(nums[i]>=k)
                    break;
            if(n-i>=k)
                return k;
        }
        return 0;
    }
}
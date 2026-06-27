class Solution {
    private boolean isValidSum(long sum, int x) {
        long f=0, temp = sum;

        while(temp/10 > 0) {
            temp = temp/10;
        }   

        f=temp;
        temp = sum;
        
        while(sum/10 > 0) {
            sum = sum%10;
        }
        return f==x && sum ==x;
    }

    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length, ans=0;
        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for(int i=1;i<n;i++) prefix[i] = prefix[i-1] + nums[i];

        for(int i=0;i<n;i++) 
            for(int j=i;j<n;j++) {
                long sum = prefix[j];
                if(i-1>=0) sum-=prefix[i-1];

                if(isValidSum(sum, x)) ans++;
            }
        return ans;
    }
}
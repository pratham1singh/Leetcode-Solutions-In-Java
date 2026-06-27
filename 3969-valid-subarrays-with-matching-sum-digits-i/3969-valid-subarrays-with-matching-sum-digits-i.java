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

        for(int i=0;i<n;i++) {
            long sum = 0;
            for(int j=i;j<n;j++) {
                sum += nums[j];
                if(isValidSum(sum, x)) ans++;
            }
        }
        return ans;
    }
}
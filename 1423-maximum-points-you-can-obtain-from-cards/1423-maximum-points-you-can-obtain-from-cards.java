class Solution {
    public int maxScore(int[] nums, int k) {
        int sum = 0, ans = -1, n=nums.length, i=n-k, j=n-1, count = k;
        if(k==1) return Math.max(nums[0], nums[n-1]);

        while(i<=n-1) sum+=nums[i++];
        ans = Math.max(ans, sum);
        i=n-k;
        sum-=nums[i];
        i++;
        sum+=nums[0];
        j=0;

        while(i>0) {
            ans = Math.max(ans, sum);
            sum-=nums[i];
            i= (i+1)%n;
            j= (j+1)%n;
            sum+=nums[j];
            count--;
        }
        ans = Math.max(ans, sum);

        return ans;

    }
}
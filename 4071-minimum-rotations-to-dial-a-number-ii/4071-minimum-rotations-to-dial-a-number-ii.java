class Solution {
    public int minRotations(int n, String s) {
        int i=0, preSum=0, ans=0, temp=0;
        int[] arr = new int[n];

        for(char ch: s.toCharArray()) arr[i++] = ch - '0';

        i=1;

        while(i<n) preSum+=(Math.min(Math.abs(arr[i] - arr[i-1]), 10-Math.abs(arr[i] - arr[i++-1])));

        i=0;

        ans =Math.min( arr[i] , 10- arr[i] )+ preSum;

        while(i<n) {
            int pre = i-1>=0 ? arr[i-1] : 0;

            ans  = Math.min(ans, Math.min(Math.abs(pre-arr[n-1]), 10-Math.abs(pre-arr[n-1])) + preSum + temp);
            temp+=Math.min(Math.abs(pre-arr[i]), 10-Math.abs(pre-arr[i]));

            i++;

            int post = i >= n ? 0 : arr[i];

            preSum-=Math.min(Math.abs(arr[i-1] - post), 10-Math.abs(arr[i-1] - post));
        }

        return ans;


    }
}
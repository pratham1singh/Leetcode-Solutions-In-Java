class Solution {
    public int longestMountain(int[] arr) {
        int n= arr.length, ans=0;
        int[] min = new int[n], max = new int[n];

        for(int i=n-2;i>=0;i--) min[i] = arr[i+1] >= arr[i] ? 0 : min[i+1] + 1;
        for(int i=1;i<n;i++) max[i] = arr[i-1] >= arr[i] ? 0 : max[i-1] + 1;

        for(int i=1;i<n-1;i++) ans = min[i] > 0 && max[i] > 0 ? Math.max(ans, min[i] + max[i]) : ans;

        return ans == 0 ? 0 : ans + 1;
    }
}
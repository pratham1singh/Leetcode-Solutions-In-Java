class Solution {
    public int candy(int[] arr) {
        int n= arr.length, temp=0;
        int[] ans = new int[n];

        Arrays.fill(ans,1);

        for(int i=0;i<n-1;i++) {
            if(arr[i]<arr[i+1]) ans[i+1]=ans[i]+1;
        }

        for(int i=n-1;i>0;i--) {
            if(arr[i-1]>arr[i]) ans[i-1] = ans[i] +1;

            if(i+1<n && arr[i-1] < arr[i] && arr[i] > arr[i+1]) ans[i] = Math.max(ans[i-1], ans[i+1]) + 1;
        }

        // for(int i=1;i<n-1;i++) {
        //     if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) ans[i] = Math.max(ans[i-1], ans[i+1]) + 1;
        // }
        for(int x: ans) temp+=x;

        return temp;
    }
}
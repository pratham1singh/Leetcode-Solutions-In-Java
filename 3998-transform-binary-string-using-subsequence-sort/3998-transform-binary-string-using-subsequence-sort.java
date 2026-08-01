class Solution {
    public boolean[] transformStr(String s, String[] strs) {
        int n =s.length(), p=0;
        int[] arr = new int[n];
        boolean[] ans = new boolean[strs.length];

        for(int i=0;i<n;i++) if(s.charAt(i) == '1') arr[i] = 1;
        for(int i=1;i<n;i++) arr[i] += arr[i-1];

        for(String str: strs) {
            int[] temp = new int[n];
            int[] q = new int[n];

             for(int i=0;i<n;i++) {
                if(str.charAt(i) == '1') temp[i] = 1;
                else if(str.charAt(i) == '?') q[i] =1;
             }
        for(int i=1;i<n;i++) {
            temp[i] += temp[i-1];
            q[i] += q[i-1];
        }

            boolean z = true;

           for(int i=0;i<n;i++) {
                if(str.charAt(i)=='?') continue;
                else {
                    int total_z = (n-i) - (arr[n-1]- (i-1>= 0 ? arr[i-1] : 0));
                    int total_z2 = (n-i) - (temp[n-1]- (i-1>= 0 ? temp[i-1] : 0)) - (q[n-1] - (i-1>= 0 ? q[i-1] : 0));

                   z  = z && total_z>=total_z2 && arr[i]>=temp[i];
                }
           }
           ans[p++]=z;
            
        }

        return ans;
    }
}
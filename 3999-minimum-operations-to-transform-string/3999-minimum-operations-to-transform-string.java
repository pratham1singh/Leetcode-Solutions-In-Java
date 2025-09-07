class Solution {
    public int minOperations(String s) {
        int n = s.length(), arr[] =  new int[26], ans = 0;

        for(int i=0;i<n;i++) 
            arr[s.charAt(i) - 97]++;

        boolean flag = true;

        while(flag) {
            flag = false;
            for(int i=1;i<26;i++) 
                if(arr[i]!=0) {
                    flag = true;
                    arr[(i+1)%26] = arr[i];
                    arr[i] = 0;
                    ans++;
                }
        }
        return ans;

    }
}
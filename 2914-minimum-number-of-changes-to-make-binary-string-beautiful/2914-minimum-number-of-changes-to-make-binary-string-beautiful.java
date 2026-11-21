class Solution {
    public int minChanges(String s) {
        int n = s.length(), j=0, i=1, ans=0;

        char[] arr = s.toCharArray();
        
        while(i<n) {
            if(arr[i-1] == arr[i]) i++;
            else {
                if((i-j)%2==1) ans ++;
                else j=i;

                i++;
            }
        }
       if((i-j)%2==1) ans ++;

        return ans;
    }
}
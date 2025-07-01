class Solution {
    public int possibleStringCount(String word) {
        int n = word.length(), ans=1, i=0, c=0;

        while(i<n) {
            c=1;
            while(i+1<n && word.charAt(i)==word.charAt(i+1)) {
                i++;
                c++;
            }
            i++;
            ans+=(c-1);
        }

        return ans;
    }
}
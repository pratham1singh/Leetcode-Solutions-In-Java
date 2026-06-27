class Solution {
    public int maxDistance(String str) {
        int a=0, b=0, n=str.length(), e =0;

        for(int i=0;i<n;i++) {
            if(str.charAt(i) == 'U') a++;
            else if(str.charAt(i) == 'D') a--;
            else if(str.charAt(i) == 'L') b++;
            else if (str.charAt(i) == 'R') b--;
            else e++;
        }

        return Math.abs(a) + Math.abs(b) + e;

    }
}
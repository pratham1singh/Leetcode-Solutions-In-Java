class Solution {
    public int maxDistance(String str) {
        int u =  0, d = 0, l = 0, r=0, n=str.length(), e =0, ans=0;
        for(int i=0;i<n;i++) {
            if(str.charAt(i) == 'U') u++;
            else if(str.charAt(i) == 'D') d++;
            else if(str.charAt(i) == 'L') l++;
            else if (str.charAt(i) == 'R') r++;
        }

        e = n- (u+d+l+r);
        
        ans = Math.abs(u-d) + Math.abs(l-r) + e;

        return ans;

    }
}
class Solution {
    public int pivotInteger(int n) {
        int r=n*(n+1)/2,l=0;

        for(int i=1;i<=n;i++){
            l+=i;
            if(l==r)
                return i;
            r-=i;
        }
        return -1;
    }
}
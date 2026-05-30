class Solution {
    public int minMoves(int[] nums) {
        int mn = Integer.MAX_VALUE, ans=0;

        for(int x: nums) if(x<mn) mn = x;
        for(int x: nums) ans+=(x-mn);

        return ans;
    }
}
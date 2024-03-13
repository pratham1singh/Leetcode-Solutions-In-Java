class Solution {
    int n,nums[];
    public boolean find(int i,int j,int a,int b,int k){
        if(i>j)
            return a>b;
        else if(k==0)
            return find(i+1,j,a+nums[i],n,1)||find(i,j-1,a+nums[j],b,1);
        else
            return find(i+1,j,a,b+nums[i],0)||find(i,j-1,a,b+nums[j],0);
        
    }
    public boolean stoneGame(int[] piles) {
        n=piles.length;
        nums=piles;
        return find(0,n-1,0,0,0);
    }
}
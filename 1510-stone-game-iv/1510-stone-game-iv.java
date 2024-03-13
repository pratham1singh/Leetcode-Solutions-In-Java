class Solution {
    int solved[][];
    public boolean find(int n,int k){
        if(n==0)
            return k==1;
        else if(solved[n][k]!=0)
            return solved[n][k]==1;
        else if(k==0){
            boolean ans=false;
            for(int i=1;i*i<=n;i++)
                ans = ans || find(n-i*i,1);
            solved[n][k]=ans?1:-1;
            return ans;
        }
        else{
            boolean ans=false;
            for(int i=1;i*i<=n;i++)
                ans = ans || !find(n-i*i,0);
            solved[n][k]=!ans?1:-1;
            return !ans;
        }
    }
    public boolean winnerSquareGame(int n) {
        solved= new int[n+1][2];
        return find(n,0);
    }
}
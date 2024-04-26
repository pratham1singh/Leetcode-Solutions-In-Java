class Solution {
    int n,grid[][],solved[][];

    public int find(int i,int j){
        if(i==n)
            return 0;
        else if(solved[i][j]!=-1)
            return solved[i][j];
        else {
            int ans=Integer.MAX_VALUE;
            for(int k=0;k<n;k++)
                if(k!=j){
                    ans=Math.min(ans,grid[i][k]+find(i+1,k));
                }
            return solved[i][j]=ans;
        }
    }
    public int minFallingPathSum(int[][] grid) {
        n=grid.length;
        this.grid=grid;
        solved= new int[n][n+1];
        for(int x[]:solved)
            Arrays.fill(x,-1);
        return find(0,n);
    }
}
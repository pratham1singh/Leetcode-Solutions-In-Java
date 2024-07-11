class Solution {
    int m,n,grid[][],solved[][];

    public int find(int i,int j){
        if(i==m-1&&j==n-1)
            return grid[i][j];
        if(i>=m||j>=n)
            return 700000;
        if(solved[i][j]!=-1)
            return solved[i][j];
        int ans=Integer.MAX_VALUE;
        ans=Math.min(ans,grid[i][j]+find(i+1,j));
        ans=Math.min(ans,grid[i][j]+find(i,j+1));
        return solved[i][j]=ans;
    }
    public int minPathSum(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        this.grid=grid;
        solved= new int[m][n];
        for(int x[]:solved)
            Arrays.fill(x,-1);
        return find(0,0);
    }
}
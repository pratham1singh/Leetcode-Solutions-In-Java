class Solution {
    int m,n,grid[][],solved[][];
    public int find(int i,int j){
        if(solved[i][j]!=-1)
            return solved[i][j];
        int ans=1;
        if(i+1<m&&grid[i][j]<grid[i+1][j])
            ans+=find(i+1,j);
        if(i-1>=0&&grid[i][j]<grid[i-1][j])
            ans+=find(i-1,j);
        if(j+1<n&&grid[i][j]<grid[i][j+1])
            ans+=find(i,j+1);
        if(j-1>=0&&grid[i][j]<grid[i][j-1])
            ans+=find(i,j-1);
        return solved[i][j]=ans;
        
    }
    public int countPaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        this.grid=grid;
        solved= new int[m][n];
        for(int x[]:solved)
            Arrays.fill(x,-1);
        int ans=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                ans+=find(i,j);
        return ans;
    }
}
class Solution {
    int m,n,visited[][],grid[][];

    public int find(int i,int j){
        System.out.println(i+" "+j);
        int ans=0;

        if(i+1<m&&grid[i+1][j]!=0&&visited[i+1][j]==0){
            visited[i+1][j]=1;
            ans=Math.max(ans,grid[i+1][j]+find(i+1,j));
            visited[i+1][j]=0;
        }
        if(j+1<n&&grid[i][j+1]!=0&&visited[i][j+1]==0){
            visited[i][j+1]=1;
            ans=Math.max(ans,grid[i][j+1]+find(i,j+1));
            visited[i][j+1]=0;
        }
        if(i-1>=0&&grid[i-1][j]!=0&&visited[i-1][j]==0){
            visited[i-1][j]=1;
            ans=Math.max(ans,grid[i-1][j]+find(i-1,j));
            visited[i-1][j]=0;
        }
        if(j-1>=0&&grid[i][j-1]!=0&&visited[i][j-1]==0){
            visited[i][j-1]=1;
            ans=Math.max(ans,grid[i][j-1]+find(i,j-1));
            visited[i][j-1]=0;
        }
        return ans;
    }
    public int getMaximumGold(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        this.grid=grid;
        visited= new int[m][n];

        int ans=0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]>0){
                    visited[i][j]=1;
                    ans=Math.max(ans,grid[i][j]+find(i,j));
                    visited[i][j]=0;
                }
       
        return ans;
            
    }
}
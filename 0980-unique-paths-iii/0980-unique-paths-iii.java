class Solution {
    int m,n,visited[][],solved[][][],grid[][];

    public int find(int i,int j,int total){
        if(grid[i][j]==2)
            return total==0?1:0;
        else{
            int ans=0;
            if(i+1<m&&visited[i+1][j]==0&&grid[i+1][j]!=-1){
                visited[i+1][j]=1;
                ans+=find(i+1,j,total-1);
                visited[i+1][j]=0;
            }
            if(j+1<n&&visited[i][j+1]==0&&grid[i][j+1]!=-1){
                visited[i][j+1]=1;
                ans+=find(i,j+1,total-1);
                visited[i][j+1]=0;
            }
            if(i-1>=0&&visited[i-1][j]==0&&grid[i-1][j]!=-1){
                visited[i-1][j]=1;
                ans+=find(i-1,j,total-1);
                visited[i-1][j]=0;
            }
            if(j-1>=0&&visited[i][j-1]==0&&grid[i][j-1]!=-1){
                visited[i][j-1]=1;
                ans+=find(i,j-1,total-1);
                visited[i][j-1]=0;
            }
            return ans;
        }
    }
    
    public int uniquePathsIII(int[][] grid) {
         m=grid.length;
         n=grid[0].length;
         this.grid=grid;
        visited= new int[m][n];
        solved= new int[m][n][m*n];
        for(int x[][]:solved)
            for(int y[]:x)
                Arrays.fill(y,-1);
        int total=0,a=0,b=0;

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(grid[i][j]!=-1)
                    total+=1;
                if(grid[i][j]==1){
                    a=i;
                    b=j;
                }
            }
        visited[a][b]=1;
        return find(a,b,total-1);

    }
}
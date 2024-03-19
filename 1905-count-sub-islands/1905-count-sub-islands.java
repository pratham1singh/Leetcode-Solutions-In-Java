class Solution {
    int grid1[][],grid2[][],n,solved[][],m;
    public boolean find(int i,int j){
        boolean ans=true;
        if(i+1<m&&grid2[i+1][j]==1&&solved[i+1][j]==0){
            solved[i+1][j]=1;
            ans=find(i+1,j)&&ans;
        }
        if(i-1>=0&&grid2[i-1][j]==1&&solved[i-1][j]==0){
            solved[i-1][j]=1;
            ans=find(i-1,j)&&ans;
        }
        if(j+1<n&&grid2[i][j+1]==1&&solved[i][j+1]==0){
            solved[i][j+1]=1;
            ans=find(i,j+1)&&ans;
        }
        if(j-1>=0&&grid2[i][j-1]==1&&solved[i][j-1]==0){
            solved[i][j-1]=1;
            ans=find(i,j-1)&&ans;
        }
        ans=ans&&grid2[i][j]==1&&grid1[i][j]==1;
        return ans;
        
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m=grid1.length;
        n=grid1[0].length;
        this.grid1=grid1;
        this.grid2=grid2;
        int visited[][]= new int[m][n],ans=0;
        solved= new int[m][n];

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid2[i][j]==1&&solved[i][j]==0){
                    // visited[i][j]=1;
                    solved[i][j]=1;
                    boolean res=find(i,j);
                    if(res)
                        ans+=1;
                }
            
        return ans;
    }
}
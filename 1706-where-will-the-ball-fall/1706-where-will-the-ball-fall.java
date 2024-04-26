class Solution {
    int m,n,grid[][];
    public int find(int j){
        char dir='d';
        int i=0;
        while(i<m&&j<n&&j>=0&&i>=0){
            
           if(grid[i][j]==1&&dir=='d'){
                j+=1;
                dir='r';
            }
            else if(grid[i][j]==1&&dir=='l')
               return -1;
            else if(grid[i][j]==1&&dir=='r'){
                i+=1;
                dir='d';
            }
            else if(grid[i][j]==-1&&dir=='d'){
                j-=1;
                dir='l';
            }
            else if(grid[i][j]==-1&&dir=='r')
               return -1;
            else if(grid[i][j]==-1&&dir=='l'){
                i+=1;
                dir='d';
            }
        }
        if(i==m)
            return j;
        return -1;
    }
    public int[] findBall(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int ans[]= new int[n];
        if(m==1){
            Arrays.fill(ans,-1);
            return ans;
        }
        this.grid=grid;

        for(int i=0;i<n;i++)    
            ans[i]=find(i);
        return ans;
    }
}
class Solution {
    class node{
        int i,j,t;
        public node(int i,int j,int t){
            this.i=i;
            this.j=j;
            this.t=t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int m=grid.length,n=grid[0].length,visited[][]= new int[m][n];
        Queue<node> queue = new LinkedList<>();

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==2){
                    queue.add(new node(i,j,0));
                    visited[i][j]=1;
                }
        int ans=0;
        while(queue.size()>0){
            node z=queue.remove();
            ans=Math.max(ans,z.t);

            if(z.i+1<m&&grid[z.i+1][z.j]==1&&visited[z.i+1][z.j]==0){
                visited[z.i+1][z.j]=1;
                queue.add(new node(z.i+1,z.j,z.t+1));
            }
            if(z.j+1<n&&grid[z.i][z.j+1]==1&&visited[z.i][z.j+1]==0){
                visited[z.i][z.j+1]=1;
                queue.add(new node(z.i,z.j+1,z.t+1));
            }
            if(z.i-1>=0&&grid[z.i-1][z.j]==1&&visited[z.i-1][z.j]==0){
                visited[z.i-1][z.j]=1;
                queue.add(new node(z.i-1,z.j,z.t+1));
            }
            if(z.j-1>=0&&grid[z.i][z.j-1]==1&&visited[z.i][z.j-1]==0){
                visited[z.i][z.j-1]=1;
                queue.add(new node(z.i,z.j-1,z.t+1));
            }
        }
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==1&&visited[i][j]==0)
                    return -1;
        return ans;
    }
}
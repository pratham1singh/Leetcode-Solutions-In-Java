class node{
    int i,j;
    public node(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {

    int ans=0,flag=0,visited[][],m,n;
    public void bfs(int grid[][],int i,int j){

        Queue<node> queue= new LinkedList<>();
        queue.add(new node(i,j));
        int l=1,count=0;
        flag=-1; //-1 indicates that we still not got a block which is at border
        while(l>0){
            node x=queue.remove();
            l-=1;
            count+=1;
            if((x.i==0||x.i==m-1)||(x.j==0||x.j==n-1)){
                    flag=0;
            }

            if(x.i+1<m&&grid[x.i+1][x.j]==1&&visited[x.i+1][x.j]==0){
                queue.add(new node(x.i+1,x.j));
                l+=1;
                visited[x.i+1][x.j]=1;
            }
             if(x.i-1>=0&&grid[x.i-1][x.j]==1&&visited[x.i-1][x.j]==0){
                queue.add(new node(x.i-1,x.j));
                l+=1;
                visited[x.i-1][x.j]=1;
            }
             if(x.j+1<n&&grid[x.i][x.j+1]==1&&visited[x.i][x.j+1]==0){
                queue.add(new node(x.i,x.j+1));
                l+=1;
                visited[x.i][x.j+1]=1;
            }
             if(x.j-1>=0&&grid[x.i][x.j-1]==1&&visited[x.i][x.j-1]==0){
                queue.add(new node(x.i,x.j-1));
                l+=1;
                visited[x.i][x.j-1]=1;
            }
        }
        
        
        if(flag==-1){
            
            ans+=count;}
    }
    public int numEnclaves(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        visited =new int[m][n];
        ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1&&visited[i][j]==0){
                    visited[i][j]=1;
                    bfs(grid,i,j);
                }
            }
        }
        return ans;
    }
}
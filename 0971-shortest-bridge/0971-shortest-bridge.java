class node{
    int i,j;
    public node(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class node2{
    int i,j,d;
    public node2(int i,int j,int d){
        this.i=i;
        this.j=j;
        this.d=d;
    }
}
class Solution {
    int m,n,visited[][];

    public void bfs(int i,int j,int grid[][]){
        Queue<node> queue =new LinkedList<>();
        queue.add(new node(i,j));
        int l=1;
        visited[i][j]=1;
        while(l>0){
            node x=queue.remove();
            l-=1;
            grid[x.i][x.j]=-1;

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
            if(x.j-1>=0&&grid[x.i][x.j-1]==1&&visited[x.i][x.j-1]==0){
                queue.add(new node(x.i,x.j-1));
                l+=1;
                visited[x.i][x.j-1]=1;
            }
            if(x.j+1<n&&grid[x.i][x.j+1]==1&&visited[x.i][x.j+1]==0){
                queue.add(new node(x.i,x.j+1));
                l+=1;
                visited[x.i][x.j+1]=1;
            }
        }
    }
    public int shortestBridge(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        visited= new int[m][n];
        int flag=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    bfs(i,j,grid);
                    flag=0;
                    break;
                }
            }
            if(flag==0)
                break;
        }
        visited =new int[m][n];
        Queue<node2> queue=new LinkedList<>();
        int l=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    visited[i][j]=1;
                   queue.add(new node2(i,j,-1));
                   l+=1;
                }
            }
        }
        
        while(l>0){
            node2 x=queue.remove();
            l-=1;
            System.out.println(x.i+" "+x.j);
            if(grid[x.i][x.j]==-1){
                return x.d;
            }
            
            if(x.i+1<m&&visited[x.i+1][x.j]==0){
                queue.add(new node2(x.i+1,x.j,x.d+1));
                l+=1;
                visited[x.i+1][x.j]=1;
            }
            if(x.i-1>=0&&visited[x.i-1][x.j]==0){
                queue.add(new node2(x.i-1,x.j,x.d+1));
                l+=1;
                visited[x.i-1][x.j]=1;
            }
            if(x.j-1>=0&&visited[x.i][x.j-1]==0){
                queue.add(new node2(x.i,x.j-1,x.d+1));
                l+=1;
                visited[x.i][x.j-1]=1;
            }
            if(x.j+1<n&&visited[x.i][x.j+1]==0){
                queue.add(new node2(x.i,x.j+1,x.d+1));
                l+=1;
                visited[x.i][x.j+1]=1;
            }
        }

        return -1;
    }
}
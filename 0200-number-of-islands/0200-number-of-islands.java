class node{
    int i,j;
    public node(int i,int j){
        this.i=i;
        this.j=j;
    }
}

class Solution {

    int m,n,ans=0;
    int visited[][];

    public void bfs(Queue<node> queue,char arr[][]){
        int l=1;
        
        while(l>0){
            node x=queue.remove();
            l-=1;
            if(x.i+1<m&&visited[x.i+1][x.j]==0&&arr[x.i+1][x.j]=='1'){
                queue.add(new node(x.i+1,x.j));
                visited[x.i+1][x.j]=1;
                l+=1;
            }
            if(x.j+1<n&&visited[x.i][x.j+1]==0&&arr[x.i][x.j+1]=='1'){
                queue.add(new node(x.i,x.j+1));
                visited[x.i][x.j+1]=1;
                l+=1;
            }
            if(x.j-1>=0&&visited[x.i][x.j-1]==0&&arr[x.i][x.j-1]=='1'){
                queue.add(new node(x.i,x.j-1));
                visited[x.i][x.j-1]=1;
                l+=1;
            }
            if(x.i-1>=0&&visited[x.i-1][x.j]==0&&arr[x.i-1][x.j]=='1'){
                queue.add(new node(x.i-1,x.j));
                visited[x.i-1][x.j]=1;
                l+=1;
            }

        }
    }
    public int numIslands(char[][] grid) {
        m=grid.length;n=grid[0].length;
        visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==0&&grid[i][j]=='1'){
                    ans+=1;
                    visited[i][j]=1;
                    Queue<node> queue=new LinkedList<>();
                    queue.add(new node(i,j));
                    bfs(queue,grid);
                }
            }
        }
        return ans;
    }
}
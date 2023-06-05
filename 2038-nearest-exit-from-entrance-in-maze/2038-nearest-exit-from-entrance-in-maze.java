class Solution {
    class node{
        int i,j,d;
        public node(int i,int j,int d){
            this.i=i;
            this.j=j;
            this.d=d;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length,n=maze[0].length,l=1;
        int visited[][]=new int[m][n];
        Queue<node> queue=new LinkedList<>();
        queue.add(new node(entrance[0],entrance[1],0));
        visited[entrance[0]][entrance[1]]=1;
        maze[entrance[0]][entrance[1]]='+';

        while(l>0){
            node x=queue.remove();
            l-=1;
            if((x.i==0||x.i==m-1||x.j==0||x.j==n-1) && maze[x.i][x.j]=='.')
                return x.d;
            if(x.i+1<m && maze[x.i+1][x.j]=='.'&&visited[x.i+1][x.j]==0){
                queue.add(new node(x.i+1,x.j,x.d+1));
                l+=1;
                visited[x.i+1][x.j]=1;
            }
            if(x.i-1>=0 && maze[x.i-1][x.j]=='.'&&visited[x.i-1][x.j]==0){
                queue.add(new node(x.i-1,x.j,x.d+1));
                l+=1;
                visited[x.i-1][x.j]=1;
            }
            if(x.j+1<n && maze[x.i][x.j+1]=='.'&&visited[x.i][x.j+1]==0){
                queue.add(new node(x.i,x.j+1,x.d+1));
                l+=1;
                visited[x.i][x.j+1]=1;
            }
            if(x.j-1>=0 && maze[x.i][x.j-1]=='.'&&visited[x.i][x.j-1]==0){
                queue.add(new node(x.i,x.j-1,x.d+1));
                l+=1;
                visited[x.i][x.j-1]=1;
            }
        }
        return -1;

    }
}
class Solution {
    class node{
        int i,j;
        public node(int i,int j){
            this.i=i;
            this.j=j;
        }
    
    }
    int m,n,fresh=0,time=0;
    int isvisited[][];
    public void find(Queue<node> queue,int l,int grid[][]){
        while(l>1){
            node x=queue.remove();
            l-=1;
            while(x!=null){
                if(x.i+1<m && isvisited[x.i+1][x.j]==0){
                    isvisited[x.i+1][x.j]=1;
                    queue.add(new node(x.i+1,x.j));
                    l+=1;
                    fresh-=1;
                }
                 if(x.i-1>=0 && isvisited[x.i-1][x.j]==0){
                    isvisited[x.i-1][x.j]=1;
                    queue.add(new node(x.i-1,x.j));
                    l+=1;
                     fresh-=1;
                }
                 if(x.j+1<n && isvisited[x.i][x.j+1]==0){
                    isvisited[x.i][x.j+1]=1;
                    queue.add(new node(x.i,x.j+1));
                    l+=1;
                     fresh-=1;
                }
                 if(x.j-1>=0 && isvisited[x.i][x.j-1]==0){
                    isvisited[x.i][x.j-1]=1;
                    queue.add(new node(x.i,x.j-1));
                    l+=1;
                     fresh-=1;
                }
                x=queue.remove();
                l-=1;
            }
            time+=1;
            queue.add(null);
            l+=1;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<node> queue=new LinkedList<>();
        int l=0;
        m=grid.length;
        n=grid[0].length;
        isvisited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
                if(grid[i][j]==2){
                    isvisited[i][j]=1;
                    node n1=new node(i,j);
                    queue.add(n1);
                    l+=1;
                }
                else if(grid[i][j]==0)
                    isvisited[i][j]=1;
                else
                    fresh+=1;
        }
        if(fresh==0)
            return 0;
        queue.add(null);
        l+=1;
        find(queue,l,grid);
        if(fresh>0)
            return -1;
        return time-1;
    }
}